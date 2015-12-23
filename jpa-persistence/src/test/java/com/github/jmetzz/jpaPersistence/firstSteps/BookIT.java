package com.github.jmetzz.jpaPersistence.firstSteps;

import com.github.jmetzz.jpaPersistence.firstSteps.pojo.Book;
import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jean Metz.
 */
public class BookIT {

    Logger logger = Logger.getLogger(BookIT.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleJPAExampleUnitTests");

    EntityManager em;

    EntityTransaction tx;


    @Before
    public void initEntityManager() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void tearDown() {
        if (em != null) {
            em.close();
        }
    }

    @Test
    public void shouldFindJavaEE7Book() throws Exception {
        Book book = em.find(Book.class, 1001L);
        assertThat("Beginning Java EE 7").isEqualTo(book.getTitle());

        logger.info("Find result: " + book);
    }

    @Test
    public void shouldCreateMyBook() throws Exception {
        Book book = new Book("My Book", "My Book description", 12.5, "1-84023-742-2", 354);

        logger.info("Book instance created: " + book);

        tx.begin();
        em.persist(book);
        tx.commit();
        assertThat(book.getId()).isNotNull();

        logger.info("Book instance persisted: " + book);
    }

    @Test
    public void shouldRetrieveAllBooks() {
        List<Book> books = em.createNamedQuery("findAllBooks", Book.class).getResultList();
        assertThat(books.size()).isEqualTo(4);
        logger.info("Find all books: " + books);
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle() {
        Book book = new Book(null, "Null title, should fail", 12.5, "1-84023-742-2", 354);
        logger.info("Book with null title created. Should fail this test with ConstraintViolationException");

        em.persist(book);
    }


}
