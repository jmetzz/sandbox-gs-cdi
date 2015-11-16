package com.github.jmetzz.beanValidation;

import com.github.jmetzz.beanValidation.pojo.Person;
import com.github.jmetzz.beanValidation.service.PersonBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jean Metz on 11-Nov-15.
 */
public class ValidationFromContainerTest {

    /*
    Either way (with @Resource or @Inject) the container looks after the life cycle of the factory
    */
    @Inject
    ValidatorFactory validatorFactory;

    @Inject
    Validator validator;

    @Test
    public void validate() {
        Person person = new PersonBuilder()
                .withFirstName("Isaac")
                .withMidleName("the Tongue")
                .withFamilyName("Newton")
                .withBirthDate(new DateTime().withDate(1971, 10, 18))
                .withSsNumber("123456789012345").createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertThat(violations.size()).isEqualTo(0);

    }


}