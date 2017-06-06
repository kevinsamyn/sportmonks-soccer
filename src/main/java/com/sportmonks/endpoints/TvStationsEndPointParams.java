package com.sportmonks.endpoints;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kevin on 21/05/2016.
 */
public class TvStationsEndPointParams extends AbstractEndPointParams {
	private Integer fixtureId;
	private Set<String> relations = new HashSet<>();

	/**
	 * @return
	 */
	public Integer getFixtureId() {
		return fixtureId;
	}

	/**
	 * @param fixtureId
	 */
	public void setFixtureId(Integer fixtureId) {
		this.fixtureId = fixtureId;
	}

	/**
	 * @param relation
	 */
	public void addRelation(final TvStationsEndPoint.Relation relation) {
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

}
