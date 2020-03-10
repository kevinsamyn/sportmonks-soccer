package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.structure.MarketBookmakers;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "bookmaker"})
public class Market {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("bookmaker")
	private MarketBookmakers bookmaker;
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

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("bookmaker")
	public MarketBookmakers getBookmaker() {
		return bookmaker;
	}

	@JsonProperty("bookmaker")
	public void setBookmaker(MarketBookmakers bookmaker) {
		this.bookmaker = bookmaker;
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