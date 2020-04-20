package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"team_id", "season_id", "win", "draw", "lost", "goals_for", "goals_against", "clean_sheet", "scoring_minutes", "avg_goals_per_game_scored",
        "avg_goals_per_game_conceded", "avg_first_goal_scored", "avg_first_goal_conceded", "failed_to_score"})
public class TeamSeasonStats {

    @JsonProperty("team_id")
    private Integer teamId;
    @JsonProperty("season_id")
    private Integer seasonId;
    @JsonProperty("win")
    private TeamSeasonStatsRow win;
    @JsonProperty("draw")
    private TeamSeasonStatsRow draw;
    @JsonProperty("lost")
    private TeamSeasonStatsRow lost;
    @JsonProperty("goals_for")
    private TeamSeasonStatsRow goalsFor;
    @JsonProperty("goals_against")
    private TeamSeasonStatsRow goalsAgainst;
    @JsonProperty("clean_sheet")
    private TeamSeasonStatsRow cleanSheet;
    @JsonProperty("scoring_minutes")
    private List<ScoringMinute> scoringMinutes = null;
    @JsonProperty("avg_goals_per_game_scored")
    private TeamSeasonStatsRow avgGoalsPerGameScored;
    @JsonProperty("avg_goals_per_game_conceded")
    private TeamSeasonStatsRow avgGoalsPerGameConceded;
    @JsonProperty("avg_first_goal_scored")
    private TeamSeasonStatsRow avgFirstGoalScored;
    @JsonProperty("avg_first_goal_conceded")
    private TeamSeasonStatsRow avgFirstGoalConceded;
    @JsonProperty("failed_to_score")
    private TeamSeasonStatsRow failedToScore;
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

    @JsonProperty("season_id")
    public Integer getSeasonId() {
        return seasonId;
    }

    @JsonProperty("season_id")
    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    @JsonProperty("win")
    public TeamSeasonStatsRow getWin() {
        return win;
    }

    @JsonProperty("win")
    public void setWin(TeamSeasonStatsRow win) {
        this.win = win;
    }

    @JsonProperty("draw")
    public TeamSeasonStatsRow getDraw() {
        return draw;
    }

    @JsonProperty("draw")
    public void setDraw(TeamSeasonStatsRow draw) {
        this.draw = draw;
    }

    @JsonProperty("lost")
    public TeamSeasonStatsRow getLost() {
        return lost;
    }

    @JsonProperty("lost")
    public void setLost(TeamSeasonStatsRow lost) {
        this.lost = lost;
    }

    @JsonProperty("goals_for")
    public TeamSeasonStatsRow getGoalsFor() {
        return goalsFor;
    }

    @JsonProperty("goals_for")
    public void setGoalsFor(TeamSeasonStatsRow goalsFor) {
        this.goalsFor = goalsFor;
    }

    @JsonProperty("goals_against")
    public TeamSeasonStatsRow getGoalsAgainst() {
        return goalsAgainst;
    }

    @JsonProperty("goals_against")
    public void setGoalsAgainst(TeamSeasonStatsRow goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    @JsonProperty("clean_sheet")
    public TeamSeasonStatsRow getCleanSheet() {
        return cleanSheet;
    }

    @JsonProperty("clean_sheet")
    public void setCleanSheet(TeamSeasonStatsRow cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

    @JsonProperty("scoring_minutes")
    public List<ScoringMinute> getScoringMinutes() {
        return scoringMinutes;
    }

    @JsonProperty("scoring_minutes")
    public void setScoringMinutes(List<ScoringMinute> scoringMinutes) {
        this.scoringMinutes = scoringMinutes;
    }

    @JsonProperty("avg_goals_per_game_scored")
    public TeamSeasonStatsRow getAvgGoalsPerGameScored() {
        return avgGoalsPerGameScored;
    }

    @JsonProperty("avg_goals_per_game_scored")
    public void setAvgGoalsPerGameScored(TeamSeasonStatsRow avgGoalsPerGameScored) {
        this.avgGoalsPerGameScored = avgGoalsPerGameScored;
    }

    @JsonProperty("avg_goals_per_game_conceded")
    public TeamSeasonStatsRow getAvgGoalsPerGameConceded() {
        return avgGoalsPerGameConceded;
    }

    @JsonProperty("avg_goals_per_game_conceded")
    public void setAvgGoalsPerGameConceded(TeamSeasonStatsRow avgGoalsPerGameConceded) {
        this.avgGoalsPerGameConceded = avgGoalsPerGameConceded;
    }

    @JsonProperty("avg_first_goal_scored")
    public TeamSeasonStatsRow getAvgFirstGoalScored() {
        return avgFirstGoalScored;
    }

    @JsonProperty("avg_first_goal_scored")
    public void setAvgFirstGoalScored(TeamSeasonStatsRow avgFirstGoalScored) {
        this.avgFirstGoalScored = avgFirstGoalScored;
    }

    @JsonProperty("avg_first_goal_conceded")
    public TeamSeasonStatsRow getAvgFirstGoalConceded() {
        return avgFirstGoalConceded;
    }

    @JsonProperty("avg_first_goal_conceded")
    public void setAvgFirstGoalConceded(TeamSeasonStatsRow avgFirstGoalConceded) {
        this.avgFirstGoalConceded = avgFirstGoalConceded;
    }

    @JsonProperty("failed_to_score")
    public TeamSeasonStatsRow getFailedToScore() {
        return failedToScore;
    }

    @JsonProperty("failed_to_score")
    public void setFailedToScore(TeamSeasonStatsRow failedToScore) {
        this.failedToScore = failedToScore;
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