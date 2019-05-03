package com.custom.customapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

public class Vote {
    private final UUID id;
    @NotBlank
    private final UUID userId;
    private final String country;
    private final String city;
    @NotBlank
    private final Integer happyScore;
    @NotBlank
    private final LocalDateTime datetime;
    private final UUID groupId;

    public Vote(@JsonProperty("id") UUID id,
                @JsonProperty("uderId") UUID userId,
                @JsonProperty("country") String country,
                @JsonProperty("city") String city,
                @JsonProperty("happyScore") Integer happyScore,
                @JsonProperty("datetime") LocalDateTime datetime,
                @JsonProperty("projectId") UUID groupId) {
        this.id = id;
        this.userId = userId;
        this.country = country;
        this.city = city;
        this.happyScore = happyScore;
        this.datetime = datetime;
        this.groupId = groupId;
    }

    public UUID getId(){
        return id;
    }

    public UUID getUserId(){
        return userId;
    }

    public String getCountry(){
        return country;
    }

    public String getCity(){
        return city;
    }

    public Integer getHappyScore(){
        return happyScore;
    }

    public LocalDateTime getDatetime(){
        return datetime;
    }

    public UUID getGroupId() {
        return groupId;
    }
}
