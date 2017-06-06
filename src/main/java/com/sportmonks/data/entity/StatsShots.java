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
@JsonPropertyOrder({ "shots_total", "shots_on_goal" })
public class StatsShots {

	@JsonProperty("shots_total")
	private Object shotsTotal;
	@JsonProperty("shots_on_goal")
	private Object shotsOnGoal;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("shots_total")
	public Object getShotsTotal() {
		return shotsTotal;
	}

	@JsonProperty("shots_total")
	public void setShotsTotal(Object shotsTotal) {
		this.shotsTotal = shotsTotal;
	}

	@JsonProperty("shots_on_goal")
	public Object getShotsOnGoal() {
		return shotsOnGoal;
	}

	@JsonProperty("shots_on_goal")
	public void setShotsOnGoal(Object shotsOnGoal) {
		this.shotsOnGoal = shotsOnGoal;
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