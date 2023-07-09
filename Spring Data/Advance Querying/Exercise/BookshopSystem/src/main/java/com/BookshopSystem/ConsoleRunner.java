package com.BookshopSystem;

import com.BookshopSystem.services.intefaces.AuthorService;
import com.BookshopSystem.services.intefaces.BookService;
import com.BookshopSystem.services.intefaces.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private AuthorService authorService;
    private BookService bookService;
    private CategoryService categoryService;
    private Scanner scanner;

    public ConsoleRunner(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello SPRING");

        seedData();
    }
    private void printCountOfRemovedBooks() { //TASK 13
        System.out.println("Enter number of copies");
        int numberOfCopies = scanner.nextInt();

        System.out.println(bookService.getNumberOfDeletedBooks(numberOfCopies));
    }

    private void printNumberOfAddedBooks() { //TASK 12
        System.out.println("Enter date[dd MMM yyyy]");
        String releaseDate = scanner.nextLine();

        System.out.println("Enter book number of book copies for each book");
        int numberOfCopiesPerBook = scanner.nextInt();

        System.out.println(bookService.getCountOfAddedBooks(releaseDate, numberOfCopiesPerBook));
    }


    private void printBookInfoByGivenTitle() { //TASK 11
        String title = scanner.nextLine();
        System.out.println(bookService.getByTitle(title));
    }

    private void printTotalBooksCopies() { //TASK 10
        authorService.getAllByCountOfBooksCopies()
                .forEach(System.out::println);
    }

    private void printBookTitleWhereLongerThan() { // TASK 9
        System.out.println("Enter title minimum size");
        int longerThan = scanner.nextInt();
        System.out.println(bookService.getCountOfBookWhereTitleLongerThan(longerThan));
    }

    private void printBookTitleAndAuthorWithLastNameStartWith() { //TASK 8
        System.out.println("Enter last name start string");
        String startWith = scanner.nextLine();
        bookService.getBookTitleAndAuthorWithLastNameStartWith(startWith)
                .forEach(System.out::println);
    }

    private void printBookTitleContainsString() {
        System.out.println("Enter substring");
        String substring = scanner.nextLine();
        bookService.getAllTitlesContainsString(substring)
                .forEach(System.out::println);
    }

    private void printAuthorsWithFirstNameEndsWithGivenString() { // TASK 6
        String ends = scanner.nextLine();
        authorService.getAuthorWithFirstNameEndsWithString(ends)
                .forEach(System.out::println);
    }

    private void printBooksReleasedBeforeGivenDate() { // TASK 5
        System.out.println("Enter date[dd-mm-yyyy]");
        String date = scanner.nextLine();
        bookService.getBooksReleasedBeforeDate(date)
                .forEach(System.out::println);
    }

    private void printTitleOfBookWithReleaseYearDifferentOfGiven() { //Task 4
        System.out.println("Enter year[yyyy]");
        int year =Integer.parseInt(scanner.nextLine());
        bookService.getAllBooksWithDifferentYear(year)
                .forEach(System.out::println);
    }

    private void printBookTitleWithPriceOutOfRange() { //TASK 3
        bookService.getBookTitleAndPriceOutOfRange()
                .forEach(System.out::println);
    }

    private void printTitleOfGoldenBook() { // TASK 2
        bookService.getAllGoldenBookTitle()
                .forEach(System.out::println);
    }

    private void printBookTitleByAgeRestriction() { //TASK 1
        System.out.println("Enter age restriction");
        String ageRestriction = scanner.nextLine();
        bookService.getBookTitleByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {

        categoryService.seedCategory();
        authorService.seedAuthors();
        bookService.seedBook();
    }
}
