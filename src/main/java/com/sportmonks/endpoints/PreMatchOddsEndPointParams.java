package com.sportmonks.endpoints;

/**
 * Created by kevin on 21/05/2016.
 */
public class PreMatchOddsEndPointParams extends AbstractEndPointParams {
	private Integer fixtureId;
	private Integer bookmakerId;

	public Integer getFixtureId() {
		return fixtureId;
	}

	public void setFixtureId(Integer fixtureId) {
		this.fixtureId = fixtureId;
	}

	public Integer getBookmakerId() {
		return bookmakerId;
	}

	public void setBookmakerId(final Integer bookmakerId) {
		this.bookmakerId = bookmakerId;
	}

	public boolean isValidFixtureId() {
		return fixtureId != null && fixtureId > 0;
	}

	public boolean isValidBookmakerId() {
		return bookmakerId != null && bookmakerId > 0;
	}
}
