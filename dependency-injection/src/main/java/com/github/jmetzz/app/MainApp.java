package com.github.jmetzz.app;

import com.github.jmetzz.pojo.Book;
import com.github.jmetzz.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


/**
 * Created by Jean Metz on 15-Oct-15.
 */
public class MainApp {

    public static void main(String[] args) {

        System.out.println(" Main App Started ... ");

        Weld weld = new Weld();

        try (WeldContainer container = weld.initialize()) {
            BookService service = container.select(BookService.class).get();
            Book book = service.createBook("Weld CDI", 50.0, "Context and dependency injection with WELD");
            System.out.println(book);
        }
        System.out.println("===== END =======");

    }


}
