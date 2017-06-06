package com.sportmonks.data.structure;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.entity.League;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "league", "stages", "rounds" })
public class SeasonRelationships {

	@JsonProperty("league")
	private League league;
	@JsonProperty("stages")
	private Stages stages;
	@JsonProperty("rounds")
	private Rounds rounds;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("league")
	public League getLeague() {
		return league;
	}

	@JsonProperty("league")
	public void setLeague(League league) {
		this.league = league;
	}

	@JsonProperty("stages")
	public Stages getStages() {
		return stages;
	}

	@JsonProperty("stages")
	public void setStages(Stages stages) {
		this.stages = stages;
	}

	@JsonProperty("rounds")
	public Rounds getRounds() {
		return rounds;
	}

	@JsonProperty("rounds")
	public void setRounds(Rounds rounds) {
		this.rounds = rounds;
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