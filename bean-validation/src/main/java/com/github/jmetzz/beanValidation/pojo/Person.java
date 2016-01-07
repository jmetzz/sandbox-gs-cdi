package com.github.jmetzz.beanValidation.pojo;


import com.github.jmetzz.beanValidation.constraints.Email;
import com.github.jmetzz.beanValidation.constraints.ExactSize;
import com.github.jmetzz.beanValidation.constraints.URL;
import com.google.common.base.MoreObjects;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jean Metz on 09-Nov-15.
 */
public class Person {

    @NotNull
    @Size(min = 2, max = 30)
    private final String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private final String familyName;

    @Size(max = 100)
    private final String middleName;

    @NotNull
    @Past
    private final DateTime birthDate;

    @NotNull
    //@Size(min = 15, max = 15)
    @ExactSize(value = 15)
    private final String ssNumber;

    private final String phoneNumber;

    @Email
    private final String email;

    @URL
    private final String website;

    private final List<Address> addresses;


    public Person(String firstName, String familyName, String midleName, DateTime birthDate, String ssNumber, String phoneNumber, String email, String website) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.middleName = midleName;
        this.birthDate = birthDate;
        this.ssNumber = ssNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        addresses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSsNumber() {
        return ssNumber;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public void addAddress(@NotNull Address address) {
        this.addresses.add(address);
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("First name", firstName)
                .add("Midle name", middleName)
                .add("Family name", familyName)
                .add("Birth date", birthDate.toString("YYYY-MM-dd"))
                .add("SS Number", ssNumber)
                .add("Phone Number", phoneNumber)
                .add("Email", email)
                .add("Site", website)
                .omitNullValues()
                .toString();
    }
}
