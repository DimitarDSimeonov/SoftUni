package com.BookshopSystem.services.intefaces;

import java.io.IOException;
import java.util.List;

public interface BookService {

    void seedBook() throws IOException;

    List<String> getBookTitleByAgeRestriction(String ageRestriction);
}
