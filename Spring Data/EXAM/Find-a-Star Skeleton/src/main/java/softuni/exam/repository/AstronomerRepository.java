package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Astronomer;

import java.util.Optional;

@Repository
public interface AstronomerRepository extends JpaRepository<Astronomer, Long> {

    @Query("SELECT a FROM Astronomer a " +
            "WHERE a.firstName = :firstName AND a.lastName = :lastName")
    Optional<Astronomer> findByFistNameLastName(String firstName, String lastName);
}
