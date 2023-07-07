package com.BookshopSystem.services;

import com.BookshopSystem.entities.Author;
import com.BookshopSystem.repositories.AuthorRepository;
import com.BookshopSystem.services.intefaces.AuthorService;
import org.hibernate.engine.internal.ManagedTypeHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHOR_FILE_PATH = "src/main/resources/files/authors.txt";

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if(authorRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(AUTHOR_FILE_PATH))
                .forEach(row -> {
                    Author author = new Author();
                    author.setFirstName(row.split("\\s+")[0]);
                    author.setLastName(row.split("\\s+")[1]);
                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {

        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, authorRepository.count() + 1);

        return authorRepository.findById(randomId)
                .orElse(null);
    }
}
