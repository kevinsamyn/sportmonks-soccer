package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"continent", "sub_region", "world_region", "fifa", "longitude", "latitude", "flag"})
public class CountryExtra {

    @JsonProperty("continent")
    private String continent;
    @JsonProperty("sub_region")
    private String subRegion;
    @JsonProperty("world_region")
    private String worldRegion;
    @JsonProperty("fifa")
    private String fifa;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("flag")
    private String flag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("continent")
    public String getContinent() {
        return continent;
    }

    @JsonProperty("continent")
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @JsonProperty("sub_region")
    public String getSubRegion() {
        return subRegion;
    }

    @JsonProperty("sub_region")
    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    @JsonProperty("world_region")
    public String getWorldRegion() {
        return worldRegion;
    }

    @JsonProperty("world_region")
    public void setWorldRegion(String worldRegion) {
        this.worldRegion = worldRegion;
    }

    @JsonProperty("fifa")
    public String getFifa() {
        return fifa;
    }

    @JsonProperty("fifa")
    public void setFifa(String fifa) {
        this.fifa = fifa;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("flag")
    public String getFlag() {
        return flag;
    }

    @JsonProperty("flag")
    public void setFlag(String flag) {
        this.flag = flag;
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