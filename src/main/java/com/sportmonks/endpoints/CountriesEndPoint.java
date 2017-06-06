package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Country;
import com.sportmonks.data.structure.Countries;
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

	private long lastCountryProxyCall = 0;

	private CountriesEndPoint() {
		// Hide constructor
	}

	/**
	 * Singleton
	 *
	 * @return
	 */
	public static CountriesEndPoint getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CountriesEndPoint();
		}

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
		return find(BASE_URL, params);
	}

	private List<Country> find(final String url, final CountriesEndPointParams params) {

		lastCountryProxyCall = waitBeforeNextCall(lastCountryProxyCall);

		final List<Country> response = new ArrayList<>();

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidCountryId()) {
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

		if (!params.isValidCountryId()) {
			throw new HaveToDefineValidIdException();
		}

		final List<Country> all = find(BY_ID_URL, params);
		if (all.isEmpty()) {
			throw new NotFoundException();
		}

		return all.get(0);
	}

	/**
	 * Competitions relations
	 */
	public enum Relation {
		continent, leagues
	}
}
