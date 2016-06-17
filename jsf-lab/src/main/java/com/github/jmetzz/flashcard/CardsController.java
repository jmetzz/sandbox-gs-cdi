package com.github.jmetzz.flashcard;


import com.github.jmetzz.flashcard.model.Flashcard;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.log4j.Logger;


/**
 * Created by Jean Metz.
 */
@Named
@RequestScoped
public class CardsController {

    private static Logger logger = Logger.getLogger(CardsController.class.getName());

    @Inject
    private FlashcardEJB flashcardEJB;
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
