package jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteService{

    @Autowired
    VoteRepository voteRepository;
    
    @Transactional
    public void vote(Long jokeId, String voteType){
        Vote vote = findVoteByJokeId(jokeId);
        
        if("up".equals(voteType)){
            vote.setUpVotes(vote.getUpVotes() + 1);
        } else if("down".equals(voteType)){
            vote.setDownVotes(vote.getDownVotes() + 1);
        }
    }
    
    @Transactional
    public Vote findVoteByJokeId(Long jokeId) {
        Vote vote = this.voteRepository.findByJokeId(jokeId);
        if(vote == null) {
            vote = new Vote(jokeId, 0, 0);
            voteRepository.save(vote);
        }
        return vote;
    }
}