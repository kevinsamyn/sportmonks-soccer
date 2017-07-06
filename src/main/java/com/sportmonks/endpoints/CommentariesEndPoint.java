package com.sportmonks.endpoints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Comment;
import com.sportmonks.data.structure.Commentaries;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.tools.RestTool;

/**
 * Proxy Matchs
 */
public class CommentariesEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/commentaries";
	private static final String BY_ID_URL = BASE_URL + "/fixture/{fixtureId}";
	private static CommentariesEndPoint INSTANCE;
	private long lastCall = 0;

	private CommentariesEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}

	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static CommentariesEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null)
			INSTANCE = new CommentariesEndPoint(customHourRateLimit);

		return INSTANCE;
	}

	/**
	 * @param fixtureId
	 * @return
	 */
	public List<Comment> findByFixture(final Integer fixtureId) {
		final CommentariesProxyParams params = new CommentariesProxyParams();
		params.setFixtureId(fixtureId);
		return findByFixture(params);
	}

	/**
	 * @param params
	 * @return
	 */
	private List<Comment> findByFixture(final CommentariesProxyParams params) {
		if (!params.isValidFixtureId()) {
			throw new HaveToDefineValidIdException();
		}

		return find(BY_ID_URL, params);
	}

	/**
	 * @param url
	 * @param params
	 * @return
	 */
	private List<Comment> find(final String url, final CommentariesProxyParams params) {

		lastCall = waitBeforeNextCall(lastCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			if (params.isValidFixtureId()) {
				paramsMap.put("fixtureId", params.getFixtureId().toString());
			}
		}

		final HttpResponse<Commentaries> httpResponse = RestTool.get(url, paramsMap, Commentaries.class);

		return httpResponse.getBody().getData();
	}

}
