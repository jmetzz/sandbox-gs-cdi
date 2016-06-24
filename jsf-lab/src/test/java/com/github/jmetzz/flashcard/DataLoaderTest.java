package com.github.jmetzz.flashcard;

import org.junit.Ignore;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Jean Metz.
 */
public class DataLoaderTest {

    @Test @Ignore
    public void testDataSourceDefinition() {

        Map properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {

            Context ctx = ec.getContext();
            // Check JNDI dependencies (Datasource)
            try {

                /*The server provides a JNDI name for all deployed beans.
                check the naming conventions at : http://docs.oracle.com/cd/E19798-01/821-1841/girgn/index.html
                */

                assertNotNull(ctx.lookup("java:global/classes/FlashcardEJB"));
                assertNotNull(ctx.lookup("java:global/jdbc/jsfLabDS"));
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
    }
}