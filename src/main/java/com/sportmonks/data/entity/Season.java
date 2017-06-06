package com.sportmonks.data.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.structure.SeasonRelationships;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "id", "attributes", "relationships" })
public class Season {

	@JsonProperty("type")
	private Object type;
	@JsonProperty("id")
	private String id;
	@JsonProperty("attributes")
	private SeasonAttributes attributes;
	@JsonProperty("relationships")
	private SeasonRelationships relationships;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("type")
	public Object getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(Object type) {
		this.type = type;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("attributes")
	public SeasonAttributes getAttributes() {
		return attributes;
	}

	@JsonProperty("attributes")
	public void setAttributes(SeasonAttributes attributes) {
		this.attributes = attributes;
	}

	@JsonProperty("relationships")
	public SeasonRelationships getRelationships() {
		return relationships;
	}

	@JsonProperty("relationships")
	public void setRelationships(SeasonRelationships relationships) {
		this.relationships = relationships;
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