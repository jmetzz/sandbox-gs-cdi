package com.github.jmetzz.jpaPersistence.basicMapping.pojo;


import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Jean Metz
 */

@NamedQueries({
        @NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b"),
        @NamedQuery(name = "findMyBook", query = "SELECT b FROM Book b WHERE b.title ='My Book'")
})
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    /*  bean Validation defines constraints only within the java space. So @NotNull reads as a piece
        of java code that checks that an attribute’s value is not null. On the other hand, the jpa @Column(nullable = false) is used
        in the database space to generate the database schema. both jpa and bean Validation annotations can coexist on an attribute.
        */
    @NotNull
    @Column(name = "book_title", nullable = false, updatable = true)
    private String title;

    private Double price;

    @Column(length = 2000)
    private String description;

    private String isbn;

    @Column(name = "NBOFPAGE")
    private Integer numberOfPages;

    @Version
    private Integer version;


    public Book() {
    }

    public Book(String title, String description, Double price, String number, Integer numberOfPages) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.isbn = number;
        this.numberOfPages = numberOfPages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Id", id)
                .add("Title", title)
                .add("Price", price)
                .add("Description", description)
                .add("ISSN", isbn)
                .add("Number of pages", numberOfPages)
                .omitNullValues()
                .toString();
    }


}
