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
     * @param relation
     */
    public void addRelation(final MarketsEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return
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
     * @return
     */
    public boolean isValidId() {
        return marketId != null && marketId > 0;
    }
}
