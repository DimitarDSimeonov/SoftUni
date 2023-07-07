package com.BookshopSystem.services.intefaces;

import com.BookshopSystem.entities.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void seedBook() throws IOException;

    List<Book> getAllBookAfterYear(LocalDate localDate);

    void printBookTitle(Book book);

    List<String> getAllBookBeforeYear(int year);

    List<String> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}
