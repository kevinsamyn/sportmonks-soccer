package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.structure.Formations;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "league_id", "season_id", "stage_id", "round_id", "aggregate_id", "venue_id", "referee_id", "localteam_id", "visitorteam_id",
        "weather_report", "commentaries", "attendance", "winning_odds_calculated", "formations", "scores", "time", "deleted"})
public class Result {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("league_id")
    private Integer leagueId;
    @JsonProperty("season_id")
    private Integer seasonId;
    @JsonProperty("stage_id")
    private Integer stageId;
    @JsonProperty("round_id")
    private Integer roundId;
    @JsonProperty("aggregate_id")
    private Object aggregateId;
    @JsonProperty("venue_id")
    private Integer venueId;
    @JsonProperty("referee_id")
    private Object refereeId;
    @JsonProperty("localteam_id")
    private Integer localteamId;
    @JsonProperty("visitorteam_id")
    private Integer visitorteamId;
    @JsonProperty("weather_report")
    private Object weatherReport;
    @JsonProperty("commentaries")
    private Boolean commentaries;
    @JsonProperty("attendance")
    private Object attendance;
    @JsonProperty("winning_odds_calculated")
    private Boolean winningOddsCalculated;
    @JsonProperty("formations")
    private Formations formations;
    @JsonProperty("scores")
    private FixtureScores scores;
    @JsonProperty("time")
    private FixtureTime time;
    @JsonProperty("deleted")
    private Boolean deleted;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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

    @JsonProperty("stage_id")
    public Integer getStageId() {
        return stageId;
    }

    @JsonProperty("stage_id")
    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    @JsonProperty("round_id")
    public Integer getRoundId() {
        return roundId;
    }

    @JsonProperty("round_id")
    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    @JsonProperty("aggregate_id")
    public Object getAggregateId() {
        return aggregateId;
    }

    @JsonProperty("aggregate_id")
    public void setAggregateId(Object aggregateId) {
        this.aggregateId = aggregateId;
    }

    @JsonProperty("venue_id")
    public Integer getVenueId() {
        return venueId;
    }

    @JsonProperty("venue_id")
    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    @JsonProperty("referee_id")
    public Object getRefereeId() {
        return refereeId;
    }

    @JsonProperty("referee_id")
    public void setRefereeId(Object refereeId) {
        this.refereeId = refereeId;
    }

    @JsonProperty("localteam_id")
    public Integer getLocalteamId() {
        return localteamId;
    }

    @JsonProperty("localteam_id")
    public void setLocalteamId(Integer localteamId) {
        this.localteamId = localteamId;
    }

    @JsonProperty("visitorteam_id")
    public Integer getVisitorteamId() {
        return visitorteamId;
    }

    @JsonProperty("visitorteam_id")
    public void setVisitorteamId(Integer visitorteamId) {
        this.visitorteamId = visitorteamId;
    }

    @JsonProperty("weather_report")
    public Object getWeatherReport() {
        return weatherReport;
    }

    @JsonProperty("weather_report")
    public void setWeatherReport(Object weatherReport) {
        this.weatherReport = weatherReport;
    }

    @JsonProperty("commentaries")
    public Boolean getCommentaries() {
        return commentaries;
    }

    @JsonProperty("commentaries")
    public void setCommentaries(Boolean commentaries) {
        this.commentaries = commentaries;
    }

    @JsonProperty("attendance")
    public Object getAttendance() {
        return attendance;
    }

    @JsonProperty("attendance")
    public void setAttendance(Object attendance) {
        this.attendance = attendance;
    }

    @JsonProperty("winning_odds_calculated")
    public Boolean getWinningOddsCalculated() {
        return winningOddsCalculated;
    }

    @JsonProperty("winning_odds_calculated")
    public void setWinningOddsCalculated(Boolean winningOddsCalculated) {
        this.winningOddsCalculated = winningOddsCalculated;
    }

    @JsonProperty("formations")
    public Formations getFormations() {
        return formations;
    }

    @JsonProperty("formations")
    public void setFormations(Formations formations) {
        this.formations = formations;
    }

    @JsonProperty("scores")
    public FixtureScores getScores() {
        return scores;
    }

    @JsonProperty("scores")
    public void setScores(FixtureScores scores) {
        this.scores = scores;
    }

    @JsonProperty("time")
    public FixtureTime getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(FixtureTime time) {
        this.time = time;
    }

    @JsonProperty("deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    @JsonProperty("deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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