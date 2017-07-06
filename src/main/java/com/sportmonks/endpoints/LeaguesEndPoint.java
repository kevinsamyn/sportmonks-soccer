package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.League;
import com.sportmonks.data.structure.Leagues;
import com.sportmonks.data.structure.OneLeague;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

public class LeaguesEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/leagues";
	private static final String BY_ID_URL = BASE_URL + "/{id}";
	private static LeaguesEndPoint INSTANCE;

	private long lastCall = 0;

	private LeaguesEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}

	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static LeaguesEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null) {
			INSTANCE = new LeaguesEndPoint(customHourRateLimit);
		}

		return INSTANCE;
	}

	/**
	 * Retourne la liste de toutes les compétitions autorisées
	 *
	 * @return {@List<@League>}
	 */
	public List<League> findAll() {
		return findAll(null);
	}

	/**
	 * Liste de toutes les Leagues autorisées avec les relations définies
	 */
	public List<League> findAll(final LeaguesEndPointParams params) {
		if (null != params) {
			params.setLeagueId(null);
		}
		return findSeverals(BASE_URL, params);
	}

	private List<League> findSeverals(final String url, final LeaguesEndPointParams params) {

		lastCall = waitBeforeNextCall(lastCall);

		final List<League> response = new ArrayList<>();

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("id", params.getLeagueId().toString());
			}
		}

		final HttpResponse<Leagues> httpResponse = RestTool.get(url, paramsMap, Leagues.class);
		final Leagues body = httpResponse.getBody();
		if (body != null) {
			response.addAll(body.getData());
		}

		return response;
	}

	private League findUnique(final LeaguesEndPointParams params) throws NotFoundException {

		lastCall = waitBeforeNextCall(lastCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("id", String.valueOf(params.getLeagueId()));
			}
		}

		final HttpResponse<OneLeague> httpResponse = RestTool.get(BY_ID_URL, paramsMap, OneLeague.class);
		final OneLeague body = httpResponse.getBody();
		if (body == null) {
			throw new NotFoundException();
		}
		final League league = body.getData();
		if (league == null) {
			throw new NotFoundException();
		}

		return league;
	}

	/**
	 * @param LeagueId
	 * @return
	 * @throws NotFoundException
	 */
	public League findOne(final Integer LeagueId) throws NotFoundException {
		final LeaguesEndPointParams params = new LeaguesEndPointParams();
		params.setLeagueId(LeagueId);
		return findOne(params);
	}

	/**
	 * Liste de toutes les Leagues autorisées avec les relations définies
	 */
	public League findOne(final LeaguesEndPointParams params) throws NotFoundException {

		if (!params.isValidId()) {
			throw new HaveToDefineValidIdException();
		}

		return findUnique(params);
	}

	/**
	 * Leagues relations
	 */
	public enum Relation {
		country, fixtures, season, seasons
	}

}
