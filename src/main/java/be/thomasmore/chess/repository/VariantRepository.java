package be.thomasmore.chess.repository;

import be.thomasmore.chess.model.Variant;
import org.springframework.data.repository.CrudRepository;

public interface VariantRepository extends CrudRepository<Variant, Integer> {
    Iterable<Variant> findByIdParentMove(int id);
}
