package com.github.jmetzz.beanValidation.constraints;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jean Metz on 16-Nov-15.
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {


    @USA
    @Inject
    private ZipCodeChecker checker;

    private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

    @Override
    public void initialize(ZipCode annotation) {
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {

        if (code == null)
            return true;

        // first step check -> regular expression based
        Matcher m = zipPattern.matcher(code);
        if (!m.matches())
            return false;

        // second step check -> business logic validation
        return checker.isZipCodeValid(code);
    }
}
