package com.BookshopSystem.repositories;

import com.BookshopSystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFirstNameEndsWith(String ends);

    List<Author> findAllByLastNameStartsWith(String startWith);
}
