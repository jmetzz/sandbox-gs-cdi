package com.github.jmetzz;

import com.github.jmetzz.cdi.book_service.pojo.Book;
import com.github.jmetzz.cdi.book_service.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import javax.enterprise.inject.Alternative;
import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jean Metz on 15-Oct-15.
 */
public class BookServiceTest {

    @Test
    public void shouldCheckNumberIsMock() {

        Weld builder = new Weld();
        /*
        * Apparently there is a bug in Weld implementation
        * that prevents it to load the beans.xml file from
        * test/resources/META-INF.
        * It always loads the main/resources/META-INF/beans.xml
        * instead.
        *
        * */

        try (WeldContainer weld = builder.initialize()) {
            BookService service = weld.select(BookService.class).get();
            Book book = service.createBook("Mock title", 10.0, "Mock Book");
            System.out.println(book);
            assertThat(book).isNotNull();
            assertThat(book.getNumber()).startsWith("MOCK");
        }
    }
}
