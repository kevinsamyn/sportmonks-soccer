package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kevin on 21/05/2016.
 */
public class VideoHighlightsEndPointParams extends AbstractEndPointParams {
    private Integer fixtureId;
    private Set<String> relations = new HashSet<>();

    /**
     * @return id fixture
     */
    public Integer getFixtureId() {
        return fixtureId;
    }

    /**
     * @param fixtureId id fixture
     */
    public void setFixtureId(Integer fixtureId) {
        this.fixtureId = fixtureId;
    }

    /**
     * @param relation voulue
     */
    public void addRelation(final VideoHighlightsEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return String relations
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    /**
     * @return true si id fixture valide
     */
    public boolean isValidId() {
        return fixtureId != null && fixtureId > 0;
    }

}
