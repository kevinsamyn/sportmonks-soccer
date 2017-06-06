package com.sportmonks.endpoints;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kevin on 21/05/2016.
 */
public class FixturesEndPointParams extends AbstractEndPointParams {
	private final Set<String> relations = new HashSet<>();
	private Integer fixtureId;
	private String betweenFromDate;
	private String betweenToDate;
	private String date;

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
	 * @param relation
	 */
	public void addRelation(final FixturesEndPoint.Relation relation) {
		relations.add(relation.toString());
	}

	/**
	 * @return
	 */
	public String getRelations() {
		return StringUtils.join(relations, ",");
	}

	/**
	 * @return
	 */
	public boolean isValidId() {
		return fixtureId != null && fixtureId > 0;
	}

	public String getBetweenFromDate() {
		return betweenFromDate;
	}

	public void setBetweenFromDate(final String betweenFromDate) {
		this.betweenFromDate = betweenFromDate;
	}

	public String getBetweenToDate() {
		return betweenToDate;
	}

	public void setBetweenToDate(final String betweenToDate) {
		this.betweenToDate = betweenToDate;
	}

	/**
	 *
	 */
	public boolean isValidFromDate() {
		return !StringUtils.isEmpty(betweenFromDate) && betweenFromDate.length() == 10;
	}

	/**
	 *
	 */
	public boolean isValidToDate() {
		return !StringUtils.isEmpty(betweenToDate) && betweenToDate.length() == 10;
	}

	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}

	public boolean isValidDate() {
		return !StringUtils.isEmpty(date) && date.toString().length() == 10;
	}
}
