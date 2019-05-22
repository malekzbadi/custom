package com.custom.customapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private final UUID id;
    @NotBlank
    @Column
    private final UUID userId;
    @Column
    private final String country;
    @Column
    private final String city;
    @Column
    @NotBlank
    private final Integer happyScore;
    @Column
    @NotBlank
    private final LocalDateTime datetime;
    @Column
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
