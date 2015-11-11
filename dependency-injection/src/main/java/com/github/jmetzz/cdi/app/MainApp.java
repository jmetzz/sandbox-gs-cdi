package com.github.jmetzz.cdi.app;

import com.github.jmetzz.cdi.pojo.Book;
import com.github.jmetzz.cdi.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


/**
 * Created by Jean Metz on 15-Oct-15.
 */
public class MainApp {

    public static void main(String[] args) {

        Weld weld = new Weld();

        try (WeldContainer container = weld.initialize()) {
            BookService service = container.select(BookService.class).get();
            Book book = service.createBook("Weld CDI", 50.0, "Context and dependency injection with WELD");
            System.out.println(book);
        }

    }


}
