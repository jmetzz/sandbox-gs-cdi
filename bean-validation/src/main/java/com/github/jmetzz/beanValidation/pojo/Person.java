package com.github.jmetzz.beanValidation.pojo;


import com.github.jmetzz.beanValidation.constraints.ExactSize;
import com.google.common.base.MoreObjects;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Jean Metz on 09-Nov-15.
 */
public class Person {

    @NotNull
    @Size(max = 30)
    private final String firstName;

    @NotNull
    @Size(max = 30)
    private final String familyName;

    @Size(max = 255)
    private final String midleName;

    @NotNull
    private final DateTime birthDate;

    @NotNull
    //@Size(min = 15, max = 15)
    @ExactSize(value = 15)
    private final String ssNumber;

    public Person(String firstName, String familyName, String midleName, DateTime birthDate, String ssNumber) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.midleName = midleName;
        this.birthDate = birthDate;
        this.ssNumber = ssNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getMidleName() {
        return midleName;
    }

    public String getSsNumber() {
        return ssNumber;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("First name", firstName)
                .add("Midle name", midleName)
                .add("Family name", familyName)
                .add("SS Number", ssNumber)
                .add("Birth date", birthDate.toString("YYYY-MM-dd"))
                .omitNullValues()
                .toString();
    }
}
