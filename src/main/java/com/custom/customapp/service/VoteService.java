package com.custom.customapp.service;

import com.custom.customapp.dao.VoteDao;
import com.custom.customapp.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VoteService {

    private final VoteDao voteDao;

    @Autowired
    public VoteService(@Qualifier("postgres") VoteDao voteDao){
        this.voteDao = voteDao;
    }

    public int addVote(Vote vote){
        return voteDao.insertVote(vote);
    }

    public List<Vote> getAllVotes(){
        return voteDao.selectAllVotes();
    }

    public Optional<Vote> getVoteById(UUID id){
        return voteDao.selectVoteById(id);
    }

    public List<Vote> getVoteByCountry(String country){
        return voteDao.selectVoteByCountry(country);
    }

    public List<Vote> getVoteByCity(String city){
        return voteDao.selectVoteByCity(city);
    }

    public List<Vote> getVoteByDate(LocalDateTime datetime){
        return voteDao.selectVoteByDate(datetime);
    }

    public List<Vote> getVoteByYear(LocalDateTime datetime){
        return voteDao.selectVoteByYear(datetime);
    }

    public List<Vote> getVoteByHappyScore(Integer happyScore){
        return voteDao.selectVoteByHappyScore(happyScore);
    }

    public List<Vote> getVoteByUserId(UUID userId){
        return voteDao.selectVoteByUserId(userId);
    }

    public List<Vote>getVoteByGroupId(UUID groupId){
        return voteDao.selectVoteByGroupId(groupId)
    }

    public int deleteVote(UUID id){
        return voteDao.deleteVoteById(id);
    }

    public int updateVote(UUID id, Vote newVote) {
        return voteDao.updateVoteById(id, newVote);
    }
}
