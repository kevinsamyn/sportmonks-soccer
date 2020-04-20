package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.structure.StandingRows;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "league_id", "season_id", "round_id", "round_name", "stage_id", "stage_name", "standings"})
public class StandingGroup extends StandingRow {

    @JsonProperty("name")
    private String name;
    @JsonProperty("league_id")
    private Integer leagueId;
    @JsonProperty("season_id")
    private Integer seasonId;
    @JsonProperty("round_id")
    private Integer roundId;
    @JsonProperty("round_name")
    private Integer roundName;
    @JsonProperty("stage_id")
    private Integer stageId;
    @JsonProperty("stage_name")
    private String stageName;
    @JsonProperty("standings")
    private StandingRows standings;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("league_id")
    public Integer getLeagueId() {
        return leagueId;
    }

    @JsonProperty("league_id")
    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    @JsonProperty("season_id")
    public Integer getSeasonId() {
        return seasonId;
    }

    @JsonProperty("season_id")
    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    @JsonProperty("round_id")
    public Integer getRoundId() {
        return roundId;
    }

    @JsonProperty("round_id")
    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    @JsonProperty("round_name")
    public Integer getRoundName() {
        return roundName;
    }

    @JsonProperty("round_name")
    public void setRoundName(Integer roundName) {
        this.roundName = roundName;
    }

    @JsonProperty("stage_id")
    public Integer getStageId() {
        return stageId;
    }

    @JsonProperty("stage_id")
    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    @JsonProperty("stage_name")
    public String getStageName() {
        return stageName;
    }

    @JsonProperty("stage_name")
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    @JsonProperty("standings")
    public StandingRows getStandings() {
        return standings;
    }

    @JsonProperty("standings")
    public void setStandings(StandingRows standings) {
        this.standings = standings;
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