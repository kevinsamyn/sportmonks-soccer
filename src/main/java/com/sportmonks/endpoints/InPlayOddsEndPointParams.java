package com.sportmonks.endpoints;

/**
 * Created by kevin on 21/05/2016.
 */
public class InPlayOddsEndPointParams extends AbstractEndPointParams {
	private Integer fixtureId;

	public Integer getFixtureId() {
		return fixtureId;
	}

	public void setFixtureId(Integer fixtureId) {
		this.fixtureId = fixtureId;
	}

	public boolean isValidFixtureId() {
		return fixtureId != null && fixtureId > 0;
	}
}
