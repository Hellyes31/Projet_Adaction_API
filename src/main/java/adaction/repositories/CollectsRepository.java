package adaction.repositories;

import adaction.models.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectsRepository extends JpaRepository<Collect, String> {
    Optional<Collect> findById(Integer id);
}