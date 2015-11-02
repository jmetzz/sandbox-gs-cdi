package com.github.jmetzz.service;


import com.github.jmetzz.pojo.Book;
import com.github.jmetzz.service.annotations.Loggable;
import com.github.jmetzz.service.annotations.ThirteenDigits;

import javax.inject.Inject;

/**
 * Created by Jean Metz on 12-Oct-15.
 */

@Loggable
public class BookService {


    public BookService() {
    }

    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Double price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
