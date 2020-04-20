package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.structure.Stats;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"team_id", "fixture_id", "player_id", "player_name", "number", "position", "additional_position", "formation_position", "posx", "posy",
        "stats"})
public class Lineup {

    @JsonProperty("team_id")
    private Integer teamId;
    @JsonProperty("fixture_id")
    private Integer fixtureId;
    @JsonProperty("player_id")
    private Integer playerId;
    @JsonProperty("player_name")
    private String playerName;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("position")
    private String position;
    @JsonProperty("additional_position")
    private Object additionalPosition;
    @JsonProperty("formation_position")
    private Object formationPosition;
    @JsonProperty("posx")
    private Integer posx;
    @JsonProperty("posy")
    private Integer posy;
    @JsonProperty("stats")
    private Stats stats;
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

    @JsonProperty("fixture_id")
    public Integer getFixtureId() {
        return fixtureId;
    }

    @JsonProperty("fixture_id")
    public void setFixtureId(Integer fixtureId) {
        this.fixtureId = fixtureId;
    }

    @JsonProperty("player_id")
    public Integer getPlayerId() {
        return playerId;
    }

    @JsonProperty("player_id")
    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    @JsonProperty("player_name")
    public String getPlayerName() {
        return playerName;
    }

    @JsonProperty("player_name")
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("additional_position")
    public Object getAdditionalPosition() {
        return additionalPosition;
    }

    @JsonProperty("additional_position")
    public void setAdditionalPosition(Object additionalPosition) {
        this.additionalPosition = additionalPosition;
    }

    @JsonProperty("formation_position")
    public Object getFormationPosition() {
        return formationPosition;
    }

    @JsonProperty("formation_position")
    public void setFormationPosition(Object formationPosition) {
        this.formationPosition = formationPosition;
    }

    @JsonProperty("posx")
    public Integer getPosx() {
        return posx;
    }

    @JsonProperty("posx")
    public void setPosx(Integer posx) {
        this.posx = posx;
    }

    @JsonProperty("posy")
    public Integer getPosy() {
        return posy;
    }

    @JsonProperty("posy")
    public void setPosy(Integer posy) {
        this.posy = posy;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
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