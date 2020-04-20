package com.sportmonks.data.structure;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.entity.League;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"league", "stages", "rounds"})
public class SeasonRelationships {

    @JsonProperty("league")
    private League league;
    @JsonProperty("stages")
    private Stages stages;
    @JsonProperty("rounds")
    private Rounds rounds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("league")
    public League getLeague() {
        return league;
    }

    @JsonProperty("league")
    public void setLeague(League league) {
        this.league = league;
    }

    @JsonProperty("stages")
    public Stages getStages() {
        return stages;
    }

    @JsonProperty("stages")
    public void setStages(Stages stages) {
        this.stages = stages;
    }

    @JsonProperty("rounds")
    public Rounds getRounds() {
        return rounds;
    }

    @JsonProperty("rounds")
    public void setRounds(Rounds rounds) {
        this.rounds = rounds;
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