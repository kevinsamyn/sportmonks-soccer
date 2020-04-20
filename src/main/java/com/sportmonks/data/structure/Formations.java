package com.sportmonks.data.structure;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"localteam_formation", "visitorteam_formation"})
public class Formations {

    @JsonProperty("localteam_formation")
    private Object localteamFormation;
    @JsonProperty("visitorteam_formation")
    private Object visitorteamFormation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("localteam_formation")
    public Object getLocalteamFormation() {
        return localteamFormation;
    }

    @JsonProperty("localteam_formation")
    public void setLocalteamFormation(Object localteamFormation) {
        this.localteamFormation = localteamFormation;
    }

    @JsonProperty("visitorteam_formation")
    public Object getVisitorteamFormation() {
        return visitorteamFormation;
    }

    @JsonProperty("visitorteam_formation")
    public void setVisitorteamFormation(Object visitorteamFormation) {
        this.visitorteamFormation = visitorteamFormation;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}