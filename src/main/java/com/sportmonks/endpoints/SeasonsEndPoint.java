package com.sportmonks.endpoints;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Season;
import com.sportmonks.data.structure.OneSeason;
import com.sportmonks.data.structure.Seasons;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Proxy Seasons
 */
public class SeasonsEndPoint extends AbstractEndPoint {

    private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/seasons";
    private static final String BY_ID_URL = BASE_URL + "/{id}";
    private static SeasonsEndPoint INSTANCE;
    private long lastCall = 0;

    private SeasonsEndPoint(final Double hourRateLimit) {
        super(hourRateLimit);
    }

    /**
     * Creation d'une instance avec une limite d'appel par heure personnalisée
     *
     * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
     * @return SeasonsEndPoint
     */
    public static SeasonsEndPoint getInstance(final Double customHourRateLimit) {
        if (INSTANCE == null)
            INSTANCE = new SeasonsEndPoint(customHourRateLimit);

        return INSTANCE;
    }

    /**
     * Retourne la liste de toutes les saisons autorisées
     *
     * @return List of {@link Season}
     */
    public List<Season> findAll() {
        return findAll(null);
    }

    /**
     * Liste de toutes les saisons autorisées avec les relations définies
     *
     * @param params d'appel de l'API
     * @return List of {@link Season}
     */
    public List<Season> findAll(final SeasonsEndPointParams params) {
        if (null != params) {
            params.setSeasonId(null);
        }
        return findSeverals(BASE_URL, params);
    }

    private List<Season> findSeverals(final String url, final SeasonsEndPointParams params) {

        lastCall = waitBeforeNextCall(lastCall);

        final Map<String, String> paramsMap = new HashMap<>();
        if (params != null) {
            paramsMap.put("includes", params.getRelations());
            if (params.isValidId()) {
                paramsMap.put("id", params.getSeasonId().toString());
            }
        }

        final HttpResponse<Seasons> httpResponse = RestTool.get(url, paramsMap, Seasons.class);

        final List<Season> response = new ArrayList<>();
        response.addAll(httpResponse.getBody().getData());

        return response;
    }

    /**
     * @param params d'appel de l'API
     * @return Season
     * @throws NotFoundException si season n'existe pas
     */
    public Season findOne(final SeasonsEndPointParams params) throws NotFoundException {

        if (!params.isValidId()) {
            throw new HaveToDefineValidIdException();
        }
        return findUnique(params);
    }

    /**
     * @param seasonId id de la saison
     * @return Season
     * @throws NotFoundException si season n'existe pas
     */
    public Season findOne(final Long seasonId) throws NotFoundException {
        final SeasonsEndPointParams params = new SeasonsEndPointParams();
        params.setSeasonId(seasonId);
        return findUnique(params);
    }

    /**
     * Retourne un résultat unique
     *
     * @param params d'appel de l'API
     * @return Season
     * @throws NotFoundException si season n'existe pas
     */
    public Season findUnique(final SeasonsEndPointParams params) throws NotFoundException {

        lastCall = waitBeforeNextCall(lastCall);

        final Map<String, String> paramsMap = new HashMap<>();
        if (params != null) {
            paramsMap.put("includes", params.getRelations());
            if (params.isValidId()) {
                paramsMap.put("id", params.getSeasonId().toString());
            }
        }

        final HttpResponse<OneSeason> httpResponse = RestTool.get(BY_ID_URL, paramsMap, OneSeason.class);
        if (httpResponse != null) {
            final OneSeason body = httpResponse.getBody();
            if (body == null) {
                throw new NotFoundException();
            }

            final Season season = body.getData();
            if (season == null) {
                throw new NotFoundException();
            }

            return season;
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
