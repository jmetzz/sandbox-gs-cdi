package com.github.jmetzz.beanValidation;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * Created by Jean Metz.
 * <p>
 * This is an attempt to run JUnit with CDI
 * NOT WORKING YET
 */
public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {

    private final Class<?> klass;
    private final Weld weld;
    private final WeldContainer container;

    public WeldJUnit4Runner(Class<Object> klass) throws InitializationError {
        super(klass);
        this.klass = klass;

        weld = new Weld();
        container = weld.initialize();
    }

    @Override
    protected Object createTest() throws Exception {
        final Object test = container.instance().select(klass).get();

        return test;
    }
}
