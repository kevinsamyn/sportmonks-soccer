package com.sportmonks.endpoints;

/**
 * Created by kevin on 21/05/2016.
 */
public class StandingsEndPointParams extends AbstractEndPointParams {
	private Integer seasonId;

	/**
	 * @return
	 */
	public Integer getSeasonId() {
		return seasonId;
	}

	/**
	 * @param seasonId
	 */
	public void setSeasonId(final Integer seasonId) {
		this.seasonId = seasonId;
	}

	/**
	 * @return
	 */
	public boolean isValidId() {
		return seasonId != null && seasonId > 0;
	}
}
