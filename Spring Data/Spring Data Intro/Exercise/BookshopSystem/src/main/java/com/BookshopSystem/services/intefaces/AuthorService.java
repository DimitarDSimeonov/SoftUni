package com.BookshopSystem.services.intefaces;

import com.BookshopSystem.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllOrderByBookCount();
}
