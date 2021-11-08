package scoreservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    @Autowired
    private GameRepository gameRepository;
    
    @GetMapping("/games/{name}/scores")
    public List<Score> showGameResults(@PathVariable String name) {
        Game game = gameRepository.findByName(name);
        return scoreRepository.findByGame(game);
    }
    
    @GetMapping("/games/{name}/scores/{id}")
    public Score showScore(@PathVariable Long id, @PathVariable String name) {
        Game game = gameRepository.findByName(name);
        return scoreRepository.findByGameAndId(game, id);
    }
    
    @PostMapping("/games/{name}/scores")
    public Score addScores(@RequestBody Score score, @PathVariable String name) {
        Game game = gameRepository.findByName(name);
        score.setGame(game);
        return scoreRepository.save(score);
    }
    
    @DeleteMapping("games/{name}/scores/{id}")
    public Score removeScore(@PathVariable Long id, @PathVariable String name) {
        Game game = gameRepository.findByName(name);
        Score score = scoreRepository.findByGameAndId(game, id);
        scoreRepository.delete(score);
        return score;
    }
    
}
