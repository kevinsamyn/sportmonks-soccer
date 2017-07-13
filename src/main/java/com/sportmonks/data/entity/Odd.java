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
@JsonPropertyOrder({ "label", "value", "winning", "handicap", "total", "last_update" })
public class Odd {

	@JsonProperty("label")
	private String label;
	@JsonProperty("value")
	private String value;
	@JsonProperty("winning")
	private String winning;
	@JsonProperty("handicap")
	private String handicap;
	@JsonProperty("total")
	private String total;
	@JsonProperty("last_update")
	private Date lastUpdate;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("label")
	public String getLabel() {
		return label;
	}

	@JsonProperty("label")
	public void setLabel(String label) {
		this.label = label;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("winning")
	public String getWinning() {
		return winning;
	}

	@JsonProperty("winning")
	public void setWinning(String winning) {
		this.winning = winning;
	}

	@JsonProperty("handicap")
	public String getHandicap() {
		return handicap;
	}

	@JsonProperty("handicap")
	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	@JsonProperty("total")
	public String getTotal() {
		return total;
	}

	@JsonProperty("total")
	public void setTotal(String total) {
		this.total = total;
	}

	@JsonProperty("last_update")
	public Date getLastUpdate() {
		return lastUpdate;
	}

	@JsonProperty("last_update")
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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