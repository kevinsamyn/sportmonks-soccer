package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class BookmakersEndPointParams extends AbstractEndPointParams {
    private Set<String> relations = new HashSet<>();
    private Integer bookmakerId;

    /**
     * @param relation voule
     */
    public void addRelation(final BookmakersEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return String relations
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    /**
     * @return id bookmaker
     */
    public Integer getBookmakerId() {
        return bookmakerId;
    }

    /**
     * @param bookmakerId id bookmaker
     */
    public void setBookmakerId(Integer bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    /**
     * @return true si bookmaker valide
     */
    public boolean isValidId() {
        return bookmakerId != null && bookmakerId > 0;
    }
}
