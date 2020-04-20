package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"assists", "offsides", "saves", "pen_scored", "pen_missed", "tackles", "blocks", "interceptions", "clearances", "minutes_played"})
public class StatsOther {

    @JsonProperty("assists")
    private Object assists;
    @JsonProperty("offsides")
    private Object offsides;
    @JsonProperty("saves")
    private Object saves;
    @JsonProperty("pen_scored")
    private Object penScored;
    @JsonProperty("pen_missed")
    private Object penMissed;
    @JsonProperty("tackles")
    private Object tackles;
    @JsonProperty("blocks")
    private Object blocks;
    @JsonProperty("interceptions")
    private Object interceptions;
    @JsonProperty("clearances")
    private Object clearances;
    @JsonProperty("minutes_played")
    private Object minutesPlayed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("assists")
    public Object getAssists() {
        return assists;
    }

    @JsonProperty("assists")
    public void setAssists(Object assists) {
        this.assists = assists;
    }

    @JsonProperty("offsides")
    public Object getOffsides() {
        return offsides;
    }

    @JsonProperty("offsides")
    public void setOffsides(Object offsides) {
        this.offsides = offsides;
    }

    @JsonProperty("saves")
    public Object getSaves() {
        return saves;
    }

    @JsonProperty("saves")
    public void setSaves(Object saves) {
        this.saves = saves;
    }

    @JsonProperty("pen_scored")
    public Object getPenScored() {
        return penScored;
    }

    @JsonProperty("pen_scored")
    public void setPenScored(Object penScored) {
        this.penScored = penScored;
    }

    @JsonProperty("pen_missed")
    public Object getPenMissed() {
        return penMissed;
    }

    @JsonProperty("pen_missed")
    public void setPenMissed(Object penMissed) {
        this.penMissed = penMissed;
    }

    @JsonProperty("tackles")
    public Object getTackles() {
        return tackles;
    }

    @JsonProperty("tackles")
    public void setTackles(Object tackles) {
        this.tackles = tackles;
    }

    @JsonProperty("blocks")
    public Object getBlocks() {
        return blocks;
    }

    @JsonProperty("blocks")
    public void setBlocks(Object blocks) {
        this.blocks = blocks;
    }

    @JsonProperty("interceptions")
    public Object getInterceptions() {
        return interceptions;
    }

    @JsonProperty("interceptions")
    public void setInterceptions(Object interceptions) {
        this.interceptions = interceptions;
    }

    @JsonProperty("clearances")
    public Object getClearances() {
        return clearances;
    }

    @JsonProperty("clearances")
    public void setClearances(Object clearances) {
        this.clearances = clearances;
    }

    @JsonProperty("minutes_played")
    public Object getMinutesPlayed() {
        return minutesPlayed;
    }

    @JsonProperty("minutes_played")
    public void setMinutesPlayed(Object minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
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