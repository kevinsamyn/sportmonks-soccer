package com.sportmonks.data.structure;

import com.fasterxml.jackson.annotation.*;
import com.sportmonks.data.entity.Market;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data"})
public class OneMarket {

    @JsonProperty("data")
    private Market data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("data")
    public Market getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Market data) {
        this.data = data;
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