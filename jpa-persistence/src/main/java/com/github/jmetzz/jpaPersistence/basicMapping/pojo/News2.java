package com.github.jmetzz.jpaPersistence.basicMapping.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Jean Metz.
 */
@Entity
@IdClass(NewsIdClassId.class)
public class News2 {

    @Id
    private String title;

    @Id
    private String language;

    private String content;

    public News2() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
