package com.github.jmetzz.flashcard.core.cards.service;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Jean Metz.
 */
public class DBProducer {

    @Produces
    @PersistenceContext(unitName = "jsfLabPU")
    private EntityManager em;
}
