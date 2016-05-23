package com.github.jmetzz.demo;

/**
 * Created by Jean Metz.
 */

import com.github.jmetzz.demo.model.Flashcard;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named
@Stateless
public class FlashcardEJB {

    @Inject
    private EntityManager em;


    public Flashcard createFlashcard(Flashcard card) {
        em.persist(card);
        return card;
    }

    public List<Flashcard> findAllCards() {
        return em.createNamedQuery("findAllCards", Flashcard.class).getResultList();
    }

    public Flashcard findCardById(Long id) {
        return em.find(Flashcard.class, id);
    }

}
