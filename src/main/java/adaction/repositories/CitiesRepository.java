package adaction.repositories;

import adaction.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitiesRepository extends JpaRepository<City, String> {
    Optional<Object> findById(Long cityId);
}
