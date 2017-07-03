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
@JsonPropertyOrder({ "id", "type", "fixture_id", "player_id", "player_name", "minute", "extra_minute", "reason" })
public class Card {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("type")
	private String type;
	@JsonProperty("fixture_id")
	private Integer fixtureId;
	@JsonProperty("player_id")
	private Integer playerId;
	@JsonProperty("player_name")
	private String playerName;
	@JsonProperty("minute")
	private Integer minute;
	@JsonProperty("extra_minute")
	private Object extraMinute;
	@JsonProperty("reason")
	private Object reason;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}