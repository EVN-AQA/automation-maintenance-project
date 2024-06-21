package com.epam.qavn.api.models.book;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class AddBookResponse {
    private List<CollectionOfIsbn> books;

    public AddBookResponse() {
    }

    public AddBookResponse(List<CollectionOfIsbn> books) {
        super();
        this.books = books;
    }

    public List<CollectionOfIsbn> getBooks() {
        return books;
    }

    public void setBooks(List<CollectionOfIsbn> books) {
        this.books = books;
    }

}



