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
@JsonPropertyOrder({ "fixture_id", "important", "order", "goal", "minute", "extra_minute", "comment" })
public class Comment {

	@JsonProperty("fixture_id")
	private Integer fixtureId;
	@JsonProperty("important")
	private Boolean important;
	@JsonProperty("order")
	private Object order;
	@JsonProperty("goal")
	private Boolean goal;
	@JsonProperty("minute")
	private Integer minute;
	@JsonProperty("extra_minute")
	private Object extraMinute;
	@JsonProperty("comment")
	private String comment;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("fixture_id")
	public Integer getFixtureId() {
		return fixtureId;
	}

	@JsonProperty("fixture_id")
	public void setFixtureId(Integer fixtureId) {
		this.fixtureId = fixtureId;
	}

	@JsonProperty("important")
	public Boolean getImportant() {
		return important;
	}

	@JsonProperty("important")
	public void setImportant(Boolean important) {
		this.important = important;
	}

	@JsonProperty("order")
	public Object getOrder() {
		return order;
	}

	@JsonProperty("order")
	public void setOrder(Object order) {
		this.order = order;
	}

	@JsonProperty("goal")
	public Boolean getGoal() {
		return goal;
	}

	@JsonProperty("goal")
	public void setGoal(Boolean goal) {
		this.goal = goal;
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

	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}

	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
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