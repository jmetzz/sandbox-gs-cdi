package com.github.jmetzz.jpaPersistence.basicMapping.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by Jean Metz.
 */
@Entity
public class News {

    @EmbeddedId
    private NewsIdEmbeddable id;

    private String content;

    public News() {
    }

    public NewsIdEmbeddable getId() {
        return id;
    }

    public void setId(NewsIdEmbeddable id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
