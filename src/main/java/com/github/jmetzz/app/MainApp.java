package com.github.jmetzz.app;

import com.github.jmetzz.pojo.Book;
import com.github.jmetzz.service.BookService;
import com.github.jmetzz.service.interceptors.LoggingInterceptor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


/**
 * Created by Jean Metz on 15-Oct-15.
 */
public class MainApp {

    public static void main(String[] args) {

        System.out.println(" Started ... ");

        Weld weld = new Weld()
                .enableDiscovery()
                //.packages(MainApp.class)
                .interceptors(LoggingInterceptor.class)
                .property("org.jboss.weld.construction.relaxed", true)
                ;

        try (WeldContainer container = weld.initialize()) {
            BookService service = container.select(BookService.class).get();
            Book book = service.createBook("Weld CDI", 50.0, "Context and dependency injection with WELD");
            System.out.println(book);
        }


    }


}
