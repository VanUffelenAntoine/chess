package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Game;
import be.thomasmore.chess.model.Opening;
import be.thomasmore.chess.model.Variant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("select g from Game g where g.id = ?1")
    Game findGameById(Integer id);

    @Query("select g from Game g where ?1 is null or g.openingUsed=(select o from Opening o where ?1 is null or upper(o.openingName) like upper(concat('%',?1,'%') ))")
    List<Game> findGamesUsedOpening(String opening);

    @Query("select g from Game g where ?1 is null or g.variantUsed = ?1")
    List<Game> findGamesUsedVariant(Variant variant);


}
