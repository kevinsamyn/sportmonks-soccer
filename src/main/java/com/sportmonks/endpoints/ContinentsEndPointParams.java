package com.sportmonks.endpoints;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kevin on 28/05/2016.
 */
public class ContinentsEndPointParams extends AbstractEndPointParams {
	private Integer continentId;
	private Set<String> relations = new HashSet<>();

	public void addRelation(final CountriesEndPoint.Relation relation) {
		relations.add(relation.toString());
	}

	public String getRelations() {
		return StringUtils.join(relations, ",");
	}

	public boolean isValidId() {
		return continentId != null && continentId > 0;
	}

	public Integer getContinentId() {
		return continentId;
	}

	public void setContinentId(Integer continentId) {
		this.continentId = continentId;
	}

}
