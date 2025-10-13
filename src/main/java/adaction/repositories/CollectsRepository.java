package adaction.repositories;

import adaction.models.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectsRepository extends JpaRepository<Collect, Long> {

    @Query("SELECT c FROM Collect c WHERE YEAR(c.date) = :year AND MONTH(c.date) = :month AND c.volunteer.id = :volunteerId")
    List<Collect> findByYearAndMonthAndVolunteer(
            @Param("year") int year,
            @Param("month") int month,
            @Param("volunteerId") Long volunteerId
    );
    @Query("SELECT c FROM Collect c WHERE YEAR(c.date) = :year AND MONTH(c.date) = :month")
    List<Collect> findByYearAndMonth
            (@Param("year") int year,
             @Param("month") int month);
}