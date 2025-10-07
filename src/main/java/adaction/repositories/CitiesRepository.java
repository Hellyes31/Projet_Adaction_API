package adaction.repositories;

import adaction.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitiesRepository extends JpaRepository<City, Long> {
    Optional<City> findById(Long cityId);

    @Query("SELECT c FROM City c LEFT JOIN FETCH c.coordinates_id WHERE c.id = :id")
    Optional<City> findCityWithCoordinates(@Param("id") Long id);

    // si tu veux toutes les villes avec coordonnées
    @Query("SELECT DISTINCT c FROM City c LEFT JOIN FETCH c.coordinates_id")
    List<City> findAllWithCoordinates();
}
