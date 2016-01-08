package com.github.jmetzz.beanValidation;

import com.github.jmetzz.beanValidation.pojo.Address;
import com.github.jmetzz.beanValidation.pojo.Person;
import com.github.jmetzz.beanValidation.service.PersonBuilder;
import org.jglue.cdiunit.CdiRunner;
import org.joda.time.DateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jean Metz on 11-Nov-15.
 */
@RunWith(CdiRunner.class)
public class ValidationWithJGlue {

    /*
     * Either way (with @Resource or @Inject) the container
     * or the testing framework in use
     * looks after the life cycle of this object
    */
    @Inject
    Validator validator;

    @Test
    @Ignore
    /*
     * FIXME
     * dependency injection not working properly,
     * since CdiRunner is not able to launch Weld
     * due to
     *      DeploymentException: WELD-001408:
     *      Unsatisfied dependencies for type Validator with qualifiers @Default
     *      at injection point [UnbackedAnnotatedField]
     *      @Inject com.github.jmetzz.beanValidation.ValidationWithJGlue.validator
     */
    public void validate() {
        Person person = new PersonBuilder()
                .withFirstName("Isaac")
                .withMidleName("TONGE")
                .withFamilyName("Newton")
                .withSsNumber("123456789012345")
                .withEmail("the-tongue@newton.me")
                .withBirthDate(new DateTime().withDate(1642, 12, 25))
                .withPhoneNumber("34567984874")
                .withWebSite("http://www.thetonge.newtow.me")
                .createPerson();

        Address address = new Address("233 Spring Street", "box 1", "New York", "NY", "12345", "USA");
        person.addAddress(address);

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        assertThat(violations.size()).isEqualTo(0);
    }


}