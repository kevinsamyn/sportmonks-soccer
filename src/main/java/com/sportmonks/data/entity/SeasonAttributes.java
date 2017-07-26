package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "league_id", "is_current_season", "current_round_id", "current_stage_id" })
public class SeasonAttributes {

	@JsonProperty("name")
	private String name;
	@JsonProperty("league_id")
	private Long leagueId;
	@JsonProperty("is_current_season")
	private Boolean isCurrentSeason;
	@JsonProperty("current_round_id")
	private Object currentRoundId;
	@JsonProperty("current_stage_id")
	private Object currentStageId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("league_id")
	public Long getLeagueId() {
		return leagueId;
	}

	@JsonProperty("league_id")
	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}

	@JsonProperty("is_current_season")
	public Boolean getIsCurrentSeason() {
		return isCurrentSeason;
	}

	@JsonProperty("is_current_season")
	public void setIsCurrentSeason(Boolean isCurrentSeason) {
		this.isCurrentSeason = isCurrentSeason;
	}

	@JsonProperty("current_round_id")
	public Object getCurrentRoundId() {
		return currentRoundId;
	}

	@JsonProperty("current_round_id")
	public void setCurrentRoundId(Object currentRoundId) {
		this.currentRoundId = currentRoundId;
	}

	@JsonProperty("current_stage_id")
	public Object getCurrentStageId() {
		return currentStageId;
	}

	@JsonProperty("current_stage_id")
	public void setCurrentStageId(Object currentStageId) {
		this.currentStageId = currentStageId;
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