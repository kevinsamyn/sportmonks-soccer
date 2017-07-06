package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Country;
import com.sportmonks.data.structure.Countries;
import com.sportmonks.data.structure.OneCountry;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

/**
 * Created by kevin on 28/05/2016.
 */
public class CountriesEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/countries";
	private static final String BY_ID_URL = BASE_URL + "/{id}";
	private static CountriesEndPoint INSTANCE;

	private long lastCall = 0;

	private CountriesEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}


	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static CountriesEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null)
			INSTANCE = new CountriesEndPoint(customHourRateLimit);

		return INSTANCE;
	}

	/**
	 * Retourne la liste de toutes les compétitions autorisées
	 *
	 * @return {@List<@Competition>}
	 */
	public List<Country> findAll() {
		return findAll(null);
	}

	/**
	 * Liste de toutes les competitions autorisées avec les relations définies
	 */
	public List<Country> findAll(final CountriesEndPointParams params) {
		if (null != params) {
			params.setCountryId(null);
		}
		return findSeverals(BASE_URL, params);
	}

	private List<Country> findSeverals(final String url, final CountriesEndPointParams params) {

		lastCall = waitBeforeNextCall(lastCall);

		final List<Country> response = new ArrayList<>();

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("id", params.getCountryId().toString());
			}
		}

		final HttpResponse<Countries> httpResponse = RestTool.get(url, paramsMap, Countries.class);
		final Countries body = httpResponse.getBody();
		if (body != null) {
			response.addAll(body.getData());
		}

		return response;
	}

	private Country findUnique(final CountriesEndPointParams params) throws NotFoundException {

		lastCall = waitBeforeNextCall(lastCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidId()) {
				paramsMap.put("id", String.valueOf(params.getCountryId()));
			}
		}

		final HttpResponse<OneCountry> httpResponse = RestTool.get(BY_ID_URL, paramsMap, OneCountry.class);
		final OneCountry body = httpResponse.getBody();
		if (body == null) {
			throw new NotFoundException();
		}
		final Country country = body.getData();
		if (country == null) {
			throw new NotFoundException();
		}

		return country;
	}

	/**
	 * @param countryId
	 * @return
	 * @throws NotFoundException
	 */
	public Country findOne(final Integer countryId) throws NotFoundException {
		final CountriesEndPointParams params = new CountriesEndPointParams();
		params.setCountryId(countryId);
		return findOne(params);
	}

	/**
	 * Liste de toutes les competitions autorisées avec les relations définies
	 */
	public Country findOne(final CountriesEndPointParams params) throws NotFoundException {

		if (!params.isValidId()) {
			throw new HaveToDefineValidIdException();
		}

		return findUnique(params);
	}

	/**
	 * Competitions relations
	 */
	public enum Relation {
		continent, leagues
	}
}
