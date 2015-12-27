package com.github.jmetzz.jpaPersistence.associations;

import com.github.jmetzz.beanValidation.constraints.ZipCode;
import com.google.common.base.MoreObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Jean Metz on 16-Nov-15.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String street;

    private String complement;

    @NotNull
    private String city;

    private String state;

    @NotNull
    @ZipCode
    private String zipCode;

    @NotNull
    private String country;

    public Address(String street1, String complement, String city, String state, String zipCode, String country) {
        this.street = street1;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complemento) {
        this.complement = complemento;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Street", street)
                .add("Complement", complement)
                .add("City", city)
                .add("State", state)
                .add("ZipCode", zipCode)
                .add("Country", country)
                .omitNullValues()
                .toString();
    }
}
