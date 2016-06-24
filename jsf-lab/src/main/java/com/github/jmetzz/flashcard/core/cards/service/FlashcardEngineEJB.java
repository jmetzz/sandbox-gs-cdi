package com.github.jmetzz.flashcard;

/**
 * Created by Jean Metz.
 */


import com.github.jmetzz.flashcard.core.cards.model.Flashcard;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named
@Stateless
public class FlashcardEngineEJB {

    private static Logger logger = Logger.getLogger(FlashcardEngineEJB.class.getName());

    @Inject
    private EntityManager em;


    public Flashcard createFlashcard(Flashcard card) {
        em.persist(card);
        return card;
    }

    public List<Flashcard> findAllCards() {
        logger.info("EJB - findAllCards");
        return em.createNamedQuery("findAllCards", Flashcard.class).getResultList();
    }

    public Flashcard findCardById(Long id) {
        logger.info("EJB - findCardById");
        return em.find(Flashcard.class, id);
    }

}
