package service;

import model.Reservation;
import model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ScoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired

    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if(validarCampos(score)) {
            if (score.getIdScore() == null) {
                return scoreRepository.save(score);
            } else {
                Optional<Score> e = getScore(score.getIdScore());
                if (e.isEmpty()) {
                    return scoreRepository.save(score);
                } else {
                    return score;
                }
            }
        }
        return score;
    }

    public Score update(Score score){
        if(validarCampos(score)){
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if(!scoreEncontrado.isEmpty()){
                if(score.getMessageText() !=null){
                    scoreEncontrado.get().setMessageText(score.getMessageText());
                }
                if(score.getStarts() !=null){
                    scoreEncontrado.get().setStarts(score.getStarts());
                }
                return scoreRepository.save(scoreEncontrado.get());
            }
        }
        return score;
    }

    public boolean validarCampos(Score score){
        return (score.getStarts()>=0 && score.getStarts()<=5
                && score.getMessageText().length() <= 250
        );
    }
}
