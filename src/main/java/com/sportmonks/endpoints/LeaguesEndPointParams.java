package com.sportmonks.endpoints;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kevin on 21/05/2016.
 */
public class LeaguesEndPointParams extends AbstractEndPointParams {
	private Integer leagueId;
	private Set<String> relations = new HashSet<>();

	public Integer getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}

	public void addRelation(final LeaguesEndPoint.Relation relation) {
		relations.add(relation.toString());
	}

	public String getRelations() {
		return StringUtils.join(relations, ",");
	}

	public boolean isValidId() {
		return leagueId != null && leagueId > 0;
	}
}
