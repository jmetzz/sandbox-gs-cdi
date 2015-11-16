package com.github.jmetzz.beanValidation.service;

import com.github.jmetzz.beanValidation.pojo.Person;
import org.joda.time.DateTime;

public class PersonBuilder {
    private String firstName;
    private String familyName;
    private String midleName;
    private DateTime birthDate;
    private String phoneNumber;
    private String ssNumber;
    private String email;
    private String website;

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public PersonBuilder withMidleName(String midleName) {
        this.midleName = midleName;
        return this;
    }

    public PersonBuilder withBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PersonBuilder withSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
        return this;
    }

    public PersonBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PersonBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder withWebSite(String website) {
        this.website = website;
        return this;
    }

    public Person createPerson() {
        return new Person(firstName, familyName, midleName, birthDate, ssNumber, phoneNumber, email, website);
    }
}