package adaction.repositories;

import adaction.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteersRepository extends JpaRepository<Volunteer, Long> {
    Optional<Volunteer> findByFirstname(String firstname);
}
