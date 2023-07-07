package com.BookshopSystem;

import com.BookshopSystem.services.intefaces.AuthorService;
import com.BookshopSystem.services.intefaces.BookService;
import com.BookshopSystem.services.intefaces.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private AuthorService authorService;
    private BookService bookService;
    private CategoryService categoryService;

    public ConsoleRunner(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();

        //Before start place set your user and password in application.properties

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are we going to test the task?[YES/NO]");
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("NO")) {

            System.out.println("Enter the number of task[1-4]");
            input = scanner.nextLine();

            switch (input) {
                case "1" -> taskOne();
                case "2" -> taskTwo();
                case "3" -> taskThree();
                case "4" ->  taskFour();
            }

            System.out.println("Other task?[YES/NO]");
            input = scanner.nextLine();
        }
        System.out.println("Have a nice day!");

    }

    private void seedData() throws IOException {

        categoryService.seedCategory();
        authorService.seedAuthors();
        bookService.seedBook();
    }

    private void taskOne() {
        bookService.getAllBookAfterYear(LocalDate.of(2000, 12, 31))
                .forEach(b -> bookService.printBookTitle(b));
    }

    private void taskTwo() {
        bookService.getAllBookBeforeYear(1990)
                .forEach(System.out::println);
    }

    private void taskThree() {
        authorService.getAllOrderByBookCount().forEach(System.out::println);
    }

    private void taskFour() {
        bookService.getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell")
                .forEach(System.out::println);
    }
}
