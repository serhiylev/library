package com.softserve.entity;

import com.softserve.addition.NewDate;

import java.sql.Date;
import java.util.Objects;

public class Order {

    private Integer id;
    private Reader reader;
    private Book book;
    private Date date_of_issuance;
    private Date date_of_return;



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
