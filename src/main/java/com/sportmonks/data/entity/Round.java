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
@JsonPropertyOrder({ "id", "name", "league_id", "season_id", "stage_id", "start", "end" })
public class Round {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private Integer name;
	@JsonProperty("league_id")
	private Integer leagueId;
	@JsonProperty("season_id")
	private Integer seasonId;
	@JsonProperty("stage_id")
	private Integer stageId;
	@JsonProperty("start")
	private String start;
	@JsonProperty("end")
	private String end;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public Integer getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(Integer name) {
		this.name = name;
	}

	@JsonProperty("league_id")
	public Integer getLeagueId() {
		return leagueId;
	}

	@JsonProperty("league_id")
	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}

	@JsonProperty("season_id")
	public Integer getSeasonId() {
		return seasonId;
	}

	@JsonProperty("season_id")
	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}

	@JsonProperty("stage_id")
	public Integer getStageId() {
		return stageId;
	}

	@JsonProperty("stage_id")
	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}

	@JsonProperty("start")
	public String getStart() {
		return start;
	}

	@JsonProperty("start")
	public void setStart(String start) {
		this.start = start;
	}

	@JsonProperty("end")
	public String getEnd() {
		return end;
	}

	@JsonProperty("end")
	public void setEnd(String end) {
		this.end = end;
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