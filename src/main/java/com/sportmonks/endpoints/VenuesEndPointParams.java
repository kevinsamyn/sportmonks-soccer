package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kevin on 28/05/2016.
 */
public class VenuesEndPointParams extends AbstractEndPointParams {
    private Integer venueId;
    private Set<String> relations = new HashSet<>();

    public void addRelation(final VenuesEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    public boolean isValidId() {
        return venueId != null && venueId > 0;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

}
