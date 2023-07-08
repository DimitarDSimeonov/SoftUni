package com.BookshopSystem.services.intefaces;

import com.BookshopSystem.entities.Author;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAuthorWithFirstNameEndsWithString(String ends);

    List<Author> getAllByLastNameStartWith(String startWith);
}
