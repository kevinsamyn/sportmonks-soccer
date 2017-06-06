package com.sportmonks.data.structure;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.entity.Continent;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data", "meta" })
public class Continents extends AbstractEndPointResponse {

	@JsonProperty("data")
	private List<Continent> data = null;

	@JsonProperty("data")
	public List<Continent> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Continent> data) {
		this.data = data;
	}

}