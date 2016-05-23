package com.github.jmetzz.demo;

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
