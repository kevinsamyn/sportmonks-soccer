package com.sportmonks.endpoints;

/**
 * Created by kevin on 28/05/2016.
 */
public abstract class AbstractEndPointParams {
    private String customIncludes;

    public String getCustomIncludes() {
        return customIncludes;
    }

    public void setCustomIncludes(String customIncludes) {
        this.customIncludes = customIncludes;
    }
}
