package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kevin on 28/05/2016.
 */
public class CountriesEndPointParams extends AbstractEndPointParams {
    private final Set<String> relations = new HashSet<>();
    private Integer countryId;

    /**
     * @param relation voulue
     */
    public void addRelation(final CountriesEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return String relations
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    /**
     * @return true si country id is valide
     */
    public boolean isValidId() {
        return countryId != null && countryId > 0;
    }

    /**
     * @return id country
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * @param countryId id country
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

}
