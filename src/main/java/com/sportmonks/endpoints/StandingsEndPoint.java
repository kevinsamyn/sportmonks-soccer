package com.sportmonks.endpoints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.StandingGroup;
import com.sportmonks.data.structure.Standings;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.tools.RestTool;

/**
 * Proxy Teams
 */
public class StandingsEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/standings";
	private static final String BY_SEASON_URL = BASE_URL + "/season/{seasonId}";

	private static StandingsEndPoint INSTANCE;
	private long lastStandingProxyCall = 0;

	private StandingsEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}

	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static StandingsEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null) {
			INSTANCE = new StandingsEndPoint(customHourRateLimit);
		}

		return INSTANCE;
	}

	/**
	 * Liste de toutes les équipes d'une saison
	 *
	 * @param seasonId
	 * @return
	 */
	public List<StandingGroup> findBySeason(final Integer seasonId) {
		final StandingsEndPointParams params = new StandingsEndPointParams();
		params.setSeasonId(seasonId);
		return findBySeason(params);
	}

	/**
	 * Liste de toutes les équipes pour une saison avec les relations définies
	 */
	public List<StandingGroup> findBySeason(final StandingsEndPointParams params) {

		if (!params.isValidId()) {
			throw new HaveToDefineValidIdException();
		}

		return findResults(BY_SEASON_URL, params);
	}

	/**
	 * Retourne une liste de résultat
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	private List<StandingGroup> findResults(final String url, final StandingsEndPointParams params) {

		lastStandingProxyCall = waitBeforeNextCall(lastStandingProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", "");
			if (params.isValidId()) {
				paramsMap.put("seasonId", params.getSeasonId().toString());
			}
		}

		final HttpResponse<Standings> httpResponse = RestTool.get(url, paramsMap, Standings.class);

		return httpResponse.getBody().getData();
	}

}
