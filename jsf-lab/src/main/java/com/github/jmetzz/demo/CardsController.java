package com.github.jmetzz.demo;


import com.github.jmetzz.demo.model.Flashcard;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Jean Metz.
 */
@Named
@RequestScoped
public class CardsController {

    @Inject
    private FlashcardEJB flashcardEJB;
    private Flashcard card = new Flashcard();
}
