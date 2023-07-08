package com.BookshopSystem.services.intefaces;

import com.BookshopSystem.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {

    void seedBook() throws IOException;

    List<String> getBookTitleByAgeRestriction(String ageRestriction);

    List<String> getAllGoldenBookTitle();

    List<String> getBookTitleAndPriceOutOfRange();

    List<String> getAllBooksWithDifferentYear(int year);

    List<String > getBooksReleasedBeforeDate(String date);

    List<String> getBookTitleAndAuthorWithLastNameStartWith(String startWith);
}
