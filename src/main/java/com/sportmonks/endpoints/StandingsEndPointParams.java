package com.sportmonks.endpoints;

/**
 * Created by kevin on 21/05/2016.
 */
public class StandingsEndPointParams extends AbstractEndPointParams {
    private Integer seasonId;

    /**
     * @return season id
     */
    public Integer getSeasonId() {
        return seasonId;
    }

    /**
     * @param seasonId id de la saison
     */
    public void setSeasonId(final Integer seasonId) {
        this.seasonId = seasonId;
    }

    /**
     * @return true si id season valide
     */
    public boolean isValidId() {
        return seasonId != null && seasonId > 0;
    }
}
