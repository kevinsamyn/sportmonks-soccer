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
@JsonPropertyOrder({ "position", "team_id", "overall", "home", "away", "total" })
public class StandingRow {

	@JsonProperty("position")
	private Integer position;
	@JsonProperty("team_id")
	private Integer teamId;
	@JsonProperty("overall")
	private StandingStats overall;
	@JsonProperty("home")
	private StandingStats home;
	@JsonProperty("away")
	private StandingStats away;
	@JsonProperty("total")
	private StandingRowTotal total;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("position")
	public Integer getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(Integer position) {
		this.position = position;
	}

	@JsonProperty("team_id")
	public Integer getTeamId() {
		return teamId;
	}

	@JsonProperty("team_id")
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	@JsonProperty("overall")
	public StandingStats getOverall() {
		return overall;
	}

	@JsonProperty("overall")
	public void setOverall(StandingStats overall) {
		this.overall = overall;
	}

	@JsonProperty("home")
	public StandingStats getHome() {
		return home;
	}

	@JsonProperty("home")
	public void setHome(StandingStats home) {
		this.home = home;
	}

	@JsonProperty("away")
	public StandingStats getAway() {
		return away;
	}

	@JsonProperty("away")
	public void setAway(StandingStats away) {
		this.away = away;
	}

	@JsonProperty("total")
	public StandingRowTotal getTotal() {
		return total;
	}

	@JsonProperty("total")
	public void setTotal(StandingRowTotal total) {
		this.total = total;
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