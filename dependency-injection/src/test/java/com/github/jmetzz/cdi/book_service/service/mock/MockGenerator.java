package com.github.jmetzz.cdi.book_service.service.mock;


import com.github.jmetzz.cdi.book_service.service.annotations.Loggable;
import com.github.jmetzz.cdi.book_service.service.annotations.ThirteenDigits;
import com.github.jmetzz.cdi.book_service.service.generators.NumberGenerator;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Jean Metz on 12-Oct-15.
 */


@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        return mock;
    }
}
