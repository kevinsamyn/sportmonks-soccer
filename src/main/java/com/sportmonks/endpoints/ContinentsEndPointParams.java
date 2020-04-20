package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kevin on 28/05/2016.
 */
public class ContinentsEndPointParams extends AbstractEndPointParams {
    private final Set<String> relations = new HashSet<>();
    private Integer continentId;

    /**
     * @param relation voulue
     */
    public void addRelation(final ContinentsEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return String relations
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    /**
     * @return true si continent id valide
     */
    public boolean isValidId() {
        return continentId != null && continentId > 0;
    }

    /**
     * @return continent id
     */
    public Integer getContinentId() {
        return continentId;
    }

    /**
     * @param continentId continent id
     */
    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

}
