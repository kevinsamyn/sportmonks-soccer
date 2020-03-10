package com.sportmonks.endpoints;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Bookmaker;
import com.sportmonks.data.structure.Bookmakers;
import com.sportmonks.data.structure.OneBookmaker;
import com.sportmonks.exceptions.HaveToDefineValidIdException;
import com.sportmonks.exceptions.NotFoundException;
import com.sportmonks.tools.RestTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Proxy Teams
 */
public class BookmakersEndPoint extends AbstractEndPoint {

    private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/bookmakers";
    private static final String BY_ID_URL = BASE_URL + "/{bookmakerId}";

    private static BookmakersEndPoint INSTANCE;
    private long lastCall = 0;

    private BookmakersEndPoint(final Double hourRateLimit) {
        super(hourRateLimit);
    }

    /**
     * Creation d'une instance avec une limite d'appel par heure personnalisée
     *
     * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
     * @return
     */
    public static BookmakersEndPoint getInstance(final Double customHourRateLimit) {
        if (INSTANCE == null) {
            INSTANCE = new BookmakersEndPoint(customHourRateLimit);
        }

        return INSTANCE;
    }

    private Bookmaker findUnique(final String url, final BookmakersEndPointParams params) throws NotFoundException {

        lastCall = waitBeforeNextCall(lastCall);

        final List<Bookmaker> response = new ArrayList<>();

        final Map<String, String> paramsMap = new HashMap<>();
        if (params != null) {
            paramsMap.put("includes", params.getRelations());
            if (params.isValidId()) {
                paramsMap.put("bookmakerId", String.valueOf(params.getBookmakerId()));
            }
        }

        final HttpResponse<OneBookmaker> httpResponse = RestTool.get(BY_ID_URL, paramsMap, OneBookmaker.class);
        if (httpResponse == null) {
            throw new NotFoundException();
        }
        final OneBookmaker body = httpResponse.getBody();
        if (body == null) {
            throw new NotFoundException();
        }
        final Bookmaker bookmaker = body.getData();
        if (bookmaker == null) {
            throw new NotFoundException();
        }

        return bookmaker;
    }

    /**
     * @param bookmakerId
     * @return
     * @throws NotFoundException
     */
    public Bookmaker findById(final Integer bookmakerId) throws NotFoundException {
        final BookmakersEndPointParams params = new BookmakersEndPointParams();
        params.setBookmakerId(bookmakerId);
        return findOne(params);
    }

    /**
     * Liste de toutes les competitions autorisées avec les relations définies
     */
    public Bookmaker findOne(final BookmakersEndPointParams params) throws NotFoundException {

        if (!params.isValidId()) {
            throw new HaveToDefineValidIdException();
        }

        final Bookmaker Bookmaker = findUnique(BY_ID_URL, params);
        if (null == Bookmaker) {
            throw new NotFoundException();
        }

        return Bookmaker;
    }

    /**
     * Liste de toutes les saisons autorisées avec les relations définies
     */
    public List<Bookmaker> findAll(final BookmakersEndPointParams params) {
        if (null != params) {
            params.setBookmakerId(null);
        }
        return findResults(BASE_URL, params);
    }

    /**
     * Retourne une liste de résultat
     *
     * @param url
     * @param params
     * @return
     */
    private List<Bookmaker> findResults(final String url, final BookmakersEndPointParams params) {

        lastCall = waitBeforeNextCall(lastCall);

        final Map<String, String> paramsMap = new HashMap<>();
        if (params != null) {
            paramsMap.put("includes", params.getRelations());
            if (params.isValidId()) {
                paramsMap.put("bookmakerId", params.getBookmakerId().toString());
            }
        }

        final HttpResponse<Bookmakers> httpResponse = RestTool.get(url, paramsMap, Bookmakers.class);
        if (httpResponse == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(httpResponse.getBody().getData());

    }

    /**
     * TvStation relations
     */
    public enum Relation {
    }

}
