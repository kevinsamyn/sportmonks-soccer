package com.sportmonks.endpoints;

import com.mashape.unirest.http.HttpResponse;
import com.sportmonks.data.entity.Market;
import com.sportmonks.data.structure.Markets;
import com.sportmonks.data.structure.OneMarket;
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
public class MarketsEndPoint extends AbstractEndPoint {

    private static final String BASE_URL = AbstractEndPoint.API_URL + AbstractEndPoint.VERSION + "/markets";
    private static final String BY_ID_URL = BASE_URL + "/{marketId}";

    private static MarketsEndPoint INSTANCE;
    private long lastCall = 0;

    private MarketsEndPoint(final Double hourRateLimit) {
        super(hourRateLimit);
    }

    /**
     * Creation d'une instance avec une limite d'appel par heure personnalisée
     *
     * @param customHourRateLimit : APIClient.FREE_PLAN_RATE_LIMIT, APIClient.CLASSIC_PLAN_RATE_LIMIT
     * @return
     */
    public static MarketsEndPoint getInstance(final Double customHourRateLimit) {
        if (INSTANCE == null) {
            INSTANCE = new MarketsEndPoint(customHourRateLimit);
        }

        return INSTANCE;
    }

    private Market findUnique(final String url, final MarketsEndPointParams params) throws NotFoundException {

        lastCall = waitBeforeNextCall(lastCall);

        final List<Market> response = new ArrayList<>();

        final Map<String, String> paramsMap = new HashMap<>();
        if (params != null) {
            paramsMap.put("includes", params.getRelations());
            if (params.isValidId()) {
                paramsMap.put("marketId", String.valueOf(params.getMarketId()));
            }
        }

        final HttpResponse<OneMarket> httpResponse = RestTool.get(BY_ID_URL, paramsMap, OneMarket.class);
        if (httpResponse == null) {
            throw new NotFoundException();
        }
        final OneMarket body = httpResponse.getBody();
        if (body == null) {
            throw new NotFoundException();
        }
        final Market market = body.getData();
        if (market == null) {
            throw new NotFoundException();
        }

        return market;
    }

    /**
     * @param marketId
     * @return
     * @throws NotFoundException
     */
    public Market findById(final Integer marketId) throws NotFoundException {
        final MarketsEndPointParams params = new MarketsEndPointParams();
        params.setMarketId(marketId);
        return findOne(params);
    }

    /**
     * Liste de toutes les competitions autorisées avec les relations définies
     */
    public Market findOne(final MarketsEndPointParams params) throws NotFoundException {

        if (!params.isValidId()) {
            throw new HaveToDefineValidIdException();
        }

        final Market Market = findUnique(BY_ID_URL, params);
        if (null == Market) {
            throw new NotFoundException();
        }

        return Market;
    }

    /**
     * Liste de toutes les saisons autorisées avec les relations définies
     */
    public List<Market> findAll(final MarketsEndPointParams params) {
        if (null != params) {
            params.setMarketId(null);
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
    private List<Market> findResults(final String url, final MarketsEndPointParams params) {

        lastCall = waitBeforeNextCall(lastCall);

        final Map<String, String> paramsMap = new HashMap<>();
        if (params != null) {
            paramsMap.put("includes", params.getRelations());
            if (params.isValidId()) {
                paramsMap.put("marketId", params.getMarketId().toString());
            }
        }

        final HttpResponse<Markets> httpResponse = RestTool.get(url, paramsMap, Markets.class);
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
