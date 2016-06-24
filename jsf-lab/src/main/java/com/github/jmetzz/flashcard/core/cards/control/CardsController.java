package com.github.jmetzz.flashcard.core.cards.control;


import com.github.jmetzz.flashcard.FlashcardEngineEJB;
import com.github.jmetzz.flashcard.core.cards.model.Flashcard;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Created by Jean Metz.
 */
@Named
@RequestScoped
public class CardsController {

    private static Logger logger = Logger.getLogger(CardsController.class.getName());

    @Inject
    private FlashcardEngineEJB flashcardEJB;
    private Flashcard card = new Flashcard();


    public String doCreateFlashcard() {
        flashcardEJB.createFlashcard(card);
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Flashcard created",
                        "The Flashbard for word " + card.getWord() + " has been created with id=" + card.getId()));

        logger.info("Flashcard created: " + card);

        return "newFlashcard.xhtml";
    }

    public void doFindCardById() {
        logger.info("Card Id to fetch: " + card.getId());
        card = flashcardEJB.findCardById(card.getId());
        logger.info("Flashcard fetched: " + card);
    }

    public Flashcard getCard() {
        return card;
    }


    public void setCard(Flashcard card) {
        this.card = card;
    }
}
