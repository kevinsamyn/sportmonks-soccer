package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"started_at", "trial_ends_at", "ends_at"})
public class MetaSubscription {

    @JsonProperty("started_at")
    private Date startedAt;
    @JsonProperty("trial_ends_at")
    private Date trialEndsAt;
    @JsonProperty("ends_at")
    private Date endsAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("started_at")
    public Date getStartedAt() {
        return startedAt;
    }

    @JsonProperty("started_at")
    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    @JsonProperty("trial_ends_at")
    public Date getTrialEndsAt() {
        return trialEndsAt;
    }

    @JsonProperty("trial_ends_at")
    public void setTrialEndsAt(Date trialEndsAt) {
        this.trialEndsAt = trialEndsAt;
    }

    @JsonProperty("ends_at")
    public Date getEndsAt() {
        return endsAt;
    }

    @JsonProperty("ends_at")
    public void setEndsAt(Date endsAt) {
        this.endsAt = endsAt;
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
