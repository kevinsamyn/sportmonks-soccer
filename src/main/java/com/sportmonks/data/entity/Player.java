package com.sportmonks.data.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"player_id", "team_id", "country_id", "position_id", "common_name", "fullname", "firstname", "lastname", "nationality", "birthdate",
        "birthcountry", "birthplace", "height", "weight", "image_path"})
public class Player {

    @JsonProperty("player_id")
    private Long playerId;
    @JsonProperty("team_id")
    private Long teamId;
    @JsonProperty("country_id")
    private Long countryId;
    @JsonProperty("position_id")
    private Long positionId;
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("fullname")
    private String fullname;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("birthdate")
    private String birthdate;
    @JsonProperty("birthcountry")
    private String birthcountry;
    @JsonProperty("birthplace")
    private String birthplace;
    @JsonProperty("height")
    private String height;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("image_path")
    private String imagePath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("player_id")
    public Long getPlayerId() {
        return playerId;
    }

    @JsonProperty("player_id")
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    @JsonProperty("team_id")
    public Long getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("country_id")
    public Long getCountryId() {
        return countryId;
    }

    @JsonProperty("country_id")
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("position_id")
    public Long getPositionId() {
        return positionId;
    }

    @JsonProperty("position_id")
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    @JsonProperty("common_name")
    public String getCommonName() {
        return commonName;
    }

    @JsonProperty("common_name")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @JsonProperty("fullname")
    public String getFullname() {
        return fullname;
    }

    @JsonProperty("fullname")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @JsonProperty("birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    @JsonProperty("birthdate")
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @JsonProperty("birthcountry")
    public String getBirthcountry() {
        return birthcountry;
    }

    @JsonProperty("birthcountry")
    public void setBirthcountry(String birthcountry) {
        this.birthcountry = birthcountry;
    }

    @JsonProperty("birthplace")
    public String getBirthplace() {
        return birthplace;
    }

    @JsonProperty("birthplace")
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    @JsonProperty("weight")
    public String getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(String weight) {
        this.weight = weight;
    }

    @JsonProperty("image_path")
    public String getImagePath() {
        return imagePath;
    }

    @JsonProperty("image_path")
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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