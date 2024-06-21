package com.epam.qavn.api.stepDefinitions;

import com.epam.qavn.api.core.GlobalConstant;
import com.epam.qavn.api.models.book.*;
import com.epam.qavn.api.models.user.CreateUserResponse;
import com.epam.qavn.api.models.ErrorResponse;
import com.epam.qavn.api.services.BookService;
import com.epam.qavn.api.utils.JsonLoader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;

import java.util.Collections;

public class BookStep {
    private Response listOfBooks;
    private Response addBookResponse;
    private ScenarioContext scenarioContext;
    private BookService bookService = new BookService();

    public BookStep(ScenarioContext context) {
        this.scenarioContext = context;

    }


    @When("^I get list of books$")
    public void getListOfBooks() {
        this.listOfBooks = bookService.getBooks();
    }

    @Then("^I verify get list of book successfully$")
    public void verifyGetListOfBookSuccessfully() {
        Assert.assertEquals(HttpStatus.SC_OK, this.listOfBooks .statusCode());
        Assert.assertEquals(this.listOfBooks.contentType(), GlobalConstant.CONTENT_TYPE);

        ListOfBooksResponse listOfBooksResponse = this.listOfBooks.body().as(ListOfBooksResponse.class);
        String filePath = "src/test/resources/testdata/Book.json";
       Book bookExpected = new JsonLoader().readJsonFile(filePath, Book.class);
       Book bookActual = listOfBooksResponse.getBooks().get(0);
        Assert.assertTrue(bookActual.equals(bookExpected));

        scenarioContext.setContext("ListOfBook", listOfBooksResponse);
    }

    @When("I add a book to a collection")
    public void addABookToACollection() {
        String userId = ((CreateUserResponse) scenarioContext.getContext("UserResponse")).getUserID();
        String firstIsbn = ((ListOfBooksResponse)scenarioContext.getContext("ListOfBook")).getBooks().get(0).getIsbn();
        CollectionOfIsbn collectionOfIsbn = new CollectionOfIsbn(firstIsbn);
        AddBooksRequest addBooksRequest = new AddBooksRequest(userId, Collections.singletonList(collectionOfIsbn));
        String token = (String) scenarioContext.getContext("Token") ;
        token = token == null ? "" : token;
        this.addBookResponse = bookService.addBookToCollection(addBooksRequest, token);

        scenarioContext.setContext("AddBookRequest", addBooksRequest);
    }

    @Then("I verify add book to a collection successfully")
    public void verifyAddBookToACollectionSuccessfully() {
        Assert.assertEquals(HttpStatus.SC_OK, this.listOfBooks .statusCode());
        Assert.assertEquals(this.listOfBooks.contentType(), GlobalConstant.CONTENT_TYPE);
        String firstIsBnExpected = ((AddBooksRequest)scenarioContext.getContext("AddBookRequest")).getCollectionOfIsbns().get(0).getIsbn();
        String firstIsBnActual= this.addBookResponse.body().as(AddBookResponse.class).getBooks().get(0).getIsbn();
        Assert.assertEquals(firstIsBnActual, firstIsBnExpected);
    }

    @Then("I verify error user not authorized display")
    public void iVerifyErrorUserNotAuthorizedDisplay() {
        Assert.assertEquals(HttpStatus.SC_OK, this.listOfBooks .statusCode());
        Assert.assertEquals(this.listOfBooks.contentType(), GlobalConstant.CONTENT_TYPE);

        String filePath = "src/test/resources/testdata/UserNotAuthorized.json";
        ErrorResponse userNotAuthorizedExpected = new JsonLoader().readJsonFile(filePath, ErrorResponse.class);
        ErrorResponse userNotAuthorizedActual = this.addBookResponse.body().as(ErrorResponse.class);
        Assert.assertTrue(userNotAuthorizedExpected.equals(userNotAuthorizedActual));
    }
}
