package com.sportmonks.data.structure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.entity.StandingGroup;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data"})
public class Standings extends AbstractEndPointResponse {

    @JsonProperty("data")
    private List<StandingGroup> data = null;

    @JsonProperty("data")
    public List<StandingGroup> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<StandingGroup> data) {
        this.data = data;
    }

}