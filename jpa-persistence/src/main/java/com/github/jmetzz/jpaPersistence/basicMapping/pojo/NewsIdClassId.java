package com.github.jmetzz.jpaPersistence.basicMapping.pojo;

import java.util.Objects;

/**
 * Created by Jean Metz.
 */

public class NewsIdClassId {

    private String title;

    private String language;

    public NewsIdClassId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsIdClassId newsId = (NewsIdClassId) o;
        return Objects.equals(title, newsId.title) &&
                Objects.equals(language, newsId.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, language);
    }
}
