package com.sportmonks.data.structure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.entity.League;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data"})
public class Leagues extends AbstractEndPointResponse {

    @JsonProperty("data")
    private List<League> data = null;

    @JsonProperty("data")
    public List<League> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<League> data) {
        this.data = data;
    }

}
