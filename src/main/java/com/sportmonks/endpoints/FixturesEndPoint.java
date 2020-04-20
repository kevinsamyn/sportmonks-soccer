package com.sportmonks.endpoints;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Fixture;
import com.sportmonks.data.structure.Fixtures;
import com.sportmonks.data.structure.OneFixture;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Proxy Fixtures
 */
public class FixturesEndPoint extends AbstractEndPoint {

    public static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/fixtures";
    public static final String BY_ID_URL = BASE_URL + "/{fixtureId}";
    public static final String BY_DATE_URL = BASE_URL + "/date/{date}";
    public static final String BY_DATE_RANGE_URL = BASE_URL + "/between/{from}/{to}";
    public static final String BY_DATE_RANGE_FOR_TEAM_URL = BASE_URL + "/between/{from}/{to}/{team}";

    private static FixturesEndPoint INSTANCE;
    private long lastFixtureProxyCall = 0;

    private FixturesEndPoint(final Double hourRateLimit) {
        super(hourRateLimit);
    }

    /**
     * Creation d'une instance avec une limite d'appel par heure personnalisée
     *
     * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
     * @return FixturesEndPoint
     */
    public static FixturesEndPoint getInstance(final Double customHourRateLimit) {
        if (INSTANCE == null) {
            INSTANCE = new FixturesEndPoint(customHourRateLimit);
        }

        return INSTANCE;
    }

    /**
     * @param params
     * @return
     */
    private Fixture findUnique(final FixturesEndPointParams params) throws NotFoundException {

        lastFixtureProxyCall = waitBeforeNextCall(lastFixtureProxyCall);

        final Map<String, String> paramsMap = new HashMap<>();
        if (params != null) {
            paramsMap.put("includes", params.getRelations());
            if (params.isValidId()) {
                paramsMap.put("fixtureId", params.getFixtureId().toString());
            }
        }

        final HttpResponse<OneFixture> httpResponse = RestTool.get(BY_ID_URL, paramsMap, OneFixture.class);
        if (httpResponse != null) {
            final OneFixture body = httpResponse.getBody();
            if (body == null) {
                throw new NotFoundException();
            }

            final Fixture fixture = body.getData();
            if (fixture == null) {
                throw new NotFoundException();
            }
            return fixture;
        } else {
            throw new NotFoundException();
        }
    }

    /**
     * @param FixtureId id du mathc
     * @return Fixture
     * @throws NotFoundException si match n'existe pas
     */
    public Fixture findOne(final Integer FixtureId) throws NotFoundException {
        final FixturesEndPointParams params = new FixturesEndPointParams();
        params.setFixtureId(FixtureId);
        return findOne(params);
    }

    /**
     * @param params d'appel
     * @return Fixture
     * @throws NotFoundException si match n'existe pas
     */
    public Fixture findOne(final FixturesEndPointParams params) throws NotFoundException {

        if (!params.isValidId()) {
            throw new HaveToDefineValidIdException();
        }

        return findUnique(params);
    }

    /**
     * @param date   cible
     * @param params d'appel
     * @return List of {@link Fixture}
     */
    public List<Fixture> findByDate(final Date date, final FixturesEndPointParams params) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        params.setDate(sdf.format(date));
        return findSeverals(BY_DATE_URL, params);
    }

    /**
     * @param fromDate debut periode
     * @param toDate   fin periode
     * @param params   d'appel
     * @return List of {@link Fixture}
     */
    public List<Fixture> findByDateRange(final Date fromDate, final Date toDate, final FixturesEndPointParams params) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        params.setBetweenFromDate(sdf.format(fromDate));
        params.setBetweenToDate(sdf.format(toDate));
        return findSeverals(BY_DATE_RANGE_URL, params);
    }

    /**
     * @param fromDate debut periode
     * @param toDate   fin periode
     * @param teamId   id equipe
     * @param params   d'appel
     * @return List of {@link Fixture}
     */
    public List<Fixture> findByDateRangeForTeam(final Date fromDate, final Date toDate, final Integer teamId, final FixturesEndPointParams params) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        params.setBetweenFromDate(sdf.format(fromDate));
        params.setBetweenToDate(sdf.format(toDate));
        params.setTeamId(teamId);
        return findSeverals(BY_DATE_RANGE_FOR_TEAM_URL, params);
    }

    /**
     * Liste de toutes les Fixturees autorisées avec les relations définies
     *
     * @param url    appelée
     * @param params d'appel
     * @return List of {@link Fixture}
     */
    public List<Fixture> findSeverals(final String url, final FixturesEndPointParams params) {

        lastFixtureProxyCall = waitBeforeNextCall(lastFixtureProxyCall);

        final Map<String, String> paramsMap = new HashMap<>();
        if (params != null) {
            paramsMap.put("includes", params.getRelations());
            if (params.isValidDate()) {
                paramsMap.put("date", params.getDate());
            }
            if (params.isValidFromDate()) {
                paramsMap.put("from", params.getBetweenFromDate());
            }
            if (params.isValidToDate()) {
                paramsMap.put("to", params.getBetweenToDate());
            }
            if (params.isValidTeamId()) {
                paramsMap.put("team", params.getTeamId().toString());
            }
        }

        final HttpResponse<Fixtures> httpResponse = RestTool.get(url, paramsMap, Fixtures.class);
        try {
            List<Fixture> data = httpResponse.getBody().getData();
            if (data == null) {
                data = new ArrayList<>();
            }

            return data;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Fixturees relations
     */
    public enum Relation {
        localTeam, visitorTeam, odds, substitutions, goals, cards, other, lineup, bench, stats, comments, tvstations, highlights, league, season, round, stage, referee, events, venue
    }

}
