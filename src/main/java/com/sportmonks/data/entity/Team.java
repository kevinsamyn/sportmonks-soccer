package com.sportmonks.data.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.structure.Squad;
import com.sportmonks.data.structure.TeamStats;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "legacy_id", "name", "twitter", "country_id", "national_team", "founded", "logo_path", "venue_id", "country", "squad", "stats",
		"venue" })
public class Team {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("legacy_id")
	private Integer legacyId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("twitter")
	private Object twitter;
	@JsonProperty("country_id")
	private Integer countryId;
	@JsonProperty("national_team")
	private Boolean nationalTeam;
	@JsonProperty("founded")
	private Integer founded;
	@JsonProperty("logo_path")
	private String logoPath;
	@JsonProperty("venue_id")
	private Integer venueId;
	@JsonProperty("country")
	private Country country;
	@JsonProperty("squad")
	private Squad squad;
	@JsonProperty("stats")
	private TeamStats stats;
	@JsonProperty("venue")
	private Venue venue;
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
	public Integer getCountryId() {
		return countryId;
	}

	@JsonProperty("country_id")
	public void setCountryId(Integer countryId) {
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
	public Integer getVenueId() {
		return venueId;
	}

	@JsonProperty("venue_id")
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}

	@JsonProperty("country")
	public Country getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(Country country) {
		this.country = country;
	}

	@JsonProperty("squad")
	public Squad getSquad() {
		return squad;
	}

	@JsonProperty("squad")
	public void setSquad(Squad squad) {
		this.squad = squad;
	}

	@JsonProperty("stats")
	public TeamStats getStats() {
		return stats;
	}

	@JsonProperty("stats")
	public void setStats(TeamStats stats) {
		this.stats = stats;
	}

	@JsonProperty("venue")
	public Venue getVenue() {
		return venue;
	}

	@JsonProperty("venue")
	public void setVenue(Venue venue) {
		this.venue = venue;
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