package com.epam.qavn.api.models.book;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CollectionOfIsbn {

    private String isbn;

    public CollectionOfIsbn() {
    }

    public CollectionOfIsbn(String isbn) {
        super();
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
