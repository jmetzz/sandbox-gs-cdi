package com.github.jmetzz.beanValidation;

import com.github.jmetzz.beanValidation.pojo.Person;
import com.github.jmetzz.beanValidation.service.PersonBuilder;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jean Metz on 11-Nov-15.
 */
public class ValidationProgramaticallyTest {

    private static ValidatorFactory factory;
    private static Validator validator;


    @BeforeClass
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterClass
    public static void teardown() {
        factory.close();
    }

    @Test
    public void validateComplete() {

        Person person = new PersonBuilder()
                .withFirstName("Isaac")
                .withMidleName("the Tongue")
                .withFamilyName("Newton")
                .withBirthDate(new DateTime().withDate(1971, 10, 18))
                .withSsNumber("123456789012345").createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertThat(violations.size()).isEqualTo(0);
    }


    @Test
    public void validateNotComplete() {
        Person person = new PersonBuilder()
                .withFirstName("Isaac")
                .withMidleName("the Tongue")
                .withBirthDate(new DateTime().withDate(1971, 10, 18))
                .withSsNumber("123456789012345").createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertThat(violations.size()).isEqualTo(1);

        System.out.println(violations);
    }

}