package com.github.jmetzz.beanValidation.pojo;

import com.google.common.base.MoreObjects;

/**
 * Created by Jean Metz.
 */
public class Dummy {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}
