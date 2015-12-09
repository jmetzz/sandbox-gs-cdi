package com.github.jmetzz.jpaPersistence;

import com.github.jmetzz.jpaPersistence.pojo.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Jean Metz.
 */
public class MainApp {

    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("My Book");
        book.setDescription("A small description of My Book");
        book.setIsbn("1-84023-742-2");
        book.setNumberOfPages(300);
        book.setPrice(50.0);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleJPAExample");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();

        book = em.createNamedQuery("FindA", Book.class).getSingleResult();

        em.close();
        emf.close();

    }
}
