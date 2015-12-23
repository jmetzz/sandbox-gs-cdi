package com.github.jmetzz.jpaPersistence.basicMapping.pojo;

import javax.persistence.*;

/**
 * Created by Jean Metz.
 */
@Entity
@Table(name = "CREDIT_CARD ")
public class CreditCard {
    @Id
    private String number;

    private String expiryDate;

    private Integer controlNumber;

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    public CreditCard() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }
}
