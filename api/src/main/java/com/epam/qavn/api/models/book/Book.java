package com.epam.qavn.api.models.book;
import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isbn",
        "title",
        "subTitle",
        "author",
        "publish_date",
        "publisher",
        "pages",
        "description",
        "website"
})
@Generated("jsonschema2pojo")
public class Book {

    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String publishDate;
    private String publisher;
    private Integer pages;
    private String description;
    private String website;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book bookResponse = (Book) obj;
        return  (isbn == bookResponse.isbn || (isbn != null && isbn.equals(bookResponse.isbn)))&&
                (title == bookResponse.title || (title != null && title.equals(bookResponse.title)))&&
                (subTitle == bookResponse.subTitle || (subTitle != null && subTitle.equals(bookResponse.subTitle)))&&
                (author == bookResponse.author || (author != null && author.equals(bookResponse.author)))&&
                (publishDate == bookResponse.publishDate || (publishDate != null && publishDate.equals(bookResponse.publishDate)))&&
                (publisher == bookResponse.publisher || (publisher != null && publisher.equals(bookResponse.publisher)))&&
                (pages == bookResponse.pages || (pages != null && pages.equals(bookResponse.pages)))&&
                (description == bookResponse.description || (description != null && description.equals(bookResponse.description)))&&
                (website == bookResponse.website || (website != null && website.equals(bookResponse.website)));
    }
}