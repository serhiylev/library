package com.softserve.entity;

import java.sql.Date;
import java.util.Objects;

public class Order {

    private Integer id;
    private Reader reader;
    private Book book;
    private Date date_of_issuance;
    private Date date_of_return;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_of_issuance() {
        return date_of_issuance;
    }

    public void setDate_of_issuance(Date date_of_issuance) {
        this.date_of_issuance = date_of_issuance;
    }

    public Date getDate_of_return() {
        return date_of_return;
    }

    public void setDate_of_return(Date date_of_return) {
        this.date_of_return = date_of_return;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                reader.equals(order.reader) &&
                book.equals(order.book) &&
                date_of_issuance.equals(order.date_of_issuance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reader, book, date_of_issuance);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reader=" + reader +
                ", book=" + book +
                ", date_of_issuance=" + date_of_issuance +
                ", date_of_return=" + date_of_return +
                '}';
    }
}
