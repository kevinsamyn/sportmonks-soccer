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
@JsonPropertyOrder({ "points", "goal_difference" })
public class StandingRowTotal {

	@JsonProperty("points")
	private Integer points;
	@JsonProperty("goal_difference")
	private String goalDifference;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("points")
	public Integer getPoints() {
		return points;
	}

	@JsonProperty("points")
	public void setPoints(Integer points) {
		this.points = points;
	}

	@JsonProperty("goal_difference")
	public String getGoalDifference() {
		return goalDifference;
	}

	@JsonProperty("goal_difference")
	public void setGoalDifference(String goalDifference) {
		this.goalDifference = goalDifference;
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