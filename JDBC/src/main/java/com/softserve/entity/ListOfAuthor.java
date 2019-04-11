package com.softserve.entity;

public class ListOfAuthor {

    private Integer id;
    private Integer id_author;
    private Integer book_id;
    private Integer main_author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_author() {
        return id_author;
    }

    public void setId_author(Integer id_author) {
        this.id_author = id_author;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getMain_author() {
        return main_author;
    }

    public void setMain_author(Integer main_author) {
        this.main_author = main_author;
    }

    @Override
    public String toString() {
        return "ListOfAuthor{" +
                "id=" + id +
                ", id_author=" + id_author +
                ", book_id=" + book_id +
                ", main_author=" + main_author +
                '}';
    }
}
