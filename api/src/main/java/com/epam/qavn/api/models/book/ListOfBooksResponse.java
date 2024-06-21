package com.epam.qavn.api.models.book;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class ListOfBooksResponse {

    private List<Book> books;

    public ListOfBooksResponse() {
    }

    public ListOfBooksResponse(List<Book> books) {
        super();
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
