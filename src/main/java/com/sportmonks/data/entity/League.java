package com.sportmonks.data.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.structure.Seasons;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "legacy_id", "name", "is_cup", "current_season_id", "current_round_id", "current_stage_id", "country_id", "seasons", "season" })
public class League {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("legacy_id")
	private Integer legacyId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("is_cup")
	private Boolean isCup;
	@JsonProperty("current_season_id")
	private Long currentSeasonId;
	@JsonProperty("current_round_id")
	private Long currentRoundId;
	@JsonProperty("current_stage_id")
	private Long currentStageId;
	@JsonProperty("country_id")
	private Long countryId;
	@JsonProperty("seasons")
	private Seasons seasons;
	@JsonProperty("season")
	private Season season;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("legacy_id")
	public Integer getLegacyId() {
		return legacyId;
	}

	@JsonProperty("legacy_id")
	public void setLegacyId(Integer legacyId) {
		this.legacyId = legacyId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("is_cup")
	public Boolean getIsCup() {
		return isCup;
	}

	@JsonProperty("is_cup")
	public void setIsCup(Boolean isCup) {
		this.isCup = isCup;
	}

	@JsonProperty("current_season_id")
	public Long getCurrentSeasonId() {
		return currentSeasonId;
	}

	@JsonProperty("current_season_id")
	public void setCurrentSeasonId(Long currentSeasonId) {
		this.currentSeasonId = currentSeasonId;
	}

	@JsonProperty("current_round_id")
	public Long getCurrentRoundId() {
		return currentRoundId;
	}

	@JsonProperty("current_round_id")
	public void setCurrentRoundId(Long currentRoundId) {
		this.currentRoundId = currentRoundId;
	}

	@JsonProperty("current_stage_id")
	public Long getCurrentStageId() {
		return currentStageId;
	}

	@JsonProperty("current_stage_id")
	public void setCurrentStageId(Long currentStageId) {
		this.currentStageId = currentStageId;
	}

	@JsonProperty("country_id")
	public Long getCountryId() {
		return countryId;
	}

	@JsonProperty("country_id")
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@JsonProperty("seasons")
	public Seasons getSeasons() {
		return seasons;
	}

	@JsonProperty("seasons")
	public void setSeasons(Seasons seasons) {
		this.seasons = seasons;
	}

	@JsonProperty("season")
	public Season getSeason() {
		return season;
	}

	@JsonProperty("season")
	public void setSeason(Season season) {
		this.season = season;
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