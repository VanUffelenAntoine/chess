package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Opening;
import be.thomasmore.chess.model.Variant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OpeningRepository extends CrudRepository<Opening, Integer> {
    @Query("select o from Opening o where (?1 is null or upper(o.move1) like upper(concat(?1,'%'))) ")
    List<Opening> findByFirstMoveQuery(String move1);

    @Query("select o from Opening o where ?1 is null or upper(o.openingName) like upper(concat('%',?1,'%') ) ")
    Opening findOpeningByName(String opening);

    Opening findByOpeningName(String openingName);

    @Query("select v from Variant v where ?1 is null or v.parentOpening = ?1")
    List<Variant> findVariantsForOpening(Opening opening);
}
