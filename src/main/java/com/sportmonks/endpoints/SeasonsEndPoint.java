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

	private SeasonsEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}

	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static SeasonsEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null)
			INSTANCE = new SeasonsEndPoint(customHourRateLimit);

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
	public Season findOne(final Long seasonId) throws NotFoundException {
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
	public Season findOne(final SeasonsEndPointParams params) throws NotFoundException {

		lastSeasonProxyCall = waitBeforeNextCall(lastSeasonProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("seasonId", params.getSeasonId().toString());
			}
		}

		final HttpResponse<Seasons> httpResponse = RestTool.get(BY_ID_URL, paramsMap, Seasons.class);
		if (httpResponse != null) {
			final Seasons seasons = httpResponse.getBody();
			final List<Season> data = seasons.getData();
			if (data == null || data.isEmpty()) {
				throw new NotFoundException();
			} else {
				return data.get(0);
			}
		} else {
			throw new NotFoundException();
		}
	}

	/**
	 * Seasoon relations
	 */
	public enum Relation {
		league, stages, rounds, fixtures, upcoming, results;
	}

}
