package com.sportmonks.endpoints;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kevin on 28/05/2016.
 */
public class PlayersEndPointParams extends AbstractEndPointParams {
	private Integer playerId;
	private Set<String> relations = new HashSet<>();

	public void addRelation(final PlayersEndPoint.Relation relation) {
		relations.add(relation.toString());
	}

	public String getRelations() {
		return StringUtils.join(relations, ",");
	}

	public boolean isValidId() {
		return playerId != null && playerId > 0;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

}
