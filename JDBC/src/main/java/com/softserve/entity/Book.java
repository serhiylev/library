package com.softserve.entity;

import java.io.Serializable;

import java.sql.Date;
import java.util.Objects;

public class Book implements Serializable {

    private Integer id;
    private String name;
    private Date releaseDate;
    private boolean available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) &&
                name.equals(book.name) &&
                releaseDate.equals(book.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", available=" + available +
                '}';
    }
}
