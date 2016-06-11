package com.github.jmetzz.flashcard;

import com.github.jmetzz.flashcard.model.Flashcard;
import com.github.jmetzz.flashcard.model.Language;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

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

    @Inject
    private FlashcardEJB flashcardEJB;

    private Logger logger = Logger.getLogger(DataLoader.class.getName());

    @PostConstruct
    private void createDummyData() {
        flashcardEJB.createFlashcard(new Flashcard("Zeroth", Language.ENGLISH, "being numbered zero in a series"));
        flashcardEJB.createFlashcard(new Flashcard("Dally", Language.ENGLISH, "to act playfully"));
        flashcardEJB.createFlashcard(new Flashcard("ramshackle", Language.ENGLISH, "appearing ready to collapse; carelessly or loosely constructed"));

        logger.info("Inserted " + flashcardEJB.findAllCards().size() + " Cards");
    }

}
