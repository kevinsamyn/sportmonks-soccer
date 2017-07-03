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
@JsonPropertyOrder({ "coach_id", "fullname" })
public class Coach {

	@JsonProperty("coach_id")
	private Long id;
	@JsonProperty("fullname")
	private String fullname;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("coach_id")
	public Long getId() {
		return id;
	}

	@JsonProperty("coach_id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("fullname")
	public String getFullname() {
		return fullname;
	}

	@JsonProperty("fullname")
	public void setFullname(String fullname) {
		this.fullname = fullname;
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