package com.epam.qavn.api.services;

import com.epam.qavn.api.core.Route;
import com.epam.qavn.api.core.helpers.RestResource;
import com.epam.qavn.api.models.book.AddBooksRequest;
import io.restassured.response.Response;

public class BookService {
    public Response getBooks() {
        return RestResource.get(Route.getBooks(), "");
    }
    public Response addBookToCollection(AddBooksRequest addBooksRequest, String token){
        return RestResource.post(Route.addBookToCollection(), token, addBooksRequest);
    }
}
