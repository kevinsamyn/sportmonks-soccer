package com.sportmonks;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
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

		Unirest.setObjectMapper(createObjectMapper());
		Unirest.setHttpClient(createSSLHttpClient());
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

	/**
	 * @return
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
	 * @return
	 */
	private ObjectMapper createObjectMapper() {
		return new ObjectMapper() {
			private final com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

			@Override
			public <T> T readValue(final String value, final Class<T> valueType) {
				try {
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
