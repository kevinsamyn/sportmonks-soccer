package com.sportmonks.endpoints;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Market;
import com.sportmonks.data.structure.PreMatchOdds;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.tools.RestTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Proxy Teams
 */
public class PreMatchOddsEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/odds";
	private static final String BY_FIXTURE_URL = BASE_URL + "/fixture/{fixtureId}";
	private static final String BY_FIXTURE_AND_BOOKMAKER_URL = BASE_URL + "/fixture/{fixtureId}/bookmaker/{bookmakerId}";

	private static PreMatchOddsEndPoint INSTANCE;
	private long lastOddProxyCall = 0;

	private PreMatchOddsEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}

	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static PreMatchOddsEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null) {
			INSTANCE = new PreMatchOddsEndPoint(customHourRateLimit);
		}

		return INSTANCE;
	}

	/**
	 * @param fixtureId
	 * @return
	 */
	public List<Market> findByFixture(final Long fixtureId) {
		final PreMatchOddsEndPointParams params = new PreMatchOddsEndPointParams();
		params.setBookmakerId(null);
		params.setFixtureId(fixtureId);
		return findByFixture(params);
	}

	/**
	 * @param params
	 * @return
	 */
	public List<Market> findByFixture(final PreMatchOddsEndPointParams params) {

		if (!params.isValidFixtureId()) {
			throw new HaveToDefineValidIdException();
		}

		return findResults(BY_FIXTURE_URL, params);
	}

	/**
	 * @param fixtureId
	 * @return
	 */
	public List<Market> findByFixtureAndBookmaker(final Long fixtureId, final Long bookmakerId) {
		final PreMatchOddsEndPointParams params = new PreMatchOddsEndPointParams();
		params.setFixtureId(fixtureId);
		params.setBookmakerId(bookmakerId);
		return findByFixtureAndBookmaker(params);
	}

	/**
	 * @param params
	 * @return
	 */
	public List<Market> findByFixtureAndBookmaker(final PreMatchOddsEndPointParams params) {

		if (!params.isValidFixtureId()) {
			throw new HaveToDefineValidIdException();
		}
		if (!params.isValidBookmakerId()) {
			throw new HaveToDefineValidIdException();
		}

		return findResults(BY_FIXTURE_AND_BOOKMAKER_URL, params);
	}

	/**
	 * @param url
	 * @param params
	 * @return
	 */
	private List<Market> findResults(final String url, final PreMatchOddsEndPointParams params) {

		lastOddProxyCall = waitBeforeNextCall(lastOddProxyCall);

		final List<Market> response = new ArrayList<>();

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", "");
			if (params.isValidFixtureId()) {
				paramsMap.put("fixtureId", params.getFixtureId().toString());
			}
			if (params.isValidBookmakerId()) {
				paramsMap.put("bookmakerId", params.getBookmakerId().toString());
			}
		}

		final HttpResponse<PreMatchOdds> httpResponse = RestTool.get(url, paramsMap, PreMatchOdds.class);
		final PreMatchOdds body = httpResponse.getBody();
		if (body != null) {
			return body.getData();
		}

		return response;
	}

}
