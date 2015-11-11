package com.github.jmetzz.beanValidation.service;

import com.github.jmetzz.beanValidation.pojo.Person;
import org.joda.time.DateTime;

/**
 * Created by Jean Metz on 11-Nov-15.
 */
public class PersonService {

    public PersonService() {
    }

    public Person createPerson(String name, String mname, String fname, String ss, DateTime bd) {
        return new PersonBuilder()
                .withFirstName("Thais")
                .withMidleName("Rachel")
                .withFamilyName("Lucca")
                .withBirthDate(new DateTime().withDate(1971, 10, 18))
                .withSsNumber("123456789012345").build();
    }


    public Person createPerson(String name, String fname, String ss, DateTime bd) {
        return createPerson(name, "", fname, ss, bd);
    }
}
