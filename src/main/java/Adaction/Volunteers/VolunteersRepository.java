package Adaction.Volunteers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VolunteersRepository extends JpaRepository<Volunteers, Long> {
}
