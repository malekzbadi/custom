package com.custom.customapp.dao;

import com.custom.customapp.model.Vote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VoteDao {
    int insertVote(UUID id, Vote vote);

    default int insertVote(Vote vote){
        UUID id = UUID.randomUUID();
        return insertVote(id, vote);
    }

    List<Vote> selectAllVotes();

    Optional<Vote> selectVoteById(UUID id);

    List<Vote> selectVoteByCountry(String country);

    List<Vote> selectVoteByCity(String city);

    List<Vote> selectVoteByDate(LocalDateTime datetime);

    List<Vote> selectVoteByYear(LocalDateTime datetime);

    List<Vote> selectVoteByHappyScore(Integer happyScore);

    List<Vote> selectVoteByUserId(UUID userId);

    List<Vote> selectVoteByGroupId(UUID groupId);

    int deleteVoteById(UUID id);

    int updateVoteById(UUID id, Vote vote);
}
