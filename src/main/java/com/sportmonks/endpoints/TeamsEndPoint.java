package com.sportmonks.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Team;
import com.sportmonks.data.structure.OneTeam;
import com.sportmonks.data.structure.Teams;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

/**
 * Proxy Teams
 */
public class TeamsEndPoint extends AbstractEndPoint {

	private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/teams";
	private static final String BY_ID_URL = BASE_URL + "/{teamId}";
	private static final String BY_SEASON_URL = BASE_URL + "/season/{seasonId}";

	private static TeamsEndPoint INSTANCE;
	private long lastTeamProxyCall = 0;

	private TeamsEndPoint(final Double hourRateLimit) {
		super(hourRateLimit);
	}

	/**
	 * Creation d'une instance avec une limite d'appel par heure personnalisée
	 *
	 * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
	 *
	 * @return
	 */
	public static TeamsEndPoint getInstance(final Double customHourRateLimit) {
		if (INSTANCE == null) {
			INSTANCE = new TeamsEndPoint(customHourRateLimit);
		}

		return INSTANCE;
	}

	/**
	 * @param teamId
	 * @return
	 * @throws NotFoundException
	 */
	public Team findById(final Long teamId) throws NotFoundException {
		final TeamsEndPointParams params = new TeamsEndPointParams();
		params.setTeamId(teamId);
		return findById(params);
	}

	/**
	 * Liste de toutes les équipe d'une saison avec les relations définies
	 *
	 * @param params
	 * @return
	 * @throws NotFoundException
	 */
	public Team findById(final TeamsEndPointParams params) throws NotFoundException {

		if (!params.isValidTeamId()) {
			throw new HaveToDefineValidIdException();
		}

		return findUnique(params);
	}

	/**
	 * Liste de toutes les équipes d'une saison
	 *
	 * @param seasonId
	 * @return
	 */
	public List<Team> findBySeason(final Long seasonId) {
		final TeamsEndPointParams params = new TeamsEndPointParams();
		params.setSeasonId(seasonId);
		return findBySeason(params);
	}

	/**
	 * Liste de toutes les équipes pour une saison avec les relations définies
	 */
	public List<Team> findBySeason(final TeamsEndPointParams params) {

		if (!params.isValidSeasonId()) {
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
	private List<Team> findResults(final String url, final TeamsEndPointParams params) {

		lastTeamProxyCall = waitBeforeNextCall(lastTeamProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidTeamId()) {
				paramsMap.put("teamId", params.getTeamId().toString());
			}
			if (params.isValidSeasonId()) {
				paramsMap.put("seasonId", params.getSeasonId().toString());
			}
		}

		final HttpResponse<Teams> httpResponse = RestTool.get(url, paramsMap, Teams.class);

		final List<Team> response = new ArrayList<>();
		response.addAll(httpResponse.getBody().getData());

		return response;
	}

	/**
	 * Retourne un résultat unique
	 *
	 * @param params
	 * @return
	 */
	private Team findUnique(final TeamsEndPointParams params) throws NotFoundException {

		lastTeamProxyCall = waitBeforeNextCall(lastTeamProxyCall);

		final Map<String, String> paramsMap = new HashMap<>();
		if (params != null) {
			paramsMap.put("includes", params.getRelations());
			if (params.isValidTeamId()) {
				paramsMap.put("teamId", params.getTeamId().toString());
			}
		}


		final HttpResponse<OneTeam> httpResponse = RestTool.get(BY_ID_URL, paramsMap, OneTeam.class);
		final OneTeam body = httpResponse.getBody();
		if (body == null) {
			throw new NotFoundException();
		}
		final Team league = body.getData();
		if (league == null) {
			throw new NotFoundException();
		}

		return league;
	}

	/**
	 * Team relations
	 */
	public enum Relation {
		country, squad, coach, transfers, sidelined, stats, venue, fifaranking, uefaranking
	}

}
