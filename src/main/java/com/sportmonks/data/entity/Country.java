package com.sportmonks.data.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.structure.Leagues;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "extra", "continent", "leagues" })
public class Country {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("extra")
	private CountryExtra extra;
	@JsonProperty("continent")
	private Continent continent;
	@JsonProperty("leagues")
	private Leagues leagues;
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

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("extra")
	public CountryExtra getExtra() {
		return extra;
	}

	@JsonProperty("extra")
	public void setExtra(CountryExtra extra) {
		this.extra = extra;
	}

	@JsonProperty("continent")
	public Continent getContinent() {
		return continent;
	}

	@JsonProperty("continent")
	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	@JsonProperty("leagues")
	public Leagues getLeagues() {
		return leagues;
	}

	@JsonProperty("leagues")
	public void setLeagues(Leagues leagues) {
		this.leagues = leagues;
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