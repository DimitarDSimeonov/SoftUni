package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Optional<Star> findByName(String name);

    @Query("SELECT s FROM Star s " +
            "WHERE (SELECT COUNT(a) FROM Astronomer a WHERE a.observingStar = s.id) = 0 AND s.starType = 'RED_GIANT' " +
            "ORDER BY s.lightYears")
    List<Star> findStarToExport();
}
