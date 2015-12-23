package com.github.jmetzz.jpaPersistence.basicMapping.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jean Metz.
 */
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    /* Because age can be automatically calculated from the date of birth,
     the age attribute does not need to be mapped and therefore can be transient.
     As a result, the age attribute doesn’t need any AGE column to be mapped to.
     */
    @Transient
    private Integer age;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
