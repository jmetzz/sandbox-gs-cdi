package com.github.jmetzz.cdi.pojo;

/**
 * Created by Jean Metz on 12-Oct-15.
 */
public class Book {

    private String title;
    private Double price;
    private String description;
    private String number;

    public Book() {
    }


    public Book(String title, Double price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }


}
