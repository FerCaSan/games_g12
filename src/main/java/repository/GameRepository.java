package repository;

import repository.crudRepository.GameCrudRepository;
import model.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {

    @Autowired
    private GameCrudRepository gameCrudRepository;

    public Optional<Games> getGames(int id){
        return gameCrudRepository.findById(id);
    }

    public Games save(Games games){
        return gameCrudRepository.save(games);
    }

    public void delete(Games games){
        gameCrudRepository.delete(games);
    }

    public List<Games> getAll(){
        return (List<Games>) gameCrudRepository.findAll();
    }

}
