package com.custom.customapp.dao;

import org.springframework.stereotype.Repository;
import com.custom.customapp.model.Vote;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class VoteDataAccessService implements VoteDao{

    private static List<Vote> DB = new ArrayList<>();

    @Override
    public int insertVote(UUID id, Vote vote) {
        DB.add(new Vote(id, vote.getUserId(), vote.getCountry(), vote.getCity(), vote.getHappyScore(), vote.getDatetime(), vote.getGroupId()));
        return 1;
    }

    @Override
    public List<Vote> selectAllVotes() {
        return DB;
    }

    @Override
    public Optional<Vote> selectVoteById(UUID id) {
        return DB.stream()
                .filter(vote -> vote.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Vote> selectVoteByCountry(String country) {
        return DB.stream()
                .filter(vote -> vote.getCountry().equals(country));
    }

    @Override
    public List<Vote> selectVoteByCity(String city){
        return DB.stream()
                .filter(vote -> vote.getCity().equals(city));
    }

    @Override
    public List<Vote> selectVoteByDate(LocalDateTime datetime){
        return DB.stream()
                .filter(vote -> vote.getDatetime().equals(datetime));
    }

    @Override
    public List<Vote> selectVoteByYear(LocalDateTime datetime){
        return DB.stream()
                .filter(vote -> vote.getDatetime().equals(datetime));
    }

    @Override
    public List<Vote> selectVoteByHappyScore(Integer happyScore){
        return DB.stream()
                .filter(vote -> vote.getHappyScore().equals(happyScore));
    }

    @Override
    public List<Vote> selectVoteByUserId(UUID userId){
        return DB.stream()
                .filter(vote -> vote.getUserId().equals(userId));
    }

    @Override
    public List<Vote> selectVoteByGroupId(UUID groupId){
        return DB.stream()
                .filter(vote -> vote.getGroupId().equals(groupId));
    }

    @Override
    public int deleteVoteById(UUID id) {
        Optional<Vote> voteMaybe = selectVoteById(id);
        if (voteMaybe == null) {
            return 0;
        }
        DB.remove(voteMaybe.get());
        return 1;
    }

    @Override
    public int updateVoteById(UUID id, Vote update) {
        return selectVoteById(id)
                .map(vote -> {
                    int indexOfVoteToUpdate = DB.indexOf(vote);
                    if (indexOfVoteToUpdate >= 0) {
                        DB.set(indexOfVoteToUpdate, new Vote(id, update.getUserId(), update.getCountry(), update.getCity(), update.getHappyScore(), update.getDatetime(), update.getGroupId()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
