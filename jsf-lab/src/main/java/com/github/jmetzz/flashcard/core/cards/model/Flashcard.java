package com.github.jmetzz.flashcard.core.cards.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Jean Metz.
 */

@Entity
@NamedQuery(name = "findAllCards", query = "SELECT f FROM Flashcard f ORDER BY f.word DESC")
public class Flashcard {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String word;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(length = 2000)
    @NotNull
    private String description;


    public Flashcard() {

    }

    public Flashcard(String word, Language language, String description) {
        this.word = word;
        this.language = language;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("word", word)
                .add("language", language)
                .add("description", description)
                .toString();
    }
}
