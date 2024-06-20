package com.epam.qavn.api.models.book;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class AddBooksRequest {

    private String userId;
    private List<CollectionOfIsbn> collectionOfIsbns;

    public AddBooksRequest() {
    }

    public AddBooksRequest(String userId, List<CollectionOfIsbn> collectionOfIsbns) {
        super();
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CollectionOfIsbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<CollectionOfIsbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

}