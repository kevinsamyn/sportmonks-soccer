package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class MarketsEndPointParams extends AbstractEndPointParams {
    private Set<String> relations = new HashSet<>();
    private Integer marketId;

    /**
     * @param relation voulue
     */
    public void addRelation(final MarketsEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return String relations
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    /**
     * @return true si market id valide
     */
    public boolean isValidId() {
        return marketId != null && marketId > 0;
    }
}
