package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Season;
import com.sportmonks.data.structure.Seasons;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

/**
 * Proxy Seasons
 */
public class SeasonsEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/seasons";
	private static final String BY_ID_URL = BASE_URL + "/{seasonId}";
	private static SeasonsEndPoint INSTANCE;
	private long lastSeasonProxyCall = 0;

	private SeasonsEndPoint() {
		// Hide constructor
	}

	/**
	 * Singleton
	 *
	 * @return
	 */
	public static SeasonsEndPoint getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SeasonsEndPoint();

		return INSTANCE;
	}

	/**
	 * Retourne la liste de toutes les saisons autorisées
	 *
	 * @return {@List<@Season>}
	 */
	public List<Season> findAll() {
		return findAll(null);
	}

	/**
	 * Liste de toutes les saisons autorisées avec les relations définies
	 */
	public List<Season> findAll(final SeasonsEndPointParams params) {
		if (null != params) {
			params.setSeasonId(null);
		}
		return find(BASE_URL, params);
	}

	private List<Season> find(final String url, final SeasonsEndPointParams params) {

		lastSeasonProxyCall = waitBeforeNextCall(lastSeasonProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("seasonId", params.getSeasonId().toString());
			}
		}

		final HttpResponse<Seasons> httpResponse = RestTool.get(url, paramsMap, Seasons.class);

		final List<Season> response = new ArrayList<>();
		response.addAll(httpResponse.getBody().getData());

		return response;
	}

	/**
	 * @param seasonId
	 * @return
	 * @throws NotFoundException
	 */
	public Season findOne(final Integer seasonId) throws NotFoundException {
		final SeasonsEndPointParams params = new SeasonsEndPointParams();
		params.setSeasonId(seasonId);
		return findOne(params);
	}

	/**
	 * Retourne un résultat unique
	 *
	 * @param params
	 * @return
	 */
	public Season findOne(final SeasonsEndPointParams params) {

		lastSeasonProxyCall = waitBeforeNextCall(lastSeasonProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("id", params.getSeasonId().toString());
			}
		}

		final HttpResponse<Season> httpResponse = RestTool.get(BY_ID_URL, paramsMap, Season.class);

		return httpResponse.getBody();
	}

	/**
	 * Seasoon relations
	 */
	public enum Relation {
		league, stages, rounds, fixtures
	}

}
