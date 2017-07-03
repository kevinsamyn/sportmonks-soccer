package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.League;
import com.sportmonks.data.structure.Leagues;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

public class LeaguesEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/leagues";
	private static final String BY_ID_URL = BASE_URL + "/{leagueId}";
	private static LeaguesEndPoint INSTANCE;

	private long lastLeagueProxyCall = 0;

	private LeaguesEndPoint() {
		// Hide constructor
	}

	/**
	 * Singleton
	 *
	 * @return
	 */
	public static LeaguesEndPoint getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LeaguesEndPoint();
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
		return find(BASE_URL, params);
	}

	private List<League> find(final String url, final LeaguesEndPointParams params) {

		lastLeagueProxyCall = waitBeforeNextCall(lastLeagueProxyCall);

		final List<League> response = new ArrayList<>();

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("leagueId", params.getLeagueId().toString());
			}
		}

		final HttpResponse<Leagues> httpResponse = RestTool.get(url, paramsMap, Leagues.class);
		final Leagues body = httpResponse.getBody();
		if (body != null) {
			response.addAll(body.getData());
		}

		return response;
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

		final List<League> all = find(BY_ID_URL, params);
		if (all.isEmpty()) {
			throw new NotFoundException();
		}

		return all.get(0);
	}

	/**
	 * Leagues relations
	 */
	public enum Relation {
		country, fixtures, season, seasons
	}

}
