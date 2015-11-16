package com.github.jmetzz.beanValidation.service;

import com.github.jmetzz.beanValidation.pojo.Person;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jean Metz on 16-Nov-15.
 */
public class PersonServiceTest {
    private static ValidatorFactory vf;

    private static Validator validator;

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void close() {
        vf.close();
    }

    @Test
    public void shouldRaiseNoConstraintViolation() {

        Person person = new PersonBuilder()
                .withFirstName("Isaac")
                .withFamilyName("Newton")
                .withSsNumber("123456789012345")
                .withEmail("the-tongue@newton.me")
                .withBirthDate(new DateTime().withDate(1642, 12, 25))
                .withPhoneNumber("34567984874")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertEquals(0, violations.size());


    }

    @Test
    public void shouldRaiseConstraintViolationCauseInvalidEmail() {

        Person person = new PersonBuilder()
                .withFirstName("Isaac")
                .withFamilyName("Newton")
                .withSsNumber("123456789012345")
                .withEmail("wrong-email-address")
                .withBirthDate(new DateTime().withDate(1642, 12, 25))
                .withPhoneNumber("34567984874")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertEquals(1, violations.size());
        assertEquals("Email address not valid", violations.iterator().next().getMessage());
        assertEquals("wrong-email-address", violations.iterator().next().getInvalidValue());
        assertEquals("{com.github.jmetzz.beanValidation.constraints.Email.message}",
                violations.iterator().next().getMessageTemplate());
    }
}