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
@JsonPropertyOrder({ "id", "type", "fixture_id", "player_id", "player_name", "player_assist_id", "player_assist_name", "minute", "extra_minute" })
public class Goal {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("type")
	private String type;
	@JsonProperty("fixture_id")
	private Integer fixtureId;
	@JsonProperty("player_id")
	private Integer playerId;
	@JsonProperty("player_name")
	private String playerName;
	@JsonProperty("player_assist_id")
	private Object playerAssistId;
	@JsonProperty("player_assist_name")
	private Object playerAssistName;
	@JsonProperty("minute")
	private Integer minute;
	@JsonProperty("extra_minute")
	private Object extraMinute;
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

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("fixture_id")
	public Integer getFixtureId() {
		return fixtureId;
	}

	@JsonProperty("fixture_id")
	public void setFixtureId(Integer fixtureId) {
		this.fixtureId = fixtureId;
	}

	@JsonProperty("player_id")
	public Integer getPlayerId() {
		return playerId;
	}

	@JsonProperty("player_id")
	public void setPlayerId(Integer playerId) {
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

	@JsonProperty("player_assist_id")
	public Object getPlayerAssistId() {
		return playerAssistId;
	}

	@JsonProperty("player_assist_id")
	public void setPlayerAssistId(Object playerAssistId) {
		this.playerAssistId = playerAssistId;
	}

	@JsonProperty("player_assist_name")
	public Object getPlayerAssistName() {
		return playerAssistName;
	}

	@JsonProperty("player_assist_name")
	public void setPlayerAssistName(Object playerAssistName) {
		this.playerAssistName = playerAssistName;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
