package com.BookshopSystem.services.intefaces;

import com.BookshopSystem.entities.Author;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
