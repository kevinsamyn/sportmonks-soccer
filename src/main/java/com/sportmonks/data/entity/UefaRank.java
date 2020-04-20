package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"team_id", "points", "coeffiecient", "position", "position_status", "position_won_or_lost"})
public class UefaRank {

    @JsonProperty("team_id")
    private Integer teamId;
    @JsonProperty("points")
    private Double points;
    @JsonProperty("coeffiecient")
    private Double coeffiecient;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("position_status")
    private String positionStatus;
    @JsonProperty("position_won_or_lost")
    private Integer positionWonOrLost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("team_id")
    public Integer getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("points")
    public Double getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(Double points) {
        this.points = points;
    }

    @JsonProperty("coeffiecient")
    public Double getCoeffiecient() {
        return coeffiecient;
    }

    @JsonProperty("coeffiecient")
    public void setCoeffiecient(Double coeffiecient) {
        this.coeffiecient = coeffiecient;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("position_status")
    public String getPositionStatus() {
        return positionStatus;
    }

    @JsonProperty("position_status")
    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }

    @JsonProperty("position_won_or_lost")
    public Integer getPositionWonOrLost() {
        return positionWonOrLost;
    }

    @JsonProperty("position_won_or_lost")
    public void setPositionWonOrLost(Integer positionWonOrLost) {
        this.positionWonOrLost = positionWonOrLost;
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