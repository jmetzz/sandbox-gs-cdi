package com.github.jmetzz.cdi.book_service.service.producers;


import com.github.jmetzz.cdi.book_service.service.annotations.Rand;
import com.github.jmetzz.cdi.book_service.service.annotations.ThirteenDigits;

import javax.enterprise.inject.Produces;
import java.util.Random;

/**
 * Created by Jean Metz on 12-Oct-15.
 */
public class NumberProducer {
    @Produces
    @ThirteenDigits
    private String prefix13digits = "13-";

    @Produces
    @ThirteenDigits
    private int editorNumber = 84356;

    @Produces
    @Rand
    public double random() {
        return Math.abs(new Random().nextInt());
    }

}
