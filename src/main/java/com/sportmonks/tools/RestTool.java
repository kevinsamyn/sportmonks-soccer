package com.sportmonks.tools;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.sportmonks.APIClient;
import com.sportmonks.endpoints.AbstractEndPoint;

/**
 * Created by kevin on 21/05/2016.
 */
public class RestTool {

	/**
	 * @param baseUrl
	 * @param params
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> HttpResponse<T> get(final String baseUrl, final Map<String, String> params, final Class<T> clazz) {

		final ObjectMapper objectMapper = createObjectMapper();
		configureUnirest(objectMapper);

		final GetRequest getRequest = Unirest.get(baseUrl + AbstractEndPoint.COMMON_URL_PARAMS);

		config(getRequest, params);

		try {

			return getRequest.asObject(clazz);
		} catch (UnirestException ue) {
			System.out.println("APIClient Exception : " + ue.getMessage());
		}
		return null;
	}

	/**
	   * @param httpRequest
	   * @param params
	   */
	private static void config(final HttpRequest httpRequest, final Map<String, String> params) {
		httpRequest.routeParam("api_token", APIClient.getInstance().getApiToken());

		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> param : params.entrySet()) {
				httpRequest.routeParam(param.getKey(), param.getValue());
			}
		} else {
			httpRequest.routeParam("includes", "");
		}

		httpRequest.header("Accept", "application/json");
	}

	private static ObjectMapper createObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
			}
		});
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
		return objectMapper;
	}

	private static void configureUnirest(final ObjectMapper objectMapper) {
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
}
