package com.github.jmetzz.beanValidation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jean Metz on 16-Nov-15.
 */

@ReportAsSingleViolation
@Constraint(validatedBy = {ZipCodeValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
public @interface ZipCode {
    String message() default "{com.github.jmetzz.beanValidation.constraints.ZipCode.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    /*
     To be able to have the same constraint multiple times on the same target,
     the constraint annotation needs to define an array of itself.
     The inner interface must have the retention RUNTIME
     and must use the same set of targets as the initial constraint
    */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @interface List {
        ZipCode[] value();
    }

}
