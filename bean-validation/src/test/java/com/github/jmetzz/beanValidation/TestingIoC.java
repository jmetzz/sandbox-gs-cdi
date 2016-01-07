package com.github.jmetzz.beanValidation;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.awt.print.Book;

/**
 * Created by Jean Metz.
 * <p>
 * <p>
 * This is an attempt to run JUnit with CDI
 * NOT WORKING YET
 */
@Ignore
//@RunWith(WeldJUnit4Runner.class)
@RunWith(CdiRunner.class)
public class TestingIoC {

    @Inject
    private Book book;

    @Test
    public void isNull() {
        System.out.println(book == null);
    }

}
