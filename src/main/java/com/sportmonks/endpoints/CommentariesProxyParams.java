package com.sportmonks.endpoints;

/**
 * Created by kevin on 21/05/2016.
 */
public class CommentariesProxyParams extends AbstractEndPointParams {
	private Integer fixtureId;

	/**
	 *
	 * @return
	 */
	public Integer getFixtureId() {
		return fixtureId;
	}

	/**
	 * @param fixtureId
	 */
	public void setFixtureId(final Integer fixtureId) {
		this.fixtureId = fixtureId;
	}

	/**
	 * @return
	 */
	public boolean isValidFixtureId() {
		return fixtureId != null && fixtureId > 0;
	}
}
