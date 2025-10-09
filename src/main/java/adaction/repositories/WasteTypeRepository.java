package adaction.repositories;

import adaction.models.Volunteer;
import adaction.models.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface WasteTypeRepository extends JpaRepository<WasteType ,Long>{
    Optional<WasteType> findByLabel(String label);
}
