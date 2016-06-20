package jms_lab.demo.pojo;

import java.io.Serializable;

/**
 * Created by Jean Metz.
 */
public class CreditCard implements Serializable {
    private String number;

    private String expiryDate;

    private Integer controlNumber;

    private CreditCardType creditCardType;

    public CreditCard() {
    }

    public CreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType creditCardType) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.controlNumber = controlNumber;
        this.creditCardType = creditCardType;
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

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("number", number)
                .add("expiryDate", expiryDate)
                .add("controlNumber", controlNumber)
                .add("creditCardType", creditCardType)
                .toString();
    }
}
