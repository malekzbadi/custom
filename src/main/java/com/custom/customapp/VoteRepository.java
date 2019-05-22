package com.custom.customapp;

import org.springframework.data.repository.CrudRepository;
import com.custom.customapp.model.Vote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers to Create, Read, Update, Delete

public interface VoteRepository extends CrudRepository<Vote, Integer> {
    Vote getVoteById(UUID id);

    List<Vote> getVoteByCountry(String country);

    List<Vote> getVoteByCity(String city);

    List<Vote> getVoteByHappyScore(Integer happyScore);

    List<Vote> getVoteByUserId(UUID userId);

    List<Vote> getVoteByGroupId(UUID groupId);
}