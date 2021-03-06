package com.softserve.entity;

import java.sql.Date;
import java.util.Objects;

public class Order {

    private Integer id;
    private Reader reader;
    private Book book;
    private Date dateOfIssuance;
    private Date dateOfReturn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDateOfIssuance() {
        return dateOfIssuance;
    }

    public void setDateOfIssuance(Date dateOfIssuance) {
        this.dateOfIssuance = dateOfIssuance;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                reader.equals(order.reader) &&
                book.equals(order.book) &&
                dateOfIssuance.equals(order.dateOfIssuance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reader, book, dateOfIssuance);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reader=" + reader +
                ", book=" + book +
                ", dateOfIssuance=" + dateOfIssuance +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}
