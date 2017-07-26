package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.structure.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "id", "name", "league_id", "is_current_season", "current_round_id", "current_stage_id", "league", "attributes", "fixtures",
		"results", "relationships", "rounds", "stages" })
public class Season {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("league_id")
	private Long leagueId;
	@JsonProperty("is_current_season")
	private Boolean isCurrentSeason;
	@JsonProperty("current_round_id")
	private Long currentRoundId;
	@JsonProperty("current_stage_id")
	private Long currentStageId;
	@JsonProperty("league")
	private Leagues leagues;
	@JsonProperty("results")
	private Results results;
	@JsonProperty("type")
	private Object type;
	@JsonProperty("attributes")
	private SeasonAttributes attributes;
	@JsonProperty("relationships")
	private SeasonRelationships relationships;
	@JsonProperty("fixtures")
	private Fixtures fixtures;
	@JsonProperty("rounds")
	private Rounds rounds;
	@JsonProperty("stages")
	private Stages stages;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("type")
	public Object getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(Object type) {
		this.type = type;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("attributes")
	public SeasonAttributes getAttributes() {
		return attributes;
	}

	@JsonProperty("attributes")
	public void setAttributes(SeasonAttributes attributes) {
		this.attributes = attributes;
	}

	@JsonProperty("relationships")
	public SeasonRelationships getRelationships() {
		return relationships;
	}

	@JsonProperty("relationships")
	public void setRelationships(SeasonRelationships relationships) {
		this.relationships = relationships;
	}

	@JsonProperty("fixtures")
	public Fixtures getFixtures() {
		return fixtures;
	}

	@JsonProperty("fixtures")
	public void setFixtures(final Fixtures fixtures) {
		this.fixtures = fixtures;
	}

	@JsonProperty("rounds")
	public Rounds getRounds() {
		return rounds;
	}

	@JsonProperty("rounds")
	public void setRounds(final Rounds rounds) {
		this.rounds = rounds;
	}

	@JsonProperty("stages")
	public Stages getStages() {
		return stages;
	}

	@JsonProperty("stages")
	public void setStages(final Stages stages) {
		this.stages = stages;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(final String name) {
		this.name = name;
	}

	@JsonProperty("league_id")
	public Long getLeagueId() {
		return leagueId;
	}

	@JsonProperty("league_id")
	public void setLeagueId(final Long leagueId) {
		this.leagueId = leagueId;
	}

	@JsonProperty("is_current_season")
	public Boolean getCurrentSeason() {
		return isCurrentSeason;
	}

	@JsonProperty("is_current_season")
	public void setCurrentSeason(final Boolean currentSeason) {
		isCurrentSeason = currentSeason;
	}

	@JsonProperty("current_round_id")
	public Long getCurrentRoundId() {
		return currentRoundId;
	}

	@JsonProperty("current_round_id")
	public void setCurrentRoundId(final Long currentRoundId) {
		this.currentRoundId = currentRoundId;
	}

	@JsonProperty("current_stage_id")
	public Long getCurrentStageId() {
		return currentStageId;
	}

	@JsonProperty("current_stage_id")
	public void setCurrentStageId(final Long currentStageId) {
		this.currentStageId = currentStageId;
	}

	@JsonProperty("league")
	public Leagues getLeagues() {
		return leagues;
	}

	@JsonProperty("league")
	public void setLeagues(final Leagues leagues) {
		this.leagues = leagues;
	}

	@JsonProperty("results")
	public Results getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(final Results results) {
		this.results = results;
	}

	public void setAdditionalProperties(final Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
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