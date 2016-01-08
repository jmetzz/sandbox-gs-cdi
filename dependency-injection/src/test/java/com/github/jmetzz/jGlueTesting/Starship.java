package com.github.jmetzz.jGlueTesting;

import javax.inject.Inject;

/**
 * Created by Jean Metz.
 */
public class Starship {
    @Inject
    WarpDrive engine;

    void start() {
        engine.start();
    }
}
