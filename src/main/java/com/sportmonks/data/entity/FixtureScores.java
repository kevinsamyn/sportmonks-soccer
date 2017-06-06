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
	private Integer localteamScore;
	@JsonProperty("visitorteam_score")
	private Integer visitorteamScore;
	@JsonProperty("localteam_pen_score")
	private Object localteamPenScore;
	@JsonProperty("visitorteam_pen_score")
	private Object visitorteamPenScore;
	@JsonProperty("ht_score")
	private String htScore;
	@JsonProperty("ft_score")
	private String ftScore;
	@JsonProperty("et_score")
	private Object etScore;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("localteam_score")
	public Integer getLocalteamScore() {
		return localteamScore;
	}

	@JsonProperty("localteam_score")
	public void setLocalteamScore(Integer localteamScore) {
		this.localteamScore = localteamScore;
	}

	@JsonProperty("visitorteam_score")
	public Integer getVisitorteamScore() {
		return visitorteamScore;
	}

	@JsonProperty("visitorteam_score")
	public void setVisitorteamScore(Integer visitorteamScore) {
		this.visitorteamScore = visitorteamScore;
	}

	@JsonProperty("localteam_pen_score")
	public Object getLocalteamPenScore() {
		return localteamPenScore;
	}

	@JsonProperty("localteam_pen_score")
	public void setLocalteamPenScore(Object localteamPenScore) {
		this.localteamPenScore = localteamPenScore;
	}

	@JsonProperty("visitorteam_pen_score")
	public Object getVisitorteamPenScore() {
		return visitorteamPenScore;
	}

	@JsonProperty("visitorteam_pen_score")
	public void setVisitorteamPenScore(Object visitorteamPenScore) {
		this.visitorteamPenScore = visitorteamPenScore;
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
	public Object getEtScore() {
		return etScore;
	}

	@JsonProperty("et_score")
	public void setEtScore(Object etScore) {
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