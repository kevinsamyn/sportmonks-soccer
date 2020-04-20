package com.sportmonks.endpoints;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kevin on 21/05/2016.
 */
public class FixturesEndPointParams extends AbstractEndPointParams {
    private final Set<String> relations = new HashSet<>();
    private Integer fixtureId;
    private Integer teamId;
    private String betweenFromDate;
    private String betweenToDate;
    private String date;

    /**
     * @return id fixture
     */
    public Integer getFixtureId() {
        return fixtureId;
    }

    /**
     * @param fixtureId id fixture
     */
    public void setFixtureId(final Integer fixtureId) {
        this.fixtureId = fixtureId;
    }

    /**
     * @param relation voulue
     */
    public void addRelation(final FixturesEndPoint.Relation relation) {
        relations.add(relation.toString());
    }

    /**
     * @return String relations
     */
    public String getRelations() {
        return StringUtils.join(relations, ",");
    }

    /**
     * @return true si fixture id valide
     */
    public boolean isValidId() {
        return fixtureId != null && fixtureId > 0;
    }

    public String getBetweenFromDate() {
        return betweenFromDate;
    }

    public void setBetweenFromDate(final String betweenFromDate) {
        this.betweenFromDate = betweenFromDate;
    }

    public String getBetweenToDate() {
        return betweenToDate;
    }

    public void setBetweenToDate(final String betweenToDate) {
        this.betweenToDate = betweenToDate;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     * @return true si date valide
     */
    public boolean isValidFromDate() {
        return !StringUtils.isEmpty(betweenFromDate) && betweenFromDate.length() == 10;
    }

    /**
     * @return true si date valide
     */
    public boolean isValidToDate() {
        return !StringUtils.isEmpty(betweenToDate) && betweenToDate.length() == 10;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public boolean isValidDate() {
        return !StringUtils.isEmpty(date) && date.toString().length() == 10;
    }

    public boolean isValidTeamId() {
        return teamId != null && teamId > 0;
    }
}
