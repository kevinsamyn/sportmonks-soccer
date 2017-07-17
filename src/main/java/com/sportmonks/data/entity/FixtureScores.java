package com.sportmonks.data.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "localteam_score", "visitorteam_score", "localteam_pen_score", "visitorteam_pen_score", "ht_score", "ft_score", "et_score" })
public class FixtureScores {

	@JsonProperty("localteam_score")
	private Integer localTeamScore;
	@JsonProperty("visitorteam_score")
	private Integer visitorTeamScore;
	@JsonProperty("localteam_pen_score")
	private Integer localTeamPenScore;
	@JsonProperty("visitorteam_pen_score")
	private Integer visitorTeamPenScore;
	@JsonProperty("ht_score")
	private String htScore;
	@JsonProperty("ft_score")
	private String ftScore;
	@JsonProperty("et_score")
	private String etScore;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("localteam_score")
	public Integer getLocalTeamScore() {
		return localTeamScore;
	}

	@JsonProperty("localteam_score")
	public void setLocalteamScore(Integer localTeamScore) {
		this.localTeamScore = localTeamScore;
	}

	@JsonProperty("visitorteam_score")
	public Integer getVisitorTeamScore() {
		return visitorTeamScore;
	}

	@JsonProperty("visitorteam_score")
	public void setVisitorTeamScore(Integer visitorteamScore) {
		this.visitorTeamScore = visitorteamScore;
	}

	@JsonProperty("localteam_pen_score")
	public Integer getLocalTeamPenScore() {
		return localTeamPenScore;
	}

	@JsonProperty("localteam_pen_score")
	public void setLocalteamPenScore(Integer localteamPenScore) {
		this.localTeamPenScore = localteamPenScore;
	}

	@JsonProperty("visitorteam_pen_score")
	public Integer getVisitorTeamPenScore() {
		return visitorTeamPenScore;
	}

	@JsonProperty("visitorteam_pen_score")
	public void setVisitorTeamPenScore(Integer visitorTeamPenScore) {
		this.visitorTeamPenScore = visitorTeamPenScore;
	}

	@JsonProperty("ht_score")
	public String getHtScore() {
		return htScore;
	}

	@JsonProperty("ht_score")
	public void setHtScore(String htScore) {
		this.htScore = htScore;
	}

	@JsonProperty("ft_score")
	public String getFtScore() {
		return ftScore;
	}

	@JsonProperty("ft_score")
	public void setFtScore(String ftScore) {
		this.ftScore = ftScore;
	}

	@JsonProperty("et_score")
	public String getEtScore() {
		return etScore;
	}

	@JsonProperty("et_score")
	public void setEtScore(String etScore) {
		this.etScore = etScore;
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