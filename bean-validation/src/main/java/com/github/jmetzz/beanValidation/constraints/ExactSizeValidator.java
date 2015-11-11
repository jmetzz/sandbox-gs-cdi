package com.github.jmetzz.beanValidation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Created by Jean Metz on 11-Nov-15.
 */
public class ExactSizeValidator implements ConstraintValidator<ExactSize, CharSequence> {
    int size;

    @Override
    public void initialize(ExactSize annotation) {
        this.size = annotation.value();
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        /*
        The Bean Validation specification recommends as good practice to consider null as valid.
        This way you do not duplicate the code of the @NotNull constraint.
         */
        if (charSequence == null)
            return true;

        return charSequence.length() == size;
    }

}
