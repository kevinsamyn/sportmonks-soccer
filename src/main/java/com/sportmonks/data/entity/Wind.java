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
@JsonPropertyOrder({ "speed", "degree" })
public class Wind {

	@JsonProperty("speed")
	private String speed;
	@JsonProperty("degree")
	private Integer degree;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("speed")
	public String getSpeed() {
		return speed;
	}

	@JsonProperty("speed")
	public void setSpeed(String speed) {
		this.speed = speed;
	}

	@JsonProperty("degree")
	public Integer getDegree() {
		return degree;
	}

	@JsonProperty("degree")
	public void setDegree(Integer degree) {
		this.degree = degree;
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