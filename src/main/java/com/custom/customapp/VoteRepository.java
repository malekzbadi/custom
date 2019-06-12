package com.custom.customapp;

import com.custom.customapp.model.Vote;

import java.util.List;
import java.util.UUID;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers to Create, Read, Update, Delete

public interface VoteRepository {
    Vote getVoteById(UUID id);

    List<Vote> getVoteByCountry(String country);

    List<Vote> getVoteByCity(String city);

    List<Vote> getVoteByHappyScore(Integer happyScore);

    List<Vote> getVoteByUserId(UUID userId);

    List<Vote> findByDatetimeContaining(String datetime);
}
