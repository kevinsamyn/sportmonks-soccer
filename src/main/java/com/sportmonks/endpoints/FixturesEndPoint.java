package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Fixture;
import com.sportmonks.data.structure.Fixtures;
import com.sportmonks.data.structure.OneFixture;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

/**
 * Proxy Fixtures
 */
public class FixturesEndPoint extends AbstractEndPoint {

	public static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/fixtures";
	public static final String BY_ID_URL = BASE_URL + "/{fixtureId}";
	public static final String BY_DATE_URL = BASE_URL + "/date/{date}";
	public static final String BY_DATE_RANGE_URL = BASE_URL + "/between/{from}/{to}";

	private static FixturesEndPoint INSTANCE;
	private long lastFixtureProxyCall = 0;

	private FixturesEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
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
	 * @param params
	 * @return
	 */
	private Fixture findUnique(final FixturesEndPointParams params) throws NotFoundException {

		lastFixtureProxyCall = waitBeforeNextCall(lastFixtureProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("fixtureId", params.getFixtureId().toString());
			}
		}

		final HttpResponse<OneFixture> httpResponse = RestTool.get(BY_ID_URL, paramsMap, OneFixture.class);
		if (httpResponse != null) {
			final OneFixture body = httpResponse.getBody();
			if (body == null) {
				throw new NotFoundException();
			}

			final Fixture fixture = body.getData();
			if (fixture == null) {
				throw new NotFoundException();
			}
			return fixture;
		} else {
			throw new NotFoundException();
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
	 * Liste de toutes les Fixturees autorisées avec les relations définies
	 */
	public Fixture findOne(final FixturesEndPointParams params) throws NotFoundException {

		if (!params.isValidId()) {
			throw new HaveToDefineValidIdException();
		}

		return findUnique(params);
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
			List<Fixture> data = httpResponse.getBody().getData();
			if(data == null){
				data = new ArrayList<>();
			}

			return data;
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
