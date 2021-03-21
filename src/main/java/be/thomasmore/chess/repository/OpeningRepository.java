package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Opening;
import be.thomasmore.chess.model.Variant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OpeningRepository extends CrudRepository<Opening, Integer> {
    @Query("select o from Opening o where (?1 is null or upper(o.move1) like upper(concat(?1,'%')))and" +
            " (?2 is null or ?2 = 'All' or o.type = ?2) and (?3 is null or o.gambit = ?3) ")
    List<Opening> findByFilter(String move1, String color, Boolean gambit);

    @Query("select o from Opening o where ?1 is null or upper(o.openingName) like upper(concat('%',?1,'%') ) ")
    Opening findOpeningByName(String opening);

    Opening findByOpeningName(String openingName);

    @Query("select v from Variant v where ?1 is null or v.parentOpening = ?1")
    List<Variant> findVariantsForOpening(Opening opening);
}
