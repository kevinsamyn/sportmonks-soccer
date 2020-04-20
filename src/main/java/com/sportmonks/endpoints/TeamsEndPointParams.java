package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kevin on 21/05/2016.
 */
public class TeamsEndPointParams extends AbstractEndPointParams {
    private Long teamId;
    private Long seasonId;
    private Set<String> relations = new HashSet<>();

    /**
     * @return id team
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * @param teamId id team
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * @return id season
     */
    public Long getSeasonId() {
        return seasonId;
    }

    /**
     * @param seasonId id season
     */
    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    /**
     * @param relation voulue
     */
    public void addRelation(final TeamsEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return String relations
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    /**
     * @return true si id team valide
     */
    public boolean isValidTeamId() {
        return teamId != null && teamId > 0;
    }

    /**
     * @return trie si season id valide
     */
    public boolean isValidSeasonId() {
        return seasonId != null && seasonId > 0;
    }
}
