package com.sportmonks.data.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code", "icon", "type", "wind", "clouds", "humidity", "temperature" })
public class WeatherReport {

	@JsonProperty("code")
	private String code;
	@JsonProperty("icon")
	private String icon;
	@JsonProperty("type")
	private String type;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("clouds")
	private String clouds;
	@JsonProperty("humidity")
	private String humidity;
	@JsonProperty("temperature")
	private Temperature temperature;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("icon")
	public String getIcon() {
		return icon;
	}

	@JsonProperty("icon")
	public void setIcon(String icon) {
		this.icon = icon;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("wind")
	public Wind getWind() {
		return wind;
	}

	@JsonProperty("wind")
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@JsonProperty("clouds")
	public String getClouds() {
		return clouds;
	}

	@JsonProperty("clouds")
	public void setClouds(String clouds) {
		this.clouds = clouds;
	}

	@JsonProperty("humidity")
	public String getHumidity() {
		return humidity;
	}

	@JsonProperty("humidity")
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	@JsonProperty("temperature")
	public Temperature getTemperature() {
		return temperature;
	}

	@JsonProperty("temperature")
	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}