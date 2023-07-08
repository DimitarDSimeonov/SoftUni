package com.BookshopSystem.repositories;

import com.BookshopSystem.entities.AgeRestriction;
import com.BookshopSystem.entities.Book;
import com.BookshopSystem.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAgeRestriction(AgeRestriction indexOFAgeRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType gold, Integer copies);
}
