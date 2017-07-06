package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.APIClient;
import com.sportmonks.data.entity.Fixture;
import com.sportmonks.data.structure.Fixtures;
import com.sportmonks.exceptions.HaveToDefineValidDateException;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

/**
 * Proxy Fixtures
 */
public class FixturesEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/fixtures";
	private static final String BY_ID_URL = BASE_URL + "/{fixtureId}";
	private static final String BY_DATE_URL = BASE_URL + "/date/{date}";
	private static final String BY_DATE_RANGE_URL = BASE_URL + "/{from}/{to}";
	private static FixturesEndPoint INSTANCE;
	private long lastFixtureProxyCall = 0;

	private FixturesEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}

	/**
	 * Singleton
	 *
	 * @return
	 */
	public static FixturesEndPoint getInstance() {
		return getInstance(APIClient.CLASSIC_PLAN_RATE_LIMIT);
	}

	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static FixturesEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null) {
			INSTANCE = new FixturesEndPoint(customHourRateLimit);
		}

		return INSTANCE;
	}

	/**
	 * @param url
	 * @param params
	 * @return
	 */
	private Fixture find(final String url, final FixturesEndPointParams params) {

		lastFixtureProxyCall = waitBeforeNextCall(lastFixtureProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("fixtureId", params.getFixtureId().toString());
			}
		}

		final HttpResponse<Fixture> httpResponse = RestTool.get(url, paramsMap, Fixture.class);
		try {
			return httpResponse.getBody();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @param FixtureId
	 * @return
	 * @throws NotFoundException
	 */
	public Fixture findOne(final Integer FixtureId) throws NotFoundException {
		final FixturesEndPointParams params = new FixturesEndPointParams();
		params.setFixtureId(FixtureId);
		return findOne(params);
	}

	/**
	 * @param date
	 * @return
	 * @throws NotFoundException
	 */
	public Fixture findByDate(final String date) throws NotFoundException {
		final FixturesEndPointParams params = new FixturesEndPointParams();
		params.setDate(date);
		return findByDate(params);
	}

	/**
	 * Liste de toutes les Fixturees autorisées avec les relations définies
	 */
	public Fixture findByDate(final FixturesEndPointParams params) {

		if (!params.isValidDate()) {
			throw new HaveToDefineValidDateException();
		}

		return find(BY_DATE_URL, params);
	}

	/**
	* @param from
	* @param to
	* @return
	* @throws NotFoundException
	*/
	public List<Fixture> findByDateRange(final String from, final String to) throws NotFoundException {
		final FixturesEndPointParams params = new FixturesEndPointParams();
		params.setBetweenFromDate(from);
		params.setBetweenToDate(to);
		return findSeverals(BY_DATE_RANGE_URL, params);
	}

	/**
	 * Liste de toutes les Fixturees autorisées avec les relations définies
	 */
	public Fixture findOne(final FixturesEndPointParams params) {

		if (!params.isValidId()) {
			throw new HaveToDefineValidIdException();
		}

		return find(BY_ID_URL, params);
	}

	/**
	 * Liste de toutes les Fixturees autorisées avec les relations définies
	 */
	public List<Fixture> findSeverals(final String url, final FixturesEndPointParams params) {

		lastFixtureProxyCall = waitBeforeNextCall(lastFixtureProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidFromDate()) {
				paramsMap.put("from", params.getBetweenFromDate());
			}
			if (params.isValidToDate()) {
				paramsMap.put("to", params.getBetweenToDate());
			}
		}

		final HttpResponse<Fixtures> httpResponse = RestTool.get(url, paramsMap, Fixtures.class);
		try {
			return httpResponse.getBody().getData();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	/**
	 * Fixturees relations
	 */
	public enum Relation {
		localTeam, visitorTeam, substitutions, goals, cards, other, lineup, bench, stats, comments, tvstations, highlights, league, season, round, stage, referee, events, venue
	}

}
