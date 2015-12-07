package com.github.jmetzz.jpaPersistence;

import com.github.jmetzz.jpaPersistence.pojo.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jean Metz.
 */
public class BookIT {

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
    }

    @Test
    public void shouldCreateH2G2Book() throws Exception {

        // Creates an instance of book
        Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5, "1-84023-742-2", 354);

        // Persists the book to the database
        tx.begin();
        em.persist(book);
        tx.commit();
        assertThat(book.getId()).isNotNull();

        // Retrieves all the books from the database
        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        assertThat(book.getDescription()).isEqualTo("The Hitchhiker's Guide to the Galaxy");
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle() {

        Book book = new Book(null, "Null title, should fail", 12.5, "1-84023-742-2", 354);
        em.persist(book);
    }


}
