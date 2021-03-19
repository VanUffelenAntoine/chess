package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Integer> {
}
