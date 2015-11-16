package com.github.jmetzz.beanValidation.constraints;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jean Metz on 16-Nov-15.
 */


@Qualifier
@Target({FIELD, TYPE, METHOD})
@Retention(RUNTIME)
@Documented
public @interface USA {

}
