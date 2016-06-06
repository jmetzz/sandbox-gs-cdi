package com.github.jmetzz.flashcard;


import com.github.jmetzz.flashcard.model.Flashcard;

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

        return "newFlashcard.xhtml";
    }

    public void doFindCardById() {
        card = flashcardEJB.findCardById(card.getId());
    }

    public Flashcard getCard() {
        return card;
    }


    public void setCard(Flashcard card) {
        this.card = card;
    }
}
