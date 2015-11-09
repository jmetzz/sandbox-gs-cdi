package com.github.jmetzz.cdi.service.generators;


import com.github.jmetzz.cdi.service.annotations.EightDigits;
import com.github.jmetzz.cdi.service.annotations.Loggable;

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
        return issn;
    }

}