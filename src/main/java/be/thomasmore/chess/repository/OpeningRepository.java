package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Opening;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OpeningRepository extends CrudRepository<Opening, Integer> {
    @Query("select o from Opening o where (?1 is null or upper(o.move1) like upper(concat(?1,'%'))) ")
    List<Opening> findByFirstMoveQuery(String move1);
}
