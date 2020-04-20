package com.sportmonks.data.structure;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.entity.Team;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data"})
public class FixtureTeam {

    @JsonProperty("data")
    private Team data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("data")
    public Team getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Team data) {
        this.data = data;
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