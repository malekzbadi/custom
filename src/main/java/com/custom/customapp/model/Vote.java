package com.custom.customapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private final UUID id;
    @Column
    private final UUID userId;
    @Column
    private final String country;
    @Column
    private final String city;
    @Column
    private final Integer happyScore;
    @Column
    @NotBlank
    private final String datetime;

    public Vote()
    {
        super();
        this.id = null;
        this.userId = null;
        this.country = null;
        this.city = null;
        this.happyScore = 0;
        this.datetime = null;
    }

    public Vote(@JsonProperty("id") UUID id,
                @JsonProperty("userId") UUID userId,
                @JsonProperty("country") String country,
                @JsonProperty("city") String city,
                @JsonProperty("happyScore") Integer happyScore,
                @JsonProperty("datetime") String datetime) {
        this.id = id;
        this.userId = userId;
        this.country = country;
        this.city = city;
        this.happyScore = happyScore;
        this.datetime = datetime;
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

    public String getDatetime(){
        return datetime;
    }

}
