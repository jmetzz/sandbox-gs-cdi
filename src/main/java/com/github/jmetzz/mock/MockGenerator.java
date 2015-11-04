package com.github.jmetzz.mock;


import com.github.jmetzz.service.NumberGenerator;
import com.github.jmetzz.service.annotations.Loggable;
import com.github.jmetzz.service.annotations.ThirteenDigits;

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
        logger.info("Created MOCK : " + mock);
        return mock;
    }
}
