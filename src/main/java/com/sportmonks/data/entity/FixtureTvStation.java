package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"fixture_id", "tvstation"})
public class FixtureTvStation {

    @JsonProperty("fixture_id")
    private Integer fixtureId;
    @JsonProperty("tvstation")
    private String tvstation;
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

    @JsonProperty("tvstation")
    public String getTvstation() {
        return tvstation;
    }

    @JsonProperty("tvstation")
    public void setTvstation(String tvstation) {
        this.tvstation = tvstation;
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