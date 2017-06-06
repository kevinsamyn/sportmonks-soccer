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
@JsonPropertyOrder({ "player_id", "position_id", "number", "injured", "minutes", "appearences", "lineups", "substitute_in", "substitute_out",
		"substitutes_on_bench", "goals", "assists", "yellowcards", "yellowred", "redcards" })
public class SquadMember {

	@JsonProperty("player_id")
	private Integer playerId;
	@JsonProperty("position_id")
	private Integer positionId;
	@JsonProperty("number")
	private Integer number;
	@JsonProperty("injured")
	private Boolean injured;
	@JsonProperty("minutes")
	private Object minutes;
	@JsonProperty("appearences")
	private Object appearences;
	@JsonProperty("lineups")
	private Object lineups;
	@JsonProperty("substitute_in")
	private Object substituteIn;
	@JsonProperty("substitute_out")
	private Object substituteOut;
	@JsonProperty("substitutes_on_bench")
	private Integer substitutesOnBench;
	@JsonProperty("goals")
	private Object goals;
	@JsonProperty("assists")
	private Object assists;
	@JsonProperty("yellowcards")
	private Object yellowcards;
	@JsonProperty("yellowred")
	private Object yellowred;
	@JsonProperty("redcards")
	private Object redcards;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("player_id")
	public Integer getPlayerId() {
		return playerId;
	}

	@JsonProperty("player_id")
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	@JsonProperty("position_id")
	public Integer getPositionId() {
		return positionId;
	}

	@JsonProperty("position_id")
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	@JsonProperty("number")
	public Integer getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(Integer number) {
		this.number = number;
	}

	@JsonProperty("injured")
	public Boolean getInjured() {
		return injured;
	}

	@JsonProperty("injured")
	public void setInjured(Boolean injured) {
		this.injured = injured;
	}

	@JsonProperty("minutes")
	public Object getMinutes() {
		return minutes;
	}

	@JsonProperty("minutes")
	public void setMinutes(Object minutes) {
		this.minutes = minutes;
	}

	@JsonProperty("appearences")
	public Object getAppearences() {
		return appearences;
	}

	@JsonProperty("appearences")
	public void setAppearences(Object appearences) {
		this.appearences = appearences;
	}

	@JsonProperty("lineups")
	public Object getLineups() {
		return lineups;
	}

	@JsonProperty("lineups")
	public void setLineups(Object lineups) {
		this.lineups = lineups;
	}

	@JsonProperty("substitute_in")
	public Object getSubstituteIn() {
		return substituteIn;
	}

	@JsonProperty("substitute_in")
	public void setSubstituteIn(Object substituteIn) {
		this.substituteIn = substituteIn;
	}

	@JsonProperty("substitute_out")
	public Object getSubstituteOut() {
		return substituteOut;
	}

	@JsonProperty("substitute_out")
	public void setSubstituteOut(Object substituteOut) {
		this.substituteOut = substituteOut;
	}

	@JsonProperty("substitutes_on_bench")
	public Integer getSubstitutesOnBench() {
		return substitutesOnBench;
	}

	@JsonProperty("substitutes_on_bench")
	public void setSubstitutesOnBench(Integer substitutesOnBench) {
		this.substitutesOnBench = substitutesOnBench;
	}

	@JsonProperty("goals")
	public Object getGoals() {
		return goals;
	}

	@JsonProperty("goals")
	public void setGoals(Object goals) {
		this.goals = goals;
	}

	@JsonProperty("assists")
	public Object getAssists() {
		return assists;
	}

	@JsonProperty("assists")
	public void setAssists(Object assists) {
		this.assists = assists;
	}

	@JsonProperty("yellowcards")
	public Object getYellowcards() {
		return yellowcards;
	}

	@JsonProperty("yellowcards")
	public void setYellowcards(Object yellowcards) {
		this.yellowcards = yellowcards;
	}

	@JsonProperty("yellowred")
	public Object getYellowred() {
		return yellowred;
	}

	@JsonProperty("yellowred")
	public void setYellowred(Object yellowred) {
		this.yellowred = yellowred;
	}

	@JsonProperty("redcards")
	public Object getRedcards() {
		return redcards;
	}

	@JsonProperty("redcards")
	public void setRedcards(Object redcards) {
		this.redcards = redcards;
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