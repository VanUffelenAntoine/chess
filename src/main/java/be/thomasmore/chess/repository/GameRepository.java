package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Game;
import be.thomasmore.chess.model.Opening;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Integer> {

}
