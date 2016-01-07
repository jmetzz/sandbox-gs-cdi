package com.github.jmetzz.beanValidation;

import com.github.jmetzz.beanValidation.constraints.Email;
import com.github.jmetzz.beanValidation.constraints.ExactSize;
import com.github.jmetzz.beanValidation.constraints.URL;
import com.github.jmetzz.beanValidation.constraints.ZipCode;
import com.github.jmetzz.beanValidation.pojo.Address;
import com.github.jmetzz.beanValidation.pojo.Person;
import com.github.jmetzz.beanValidation.service.PersonBuilder;
import org.joda.time.DateTime;
import org.junit.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by Jean Metz on 11-Nov-15.
 */
public class ValidationProgramaticallyTest {

    private static ValidatorFactory factory;
    private static Validator validator;
    private Person person;

    @BeforeClass
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterClass
    public static void teardown() {
        factory.close();
    }

    @Before
    public void setup() {
        person = new PersonBuilder()
                .withFirstName("Isaac")
                .withMidleName("TONGE")
                .withFamilyName("Newton")
                .withSsNumber("123456789012345")
                .withEmail("the-tongue@newton.me")
                .withBirthDate(new DateTime().withDate(1642, 12, 25))
                .withPhoneNumber("34567984874")
                .withWebSite("http://www.thetonge.newtow.me")
                .createPerson();
    }

    @Test
    public void shouldValidate() {
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertEquals(0, violations.size());

        for (Address address : person.getAddresses()) {
            Set<ConstraintViolation<Address>> addressViolations = validator.validate(address);
            assertEquals(0, violations.size());
        }

    }

    // --- Validates Size annotation
    @Test
    public void shouldFailBecauseFirstNameTooShort() {
        Person p = new PersonBuilder()
                .from(person)
                .withFirstName("I")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertEquals(1, violations.size());
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(Size.class);
    }

    @Test
    public void shouldFailBecauseFirstNameTooLong() {
        Person p = new PersonBuilder()
                .from(person)
                .withFirstName("NewtonNewtonNewtonNewtonNewtonNewtonNewtonNewtonNewtonNewton")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);
        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(Size.class);

    }

    @Test
    public void shouldFailBecauseFamilyNameTooShort() {
        Person p = new PersonBuilder()
                .from(person)
                .withFamilyName("T")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(Size.class);
    }

    @Test
    public void shouldFailBecauseFamilyNameTooLong() {
        Person p = new PersonBuilder()
                .from(person)
                .withFamilyName("NewtonNewtonNewtonNewtonNewtonNewtonNewtonNewtonNewtonNewton")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(Size.class);
    }

    @Test
    public void shouldFailBecauseMiddleNameTooLong() {
        Person p = new PersonBuilder()
                .from(person)
                .withMidleName("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(Size.class);
    }


    // --- Validates NotNull annotation
    @Test
    public void shouldFailBecauseFirstNameNull() {
        Person p = new PersonBuilder()
                .from(person)
                .withFirstName(null)
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(NotNull.class);
    }


    @Test
    public void shouldFailBecauseFamilyNameNull() {
        Person p = new PersonBuilder()
                .from(person)
                .withFirstName(null)
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(NotNull.class);
    }

    @Test
    public void shouldFailBecauseBirthDateNull() {
        Person p = new PersonBuilder()
                .from(person)
                .withBirthDate(null)
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(NotNull.class);
    }

    // --- Validates Past annotation
    @Test
    public void shouldFailBecauseBirthDateIsFuture() {
        Person p = new PersonBuilder()
                .from(person)
                .withBirthDate(new DateTime().withDate(2642, 12, 25))
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(Past.class);
    }

    // --- Validates ExactSize annotation
    @Test
    public void shouldFailBecauseSsNumberWrongSize() {
        Person p = new PersonBuilder()
                .from(person)
                .withSsNumber("12345678")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(ExactSize.class);
    }

    // --- Validates Email annotation
    @Test
    public void shouldFailBecauseInvalidEmail() {

        Person p = new PersonBuilder()
                .from(person)
                .withEmail("wrong-email-address")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);

        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(Email.class);
        assertThat(violation.getMessage()).isEqualTo("Invalid email format");
        assertThat(violation.getInvalidValue()).isEqualTo("wrong-email-address");
    }

    // --- Validates URL annotation

    @Test
    public void shouldFailBecauseInvalidURL() {
        Person p = new PersonBuilder()
                .from(person)
                .withWebSite("www.thetonge.newtow.me")
                .createPerson();

        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Person> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(URL.class);
    }


    @Test
    @Ignore
    /** FIXME
     * This test is marked as Ignore due to failure in
     * injecting the ZipCodeChecker into ZipCodeValidator,
     * which attempts to validates the zip code according
     * to specific formation rules, not only a simple
     * expression that checks whether the given code
     * is only made of numbers, for example.
     */
    public void shouldFailBecauseInvalidZipCode() {

        Address address = new Address("233 Spring Street", "box 1", "New York", "NY", "12345", "USA");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertThat(violations).isEmpty();

        address.setZipCode("DummyZip");
        violations = validator.validate(address);
        System.out.println(violations);

        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<Address> violation = violations.iterator().next();
        assertThat(violation.getConstraintDescriptor().getAnnotation()).isInstanceOf(ZipCode.class);
    }


}