package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"yellowcards", "redcards"})
public class StatsCards {

    @JsonProperty("yellowcards")
    private Object yellowcards;
    @JsonProperty("redcards")
    private Object redcards;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("yellowcards")
    public Object getYellowcards() {
        return yellowcards;
    }

    @JsonProperty("yellowcards")
    public void setYellowcards(Object yellowcards) {
        this.yellowcards = yellowcards;
    }

    @JsonProperty("redcards")
    public Object getRedcards() {
        return redcards;
    }

    @JsonProperty("redcards")
    public void setRedcards(Object redcards) {
        this.redcards = redcards;
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