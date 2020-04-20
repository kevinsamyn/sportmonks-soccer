package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.structure.Coachs;
import com.sportmonks.data.structure.FifaRanking;
import com.sportmonks.data.structure.Squad;
import com.sportmonks.data.structure.UefaRanking;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "legacy_id", "name", "twitter", "country_id", "national_team", "founded", "logo_path", "venue_id", "squad", "venue", "coach",
        "fifaranking", "uefaranking"})
public class Team {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("legacy_id")
    private Integer legacyId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("twitter")
    private Object twitter;
    @JsonProperty("country_id")
    private Long countryId;
    @JsonProperty("national_team")
    private Boolean nationalTeam;
    @JsonProperty("founded")
    private Integer founded;
    @JsonProperty("logo_path")
    private String logoPath;
    @JsonProperty("venue_id")
    private Long venueId;
    @JsonProperty("squad")
    private Squad squad;
    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("coach")
    private Coachs coachs;
    @JsonProperty("fifaranking")
    private FifaRanking fifaRanking;
    @JsonProperty("uefaranking")
    private UefaRanking uefaRanking;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("legacy_id")
    public Integer getLegacyId() {
        return legacyId;
    }

    @JsonProperty("legacy_id")
    public void setLegacyId(Integer legacyId) {
        this.legacyId = legacyId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("twitter")
    public Object getTwitter() {
        return twitter;
    }

    @JsonProperty("twitter")
    public void setTwitter(Object twitter) {
        this.twitter = twitter;
    }

    @JsonProperty("country_id")
    public Long getCountryId() {
        return countryId;
    }

    @JsonProperty("country_id")
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("national_team")
    public Boolean getNationalTeam() {
        return nationalTeam;
    }

    @JsonProperty("national_team")
    public void setNationalTeam(Boolean nationalTeam) {
        this.nationalTeam = nationalTeam;
    }

    @JsonProperty("founded")
    public Integer getFounded() {
        return founded;
    }

    @JsonProperty("founded")
    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    @JsonProperty("logo_path")
    public String getLogoPath() {
        return logoPath;
    }

    @JsonProperty("logo_path")
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @JsonProperty("venue_id")
    public Long getVenueId() {
        return venueId;
    }

    @JsonProperty("venue_id")
    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    @JsonProperty("squad")
    public Squad getSquad() {
        return squad;
    }

    @JsonProperty("squad")
    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    @JsonProperty("venue")
    public Venue getVenue() {
        return venue;
    }

    @JsonProperty("venue")
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @JsonProperty("coach")
    public Coachs getCoachs() {
        return coachs;
    }

    @JsonProperty("coach")
    public void setCoachs(Coachs coachs) {
        this.coachs = coachs;
    }

    @JsonProperty("fifaRanking")
    public FifaRanking getFifaRanking() {
        return fifaRanking;
    }

    @JsonProperty("fifaRanking")
    public void setFifaRanking(FifaRanking fifaRanking) {
        this.fifaRanking = fifaRanking;
    }

    @JsonProperty("uefaRanking")
    public UefaRanking getUefaRanking() {
        return uefaRanking;
    }

    @JsonProperty("uefaRanking")
    public void setUefaRanking(UefaRanking uefaRanking) {
        this.uefaRanking = uefaRanking;
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