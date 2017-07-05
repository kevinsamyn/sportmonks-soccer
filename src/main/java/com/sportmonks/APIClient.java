package com.sportmonks;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mashape.unirest.http.Unirest;
import com.sportmonks.endpoints.CommentariesEndPoint;
import com.sportmonks.endpoints.ContinentsEndPoint;
import com.sportmonks.endpoints.CountriesEndPoint;
import com.sportmonks.endpoints.FixturesEndPoint;
import com.sportmonks.endpoints.LeaguesEndPoint;
import com.sportmonks.endpoints.LivescoresEndPoint;
import com.sportmonks.endpoints.PlayersEndPoint;
import com.sportmonks.endpoints.PreMatchOddsEndPoint;
import com.sportmonks.endpoints.SeasonsEndPoint;
import com.sportmonks.endpoints.StandingsEndPoint;
import com.sportmonks.endpoints.TeamsEndPoint;
import com.sportmonks.endpoints.TvStationsEndPoint;
import com.sportmonks.endpoints.VenuesEndPoint;
import com.sportmonks.endpoints.VideoHighlightsEndPoint;
import com.sportmonks.exceptions.InvalidServiceInstanceException;

public class APIClient {

	private static APIClient INSTANCE;
	private String apiToken = null;

	/**
	 * @param apiToken
	 */
	private APIClient(final String apiToken) {
		super();
		// Hide constructor
		this.apiToken = apiToken;

		configureUnirest(createObjectMapper());

	}

	/**
	 *
	 * @param objectMapper
	 */
	private static void configureUnirest(final com.fasterxml.jackson.databind.ObjectMapper objectMapper) {
		Unirest.setHttpClient(createSSLHttpClient());
		Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
			@Override
			public <T> T readValue(String value, Class<T> valueType) {
				try {
					return objectMapper.readValue(value, valueType);
				} catch (IOException e) {
					throw new UncheckedIOException(e);
				}
			}

			@Override
			public String writeValue(Object value) {
				try {
					return objectMapper.writeValueAsString(value);
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

	/**
	 * @return
	 */
	private static HttpClient createSSLHttpClient() {

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
	 *
	 * @return
	 */
	private static com.fasterxml.jackson.databind.ObjectMapper createObjectMapper() {
		com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
		objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
			}
		});
		// objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
		return objectMapper;
	}

	/**
	 * Retourne l'instance courante
	 *
	 * @return
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
	 * @param apiToken
	 * @return
	 */
	public static APIClient getInstance(final String apiToken) {
		if (INSTANCE == null || INSTANCE.getApiToken() == null || !INSTANCE.getApiToken().equals(apiToken)) {
			INSTANCE = new APIClient(apiToken);
		}

		return INSTANCE;
	}

	/**
	 * Retourne une instance de CommentariesEndPoint
	 *
	 * @return
	 */
	public CommentariesEndPoint getCommentariesEndPointInstance() {
		checkInstance();
		return CommentariesEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Competition
	 *
	 * @return
	 */
	public ContinentsEndPoint getContinentsEndPointInstance() {
		checkInstance();
		return ContinentsEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Competition
	 *
	 * @return
	 */
	public CountriesEndPoint getCountriesEndPointInstance() {
		checkInstance();
		return CountriesEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Fixture
	 *
	 * @return
	 */
	public FixturesEndPoint getFixturesEndPointInstance() {
		checkInstance();
		return FixturesEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Competition
	 *
	 * @return
	 */
	public LeaguesEndPoint getLeaguesEndPointInstance() {
		checkInstance();
		return LeaguesEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Livescores
	 *
	 * @return
	 */
	public LivescoresEndPoint getLivescoresEndPointInstance() {
		checkInstance();
		return LivescoresEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Player
	 *
	 * @return
	 */
	public PlayersEndPoint getPlayersEndPointInstance() {
		checkInstance();
		return PlayersEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy PreMatchOddsEndPoint
	 *
	 * @return
	 */
	public PreMatchOddsEndPoint getPreMatchOddsEndPointInstance() {
		checkInstance();
		return PreMatchOddsEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Season
	 *
	 * @return
	 */
	public SeasonsEndPoint getSeasonsEndPointInstance() {
		checkInstance();
		return SeasonsEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Standing
	 *
	 * @return
	 */
	public StandingsEndPoint getStandingsProxyInstance() {
		checkInstance();
		return StandingsEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy Team
	 *
	 * @return
	 */
	public TeamsEndPoint getTeamsEndPointInstance() {
		checkInstance();
		return TeamsEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy TvStations
	 *
	 * @return
	 */
	public TvStationsEndPoint getTvStationsEndPointInstance() {
		checkInstance();
		return TvStationsEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy VenuesEndPoint
	 *
	 * @return
	 */
	public VenuesEndPoint getVenuesEndPointInstance() {
		checkInstance();
		return VenuesEndPoint.getInstance();
	}

	/**
	 * Retourne une instance du proxy VideoHighlights
	 *
	 * @return
	 */
	public VideoHighlightsEndPoint getVideoHighlightsEndPointInstance() {
		checkInstance();
		return VideoHighlightsEndPoint.getInstance();
	}

	/**
	 * Retourne l'API Key
	 *
	 * @return
	 */
	public String getApiToken() {
		return apiToken;
	}

}
