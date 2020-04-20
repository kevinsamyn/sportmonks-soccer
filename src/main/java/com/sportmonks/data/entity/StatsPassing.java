package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"total_crosses", "crosses_accuracy", "passes", "passes_accuracy"})
public class StatsPassing {

    @JsonProperty("total_crosses")
    private Object totalCrosses;
    @JsonProperty("crosses_accuracy")
    private Object crossesAccuracy;
    @JsonProperty("passes")
    private Object passes;
    @JsonProperty("passes_accuracy")
    private Object passesAccuracy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total_crosses")
    public Object getTotalCrosses() {
        return totalCrosses;
    }

    @JsonProperty("total_crosses")
    public void setTotalCrosses(Object totalCrosses) {
        this.totalCrosses = totalCrosses;
    }

    @JsonProperty("crosses_accuracy")
    public Object getCrossesAccuracy() {
        return crossesAccuracy;
    }

    @JsonProperty("crosses_accuracy")
    public void setCrossesAccuracy(Object crossesAccuracy) {
        this.crossesAccuracy = crossesAccuracy;
    }

    @JsonProperty("passes")
    public Object getPasses() {
        return passes;
    }

    @JsonProperty("passes")
    public void setPasses(Object passes) {
        this.passes = passes;
    }

    @JsonProperty("passes_accuracy")
    public Object getPassesAccuracy() {
        return passesAccuracy;
    }

    @JsonProperty("passes_accuracy")
    public void setPassesAccuracy(Object passesAccuracy) {
        this.passesAccuracy = passesAccuracy;
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