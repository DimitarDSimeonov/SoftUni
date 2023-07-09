package com.BookshopSystem.repositories;

import com.BookshopSystem.entities.AgeRestriction;
import com.BookshopSystem.entities.Book;
import com.BookshopSystem.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAgeRestriction(AgeRestriction indexOFAgeRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType gold, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPrice, BigDecimal higherPrice);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContains(String substring);

    @Query("Select count(b) from Book b where length(b.title)  > :length")
    Integer findAllByTitleLengthGreaterThan(Integer length);

    Book findByTitle(String title);

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);
}
