package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.APIClient;
import com.sportmonks.data.entity.Venue;
import com.sportmonks.data.structure.Venues;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

/**
 * Created by kevin on 28/05/2016.
 */
public class VenuesEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/venues";
	private static final String BY_ID_URL = BASE_URL + "/{venueId}";
	private static VenuesEndPoint INSTANCE;

	private long lastCall = 0;

	private VenuesEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}

	/**
	 * Singleton
	 *
	 * @return
	 */
	public static VenuesEndPoint getInstance() {
		return getInstance(APIClient.CLASSIC_PLAN_RATE_LIMIT);
	}

	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static VenuesEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null) {
			INSTANCE = new VenuesEndPoint(customHourRateLimit);
		}

		return INSTANCE;
	}

	private Venue findUnique(final String url, final VenuesEndPointParams params) {

		lastCall = waitBeforeNextCall(lastCall);

		final List<Venue> response = new ArrayList<>();

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("VenueId", String.valueOf(params.getVenueId()));
			}
		}

		final HttpResponse<Venues> httpResponse = RestTool.get(url, paramsMap, Venues.class);
		final Venues body = httpResponse.getBody();
		if (body != null) {
			return body.getData();
		}

		return null;
	}

	/**
	 * @param venueId
	 * @return
	 * @throws NotFoundException
	 */
	public Venue findById(final Integer venueId) throws NotFoundException {
		final VenuesEndPointParams params = new VenuesEndPointParams();
		params.setVenueId(venueId);
		return findOne(params);
	}

	/**
	 * Liste de toutes les competitions autorisées avec les relations définies
	 */
	public Venue findOne(final VenuesEndPointParams params) throws NotFoundException {

		if (!params.isValidId()) {
			throw new HaveToDefineValidIdException();
		}

		final Venue Venue = findUnique(BY_ID_URL, params);
		if (null == Venue) {
			throw new NotFoundException();
		}

		return Venue;
	}

	/**
	 * Competitions relations
	 */
	public enum Relation {
	}
}
