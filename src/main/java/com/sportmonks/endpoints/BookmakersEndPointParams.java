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
     * @param relation
     */
    public void addRelation(final BookmakersEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    public Integer getBookmakerId() {
        return bookmakerId;
    }

    public void setBookmakerId(Integer bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    /**
     * @return
     */
    public boolean isValidId() {
        return bookmakerId != null && bookmakerId > 0;
    }
}
