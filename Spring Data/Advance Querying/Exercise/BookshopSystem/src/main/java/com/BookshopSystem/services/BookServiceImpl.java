package com.BookshopSystem.services;

import com.BookshopSystem.entities.*;
import com.BookshopSystem.repositories.BookRepository;
import com.BookshopSystem.services.intefaces.AuthorService;
import com.BookshopSystem.services.intefaces.BookService;
import com.BookshopSystem.services.intefaces.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOK_FILE_PATH = "src/main/resources/files/books.txt";

    private BookRepository bookRepository;
    private AuthorService authorService;
    private CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBook() throws IOException {

        if (bookRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(BOOK_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBook(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<String> getBookTitleByAgeRestriction(String ageRestriction) {
        return bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase(Locale.ROOT)))
                .stream()
                .map(b -> String.format("%s", b.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllGoldenBookTitle() {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(book -> String.format("%s", book.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBookTitleAndPriceOutOfRange() {
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(new BigDecimal(5), new BigDecimal(40))
                .stream()
                .map(book -> String.format("%s - $%s",book.getTitle(),book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksWithDifferentYear(int year) {
        return bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate.of(year, 1, 1), LocalDate.of(year, 12, 31))
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBooksReleasedBeforeDate(String date) {
        return bookRepository.findAllByReleaseDateBefore(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .stream()
                .map(b -> String.format("%s %s %s", b.getTitle(), b.getEditionType(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBookTitleAndAuthorWithLastNameStartWith(String startWith) {
        List<String> result = new ArrayList<>();
        authorService.getAllByLastNameStartWith(startWith)
                .forEach(author -> {
                    author.getBooks()
                            .forEach(book -> result.add(String.format("%s (%s %s)", book.getTitle(), author.getFirstName(), author.getLastName())));
                });
        return result;
    }

    @Override
    public List<String> getAllTitlesContainsString(String substring) {
        return bookRepository.findAllByTitleContains(substring)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public int getCountOfBookWhereTitleLongerThan(int longerThan) {
        return bookRepository.findAllByTitleLengthGreaterThan(longerThan);
    }

    private Book createBook(String[] bookInfo) {

        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate localDate = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo).skip(5).collect(Collectors.joining(" "));
        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        Book book = new Book(editionType, localDate, copies, price, ageRestriction, title, author, categories);
        return book;
    }
}
