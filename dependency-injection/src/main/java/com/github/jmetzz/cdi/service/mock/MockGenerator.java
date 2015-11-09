package com.github.jmetzz.cdi.service.mock;


import com.github.jmetzz.cdi.service.annotations.Loggable;
import com.github.jmetzz.cdi.service.annotations.ThirteenDigits;
import com.github.jmetzz.cdi.service.generators.NumberGenerator;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Jean Metz on 12-Oct-15.
 */


/* FIXME Jean Metz
- move this class to test package
- use some framework to test cdi, such as Arquillian
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
