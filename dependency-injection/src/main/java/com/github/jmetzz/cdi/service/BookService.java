package com.github.jmetzz.cdi.service;


import com.github.jmetzz.cdi.pojo.Book;
import com.github.jmetzz.cdi.service.annotations.Loggable;
import com.github.jmetzz.cdi.service.annotations.ThirteenDigits;
import com.github.jmetzz.cdi.service.generators.NumberGenerator;

import javax.inject.Inject;

/**
 * Created by Jean Metz on 12-Oct-15.
 */

@Loggable //binds the interceptor to this bean
public class BookService {


    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    public BookService() {
    }

    public Book createBook(String title, Double price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
