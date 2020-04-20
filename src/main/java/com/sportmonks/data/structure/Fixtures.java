package com.sportmonks.data.structure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sportmonks.data.entity.Fixture;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data"})
public class Fixtures extends AbstractEndPointResponse {

    @JsonProperty("data")
    private List<Fixture> data = null;

    @JsonProperty("data")
    public List<Fixture> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Fixture> data) {
        this.data = data;
    }

}