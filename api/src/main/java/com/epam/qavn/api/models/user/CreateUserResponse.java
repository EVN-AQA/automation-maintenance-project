package com.epam.qavn.api.models.user;

import com.epam.qavn.api.models.book.Book;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class CreateUserResponse {

    private String userID;
    private String username;
    private List<Book> books;

    public CreateUserResponse() {
    }

    public CreateUserResponse(String userID, String username, List<Book> books) {
        super();
        this.userID = userID;
        this.username = username;
        this.books = books;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}