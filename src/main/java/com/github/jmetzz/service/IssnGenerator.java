package com.github.jmetzz.service;


import com.github.jmetzz.service.annotations.EightDigits;
import com.github.jmetzz.service.annotations.Loggable;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Jean Metz on 12-Oct-15.
 */
@EightDigits
public class IssnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {

        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Generated ISSN: " + issn);
        return issn;
    }

}
