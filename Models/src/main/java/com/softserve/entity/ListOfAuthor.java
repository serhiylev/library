package com.softserve.entity;

public class ListOfAuthor {

    private Integer id;
    private Author author;
    private Book book;
    private Integer main_author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getMain_author() {
        return main_author;
    }

    public void setMain_author(Integer main_author) {
        this.main_author = main_author;
    }


}
