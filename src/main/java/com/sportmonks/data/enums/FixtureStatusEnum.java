package com.sportmonks.data.enums;

/**
 * Created by kevin on 21/05/2016.
 */
public enum FixtureStatusEnum {
    NS("Not started"),

    LIVE("Live"),

    HT("Half-Time"),

    FT("Full-Time"),

    ET("Extra-Time"),

    PEN_LIVE("Penalty Shootout"),

    AET("Finished after extra time"),

    BREAK("Match finished, waiting for extra time to start"),

    FT_PEN("Full-Time after penalties"),

    CANCL("Cancelled"),

    POSTP("PostPhoned"),

    INT("Interrupted"),

    ABAN("Abandoned"),

    SUSP("Suspended"),

    AWARDED("Awarded"),

    DELAYED("Delayed");

    private final String label;

    FixtureStatusEnum(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
