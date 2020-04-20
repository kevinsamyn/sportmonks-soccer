package com.sportmonks.endpoints;

/**
 * Created by kevin on 21/05/2016.
 */
public class PreMatchOddsEndPointParams extends AbstractEndPointParams {
    private Long fixtureId;
    private Long bookmakerId;

    public Long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(final Long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Long getBookmakerId() {
        return bookmakerId;
    }

    public void setBookmakerId(final Long bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    public boolean isValidFixtureId() {
        return fixtureId != null && fixtureId > 0;
    }

    public boolean isValidBookmakerId() {
        return bookmakerId != null && bookmakerId > 0;
    }
}
