package com.github.jmetzz.flashcard.core.cards.service;

import com.github.jmetzz.flashcard.FlashcardEngineEJB;
import com.github.jmetzz.flashcard.core.cards.model.Flashcard;
import com.github.jmetzz.flashcard.core.cards.model.Language;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;


/**
 * Created by Jean Metz.
 */

@Singleton
@Startup
@DataSourceDefinition(name = "java:global/jdbc/jsfLabDS",
        className = "org.apache.derby.jdbc.EmbeddedDriver",
        url = "jdbc:derby:memory:jsfLabDB;create=true;user=app;password=app"

)
public class DataLoader {

    private static Logger logger = Logger.getLogger(DataLoader.class.getName());
    @Inject
    private FlashcardEngineEJB flashcardEJB;

    @PostConstruct
    private void createDummyData() {
        flashcardEJB.createFlashcard(new Flashcard("Zeroth", Language.ENGLISH, "being numbered zero in a series"));
        flashcardEJB.createFlashcard(new Flashcard("Dally", Language.ENGLISH, "to act playfully"));
        flashcardEJB.createFlashcard(new Flashcard("ramshackle", Language.ENGLISH, "appearing ready to collapse; carelessly or loosely constructed"));

        logger.info("Inserted " + flashcardEJB.findAllCards().size() + " Cards");
    }

}
