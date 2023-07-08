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
