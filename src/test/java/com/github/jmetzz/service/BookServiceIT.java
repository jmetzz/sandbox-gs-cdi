package com.github.jmetzz.service;

import com.github.jmetzz.pojo.Book;
import com.github.jmetzz.service.interceptors.LoggingInterceptor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Jean Metz on 15-Oct-15.
 */
public class BookServiceIT {

    @Test
    public void shouldCheckNumberIsMock() {

        Weld builder = new Weld()
                .enableDiscovery()
//                .packages(MainApp.class)
                .interceptors(LoggingInterceptor.class)
                .addAlternative(com.github.jmetzz.service.MockGenerator.class)
                .property("org.jboss.weld.construction.relaxed", true);

        try (WeldContainer weld = builder.initialize()) {
            BookService service = weld.select(BookService.class).get();
            Book book = service.createBook("Mock title", 10.0, "Mock Book");
            System.out.println(book);

            assertTrue(book.getNumber().startsWith("MOCK"));
        }

    }

}
