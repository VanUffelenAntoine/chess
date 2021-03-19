package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Variant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VariantRepository extends CrudRepository<Variant, Integer> {
    @Query("select v from Variant v where (?1 is null or v.parentOpening.id = ?1)")
    List<Variant> findByParentIdQuery(Integer Id);
}
