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
@JsonPropertyOrder({ "id", "team_id", "type", "fixture_id", "player_id", "player_name", "related_player_id", "related_player_name", "minute", "extra_minute",
		"reason", "injuried" })
public class FixtureEvent {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("team_id")
	private String teamId;
	@JsonProperty("type")
	private String type;
	@JsonProperty("fixture_id")
	private Long fixtureId;
	@JsonProperty("player_id")
	private Long playerId;
	@JsonProperty("player_name")
	private String playerName;
	@JsonProperty("related_player_id")
	private Long relatedPlayerId;
	@JsonProperty("related_player_name")
	private String relatedPlayerName;
	@JsonProperty("minute")
	private Integer minute;
	@JsonProperty("extra_minute")
	private Object extraMinute;
	@JsonProperty("reason")
	private Object reason;
	@JsonProperty("injuried")
	private Object injuried;
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

	@JsonProperty("team_id")
	public String getTeamId() {
		return teamId;
	}

	@JsonProperty("team_id")
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("fixture_id")
	public Long getFixtureId() {
		return fixtureId;
	}

	@JsonProperty("fixture_id")
	public void setFixtureId(Long fixtureId) {
		this.fixtureId = fixtureId;
	}

	@JsonProperty("player_id")
	public Long getPlayerId() {
		return playerId;
	}

	@JsonProperty("player_id")
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	@JsonProperty("player_name")
	public String getPlayerName() {
		return playerName;
	}

	@JsonProperty("player_name")
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@JsonProperty("related_player_id")
	public Long getRelatedPlayerId() {
		return relatedPlayerId;
	}

	@JsonProperty("related_player_id")
	public void setRelatedPlayerId(Long relatedPlayerId) {
		this.relatedPlayerId = relatedPlayerId;
	}

	@JsonProperty("related_player_name")
	public String getRelatedPlayerName() {
		return relatedPlayerName;
	}

	@JsonProperty("related_player_name")
	public void setRelatedPlayerName(String relatedPlayerName) {
		this.relatedPlayerName = relatedPlayerName;
	}

	@JsonProperty("minute")
	public Integer getMinute() {
		return minute;
	}

	@JsonProperty("minute")
	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	@JsonProperty("extra_minute")
	public Object getExtraMinute() {
		return extraMinute;
	}

	@JsonProperty("extra_minute")
	public void setExtraMinute(Object extraMinute) {
		this.extraMinute = extraMinute;
	}

	@JsonProperty("reason")
	public Object getReason() {
		return reason;
	}

	@JsonProperty("reason")
	public void setReason(Object reason) {
		this.reason = reason;
	}

	@JsonProperty("injuried")
	public Object getInjuried() {
		return injuried;
	}

	@JsonProperty("injuried")
	public void setInjuried(Object injuried) {
		this.injuried = injuried;
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