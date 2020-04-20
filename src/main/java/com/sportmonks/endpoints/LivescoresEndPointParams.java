package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kevin on 21/05/2016.
 */
public class LivescoresEndPointParams extends AbstractEndPointParams {
    private final Set<String> relations = new HashSet<>();

    /**
     * @param relation voulu
     */
    public void addRelation(final LivescoresEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return String relations
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

}
