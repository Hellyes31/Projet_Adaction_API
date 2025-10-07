package adaction.repositories;

import adaction.models.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CollectsRepository extends JpaRepository<Collect, Long> {
}