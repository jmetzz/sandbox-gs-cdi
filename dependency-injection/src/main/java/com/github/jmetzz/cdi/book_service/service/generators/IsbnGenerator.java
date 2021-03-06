package com.github.jmetzz.cdi.book_service.service.generators;


import com.github.jmetzz.cdi.book_service.service.annotations.Loggable;
import com.github.jmetzz.cdi.book_service.service.annotations.Rand;
import com.github.jmetzz.cdi.book_service.service.annotations.ThirteenDigits;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by Jean Metz on 12-Oct-15.
 */

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Inject
    @ThirteenDigits
    private String prefix;

    @Inject
    @ThirteenDigits
    private int editorNumber;

    @Inject
    @Rand
    private double postfix;

    @Loggable
    public String generateNumber() {
        String isbn = prefix + editorNumber + postfix;
        return isbn;
    }
}
