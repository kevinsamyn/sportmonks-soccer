package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"scored", "conceded"})
public class StatsGoals {

    @JsonProperty("scored")
    private Object scored;
    @JsonProperty("conceded")
    private Object conceded;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("scored")
    public Object getScored() {
        return scored;
    }

    @JsonProperty("scored")
    public void setScored(Object scored) {
        this.scored = scored;
    }

    @JsonProperty("conceded")
    public Object getConceded() {
        return conceded;
    }

    @JsonProperty("conceded")
    public void setConceded(Object conceded) {
        this.conceded = conceded;
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