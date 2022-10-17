package repository.crudRepository;

import model.Games;
import org.springframework.data.repository.CrudRepository;

public interface GameCrudRepository extends CrudRepository<Games, Integer> {
}
