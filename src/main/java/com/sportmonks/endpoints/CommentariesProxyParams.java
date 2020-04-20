package com.sportmonks.endpoints;

/**
 * Created by kevin on 21/05/2016.
 */
public class CommentariesProxyParams extends AbstractEndPointParams {
    private Integer fixtureId;

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
     * @return true si id fixture valide
     */
    public boolean isValidFixtureId() {
        return fixtureId != null && fixtureId > 0;
    }
}
