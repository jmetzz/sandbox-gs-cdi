package com.github.jmetzz.beanValidation;

import com.github.jmetzz.beanValidation.pojo.Dummy;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * Created by Jean Metz.
 * <p>
 * JUnit with CDI using jGlue
 */
@RunWith(CdiRunner.class)
public class TestingIoC {

    @Inject
    private Dummy dummy;


    @Test
    public void validateInjection() {

        assertThat(dummy).isNotNull();
        dummy.setName("Isaac Newton");
        System.out.println(dummy);
    }

}
