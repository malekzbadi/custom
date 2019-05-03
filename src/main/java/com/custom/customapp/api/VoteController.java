package com.custom.customapp.api;

import com.custom.customapp.model.Vote;
import com.custom.customapp.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/vote")
@RestController
public class VoteController {
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService){
        this.voteService = voteService;
    }

    @PostMapping
    public void addVote(@Valid @NonNull @RequestBody Vote vote){
        voteService.addVote(vote);
    }

    @GetMapping
    public List<Vote> getAllVotes(){
        return voteService.getAllVotes();
    }

    @GetMapping(path = "id/{id}")
    public Vote getVoteById(@PathVariable("id") UUID id){
        return voteService.getVoteById(id)
                .orElse(null);
    }

    @GetMapping(path = "country/{country}")
    public List<Vote> getVoteByCountry(@PathVariable("country") String country){
        return voteService.getVoteByCountry(country);
    }

    @GetMapping(path = "city/{city}")
    public List<Vote> getVoteByCity(@PathVariable("city") String city){
        return voteService.getVoteByCity(city);
    }

    @GetMapping(path = "date/{datetime}")
    public List<Vote> getVoteByDate(@PathVariable("datetime") LocalDateTime datetime){
        return voteService.getVoteByDate(datetime);
    }

    @GetMapping(path = "year/{datetime}")
    public List<Vote> getVoteByYear(@PathVariable("datetime") LocalDateTime datetime){
        return voteService.getVoteByYear(datetime);
    }

    @GetMapping(path = "happyScore/{happyScore}")
    public List<Vote> getVoteByHappyScore(@PathVariable("happyScore") Integer happyScore){
        return voteService.getVoteByHappyScore(happyScore);
    }

    @GetMapping(path = "candy/{userid}")
    public List<Vote> getVoteByUserId(@PathVariable("userId") UUID userId){
        return voteService.getVoteByUserId(userId);
    }

    @GetMapping(path = "groupId/{groupId}")
    public List<Vote> getVoteByGroupId(@PathVariable("groupId") UUID groupId){
        return voteService.getVoteByGroupId(groupId);
    }

    @DeleteMapping(path = "{id}")
    public void deleteVoteById(@PathVariable("id") UUID id){
        voteService.deleteVote(id);
    }

    @PutMapping(path = "{id}")
    public void updateVoteById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Vote voteToUpdate){
        voteService.updateVote(id, voteToUpdate);
    }
}
