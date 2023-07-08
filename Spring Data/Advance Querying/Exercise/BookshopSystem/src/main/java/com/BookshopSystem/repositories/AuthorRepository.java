package com.BookshopSystem.repositories;

import com.BookshopSystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFirstNameEndsWith(String ends);

    List<Author> findAllByLastNameStartsWith(String startWith);

    @Query("Select a FROM Author a JOIN a.books b GROUP BY a.id ORDER BY COUNT(b.copies) desc")
    List<Author> findAllByCountOfBookCopies();
}
