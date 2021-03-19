package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
