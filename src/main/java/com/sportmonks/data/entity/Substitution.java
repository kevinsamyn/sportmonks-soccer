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
@JsonPropertyOrder({ "id", "type", "fixture_id", "player_out_id", "player_out_name", "player_in_id", "player_in_name", "minute", "extra_minute", "injuried" })
public class Substitution {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("type")
	private String type;
	@JsonProperty("fixture_id")
	private Long fixtureId;
	@JsonProperty("player_out_id")
	private Long playerOutId;
	@JsonProperty("player_out_name")
	private String playerOutName;
	@JsonProperty("player_in_id")
	private Long playerInId;
	@JsonProperty("player_in_name")
	private String playerInName;
	@JsonProperty("minute")
	private Integer minute;
	@JsonProperty("extra_minute")
	private Object extraMinute;
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

	@JsonProperty("player_out_id")
	public Long getPlayerOutId() {
		return playerOutId;
	}

	@JsonProperty("player_out_id")
	public void setPlayerOutId(Long playerOutId) {
		this.playerOutId = playerOutId;
	}

	@JsonProperty("player_out_name")
	public String getPlayerOutName() {
		return playerOutName;
	}

	@JsonProperty("player_out_name")
	public void setPlayerOutName(String playerOutName) {
		this.playerOutName = playerOutName;
	}

	@JsonProperty("player_in_id")
	public Long getPlayerInId() {
		return playerInId;
	}

	@JsonProperty("player_in_id")
	public void setPlayerInId(Long playerInId) {
		this.playerInId = playerInId;
	}

	@JsonProperty("player_in_name")
	public String getPlayerInName() {
		return playerInName;
	}

	@JsonProperty("player_in_name")
	public void setPlayerInName(String playerInName) {
		this.playerInName = playerInName;
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
