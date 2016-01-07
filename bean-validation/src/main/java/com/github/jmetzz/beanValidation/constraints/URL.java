package com.github.jmetzz.beanValidation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jean Metz on 11-Nov-15.
 */

@Constraint(validatedBy = {URLValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface URL {

    String message() default "{com.github.jmetzz.beanValidation.constraints.URL.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String protocol() default "";

    String host() default "";

    int port() default -1;
}