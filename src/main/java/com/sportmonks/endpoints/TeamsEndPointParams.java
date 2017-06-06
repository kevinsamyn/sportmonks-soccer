package com.sportmonks.endpoints;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kevin on 21/05/2016.
 */
public class TeamsEndPointParams extends AbstractEndPointParams {
	private Integer teamId;
	private Integer seasonId;
	private Set<String> relations = new HashSet<>();

	/**
	 * @return
	 */
	public Integer getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return
	 */
	public Integer getSeasonId() {
		return seasonId;
	}

	/**
	 * @param seasonId
	 */
	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}

	/**
	 * @param relation
	 */
	public void addRelation(final TeamsEndPoint.Relation relation) {
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
	public boolean isValidTeamId() {
		return teamId != null && teamId > 0;
	}

	/**
	 * @return
	 */
	public boolean isValidSeasonId() {
		return seasonId != null && seasonId > 0;
	}
}
