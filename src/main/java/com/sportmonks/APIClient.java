package com.sportmonks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.sportmonks.endpoints.*;
import com.sportmonks.exceptions.InvalidServiceInstanceException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class APIClient {

    public static final Double FREE_PLAN_RATE_LIMIT = 180.0;
    public static final Double CLASSIC_PLAN_RATE_LIMIT = 2000.0;

    private static APIClient INSTANCE;
    private final Double rateLimit;
    private final String apiToken;

    /**
     * @param apiToken fourni par sportmonks.com
     */
    private APIClient(final String apiToken, final Double rateLimit) {
        super();
        // Hide constructor
        this.apiToken = apiToken;
        this.rateLimit = rateLimit != null ? rateLimit : FREE_PLAN_RATE_LIMIT;

        Unirest.setObjectMapper(createObjectMapper());
        Unirest.setHttpClient(createSSLHttpClient());
    }

    /**
     * Retourne l'instance courante
     *
     * @return APIClient
     */
    public static APIClient getInstance() {
        checkInstance();

        return INSTANCE;
    }

    private static void checkInstance() {
        if (INSTANCE == null || INSTANCE.getApiToken() == null) {
            throw new InvalidServiceInstanceException();
        }
    }

    /**
     * Retourne l'instance courante ou la crée
     *
     * @param apiToken fourni par sportmonks.com
     * @return APIClient
     */

    public static APIClient getInstance(final String apiToken) {
        if (INSTANCE == null || INSTANCE.getApiToken() == null || !INSTANCE.getApiToken().equals(apiToken)) {
            INSTANCE = new APIClient(apiToken, null);
        }

        return INSTANCE;
    }

    /**
     * Retourne l'instance courante ou la crée
     *
     * @param apiToken  fourni par sportmonks.com
     * @param rateLimit taux d'appel a l'api
     * @return APIClient
     */
    public static APIClient getInstance(final String apiToken, final Double rateLimit) {
        if (INSTANCE == null || INSTANCE.getApiToken() == null || !INSTANCE.getApiToken().equals(apiToken)) {
            INSTANCE = new APIClient(apiToken, rateLimit);
        }

        return INSTANCE;
    }

    /**
     * Retourne une instance de CommentariesEndPoint
     *
     * @return CommentariesEndPoint
     */
    public CommentariesEndPoint getCommentariesEndPointInstance() {
        checkInstance();
        return CommentariesEndPoint.getInstance(rateLimit);
    }

    /**
     * @param hourRateLimit limite d'appel à l'API
     * @return CommentariesEndPoint
     */
    public CommentariesEndPoint getCommentariesEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return CommentariesEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Competition
     *
     * @return ContinentsEndPoint
     */
    public ContinentsEndPoint getContinentsEndPointInstance() {
        checkInstance();
        return ContinentsEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Competition
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return ContinentsEndPoint
     */
    public ContinentsEndPoint getContinentsEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return ContinentsEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Competition
     *
     * @return CountriesEndPoint
     */
    public CountriesEndPoint getCountriesEndPointInstance() {
        checkInstance();
        return CountriesEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Competition
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return CountriesEndPoint
     */
    public CountriesEndPoint getCountriesEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return CountriesEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Fixture
     *
     * @return FixturesEndPoint
     */
    public FixturesEndPoint getFixturesEndPointInstance() {
        checkInstance();
        return FixturesEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Fixture
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return FixturesEndPoint
     */
    public FixturesEndPoint getFixturesEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return FixturesEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Competition
     *
     * @return LeaguesEndPoint
     */
    public LeaguesEndPoint getLeaguesEndPointInstance() {
        checkInstance();
        return LeaguesEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Competition
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return LeaguesEndPoint
     */
    public LeaguesEndPoint getLeaguesEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return LeaguesEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Livescores
     *
     * @return LivescoresEndPoint
     */
    public LivescoresEndPoint getLivescoresEndPointInstance() {
        checkInstance();
        return LivescoresEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Livescores
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return LivescoresEndPoint
     */
    public LivescoresEndPoint getLivescoresEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return LivescoresEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Player
     *
     * @return PlayersEndPoint
     */
    public PlayersEndPoint getPlayersEndPointInstance() {
        checkInstance();
        return PlayersEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Player
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return PlayersEndPoint
     */
    public PlayersEndPoint getPlayersEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return PlayersEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy PreMatchOddsEndPoint
     *
     * @return PreMatchOddsEndPoint
     */
    public PreMatchOddsEndPoint getPreMatchOddsEndPointInstance() {
        checkInstance();
        return PreMatchOddsEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy PreMatchOddsEndPoint
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return PreMatchOddsEndPoint
     */
    public PreMatchOddsEndPoint getPreMatchOddsEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return PreMatchOddsEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Season
     *
     * @return SeasonsEndPoint
     */
    public SeasonsEndPoint getSeasonsEndPointInstance() {
        checkInstance();
        return SeasonsEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Season
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return SeasonsEndPoint
     */
    public SeasonsEndPoint getSeasonsEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return SeasonsEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }


    /**
     * Retourne une instance du proxy {@link com.sportmonks.data.entity.Bookmaker}
     *
     * @return BookmakersEndPoint
     */
    public BookmakersEndPoint getBookmakersEndPointInstance() {
        checkInstance();
        return BookmakersEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Market
     *
     * @return MarketsEndPoint
     */
    public MarketsEndPoint getMarketsEndPointInstance() {
        checkInstance();
        return MarketsEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Market
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return MarketsEndPoint
     */
    public MarketsEndPoint getMarketsEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return MarketsEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Standing
     *
     * @return StandingsEndPoint
     */
    public StandingsEndPoint getStandingsProxyInstance() {
        checkInstance();
        return StandingsEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Standing
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return StandingsEndPoint
     */
    public StandingsEndPoint getStandingsProxyInstance(final Double hourRateLimit) {
        checkInstance();
        return StandingsEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy Team
     *
     * @return TeamsEndPoint
     */
    public TeamsEndPoint getTeamsEndPointInstance() {
        checkInstance();
        return TeamsEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy Team
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return TeamsEndPoint
     */
    public TeamsEndPoint getTeamsEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return TeamsEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy TvStations
     *
     * @return TvStationsEndPoint
     */
    public TvStationsEndPoint getTvStationsEndPointInstance() {
        checkInstance();
        return TvStationsEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy TvStations
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return TvStationsEndPoint
     */
    public TvStationsEndPoint getTvStationsEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return TvStationsEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy VenuesEndPoint
     *
     * @return VenuesEndPoint
     */
    public VenuesEndPoint getVenuesEndPointInstance() {
        checkInstance();
        return VenuesEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy VenuesEndPoint
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return VenuesEndPoint
     */
    public VenuesEndPoint getVenuesEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return VenuesEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne une instance du proxy VideoHighlights
     *
     * @return VideoHighlightsEndPoint
     */
    public VideoHighlightsEndPoint getVideoHighlightsEndPointInstance() {
        checkInstance();
        return VideoHighlightsEndPoint.getInstance(rateLimit);
    }

    /**
     * Retourne une instance du proxy VideoHighlights
     *
     * @param hourRateLimit limite d'appel à l'API
     * @return VideoHighlightsEndPoint
     */
    public VideoHighlightsEndPoint getVideoHighlightsEndPointInstance(final Double hourRateLimit) {
        checkInstance();
        return VideoHighlightsEndPoint.getInstance(hourRateLimit != null ? hourRateLimit : rateLimit);
    }

    /**
     * Retourne l'API Key
     *
     * @return String API Token
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * @return HttpClient SSL
     */
    private HttpClient createSSLHttpClient() {

        final TrustStrategy acceptingTrustStrategy = new TrustStrategy() {

            @Override
            public boolean isTrusted(final X509Certificate[] arg0, final String arg1) throws CertificateException {
                return true;
            }
        };

        SSLContext sslContext = null;
        try {
            sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        } catch (final Exception e) {
            System.out.println("Could not create SSLContext");
        }

        return HttpClientBuilder.create().setSSLContext(sslContext).build();
    }

    /**
     * @return ObjectMapper
     */
    private ObjectMapper createObjectMapper() {

        return new ObjectMapper() {
            public final com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

            @Override
            public <T> T readValue(final String value, final Class<T> valueType) {
                try {
                    jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    jacksonObjectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String writeValue(final Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (final JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

}
