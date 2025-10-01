package Adaction.Repositories;

import Adaction.Models.Volunteers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteersRepository extends JpaRepository<Volunteers, Long> {
}
