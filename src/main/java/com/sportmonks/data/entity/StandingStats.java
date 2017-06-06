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
@JsonPropertyOrder({ "won", "draw", "lost", "games_played", "goals_scored", "goals_against" })
public class StandingStats {

	@JsonProperty("won")
	private Integer won;
	@JsonProperty("draw")
	private Integer draw;
	@JsonProperty("lost")
	private Integer lost;
	@JsonProperty("games_played")
	private Integer gamesPlayed;
	@JsonProperty("goals_scored")
	private Integer goalsScored;
	@JsonProperty("goals_against")
	private Integer goalsAgainst;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("won")
	public Integer getWon() {
		return won;
	}

	@JsonProperty("won")
	public void setWon(Integer won) {
		this.won = won;
	}

	@JsonProperty("draw")
	public Integer getDraw() {
		return draw;
	}

	@JsonProperty("draw")
	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	@JsonProperty("lost")
	public Integer getLost() {
		return lost;
	}

	@JsonProperty("lost")
	public void setLost(Integer lost) {
		this.lost = lost;
	}

	@JsonProperty("games_played")
	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	@JsonProperty("games_played")
	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	@JsonProperty("goals_scored")
	public Integer getGoalsScored() {
		return goalsScored;
	}

	@JsonProperty("goals_scored")
	public void setGoalsScored(Integer goalsScored) {
		this.goalsScored = goalsScored;
	}

	@JsonProperty("goals_against")
	public Integer getGoalsAgainst() {
		return goalsAgainst;
	}

	@JsonProperty("goals_against")
	public void setGoalsAgainst(Integer goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
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