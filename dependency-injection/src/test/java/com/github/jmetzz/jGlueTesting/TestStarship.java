package com.github.jmetzz.jGlueTesting;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by Jean Metz.
 */
@RunWith(CdiRunner.class)
public class TestStarship {

    @Inject
    Starship starship;

    @Test
    public void testStart() {
        starship.start(); // Going to warp!
    }
}
