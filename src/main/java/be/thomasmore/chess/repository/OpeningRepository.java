package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Opening;
import org.springframework.data.repository.CrudRepository;

public interface OpeningRepository extends CrudRepository<Opening,Integer> {
}
