package com.sportmonks.data.enums;

/**
 * Created by kevin on 21/05/2016.
 */
public enum EventTypeEnum {
    GOAL("goal", "Goal"),

    PENALTY("penalty", "Goal via penalty"),

    MISSED_PENALTY("missed_penalty", "Penalty has been missed (* only available for major leagues)"),

    OWN_GOAL("own-goal", "Own goal"),

    YELLOW_CARD("yellowcard", "Yellow card for player"),

    YELLOW_RED("yellowred", "\t2nd yellow card for player resulting in red card"),

    RED_CARD("redcard", "Direct red card"),

    SUBSTITUTION("substitution", "A player get's substituted");

    private final String label;
    private final String code;

    EventTypeEnum(final String code, final String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
