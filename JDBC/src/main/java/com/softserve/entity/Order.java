package com.softserve.entity;

import java.sql.Date;
import java.util.Objects;

public class Order {

    private Integer id;
    private Integer id_reader;
    private Integer id_book;
    private Date date_of_issuance;
    private Date date_of_return;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_reader() {
        return id_reader;
    }

    public void setId_reader(Integer id_reader) {
        this.id_reader = id_reader;
    }

    public Integer getId_book() {
        return id_book;
    }

    public void setId_book(Integer id_book) {
        this.id_book = id_book;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                id_reader.equals(order.id_reader) &&
                id_book.equals(order.id_book) &&
                date_of_issuance.equals(order.date_of_issuance) &&
                Objects.equals(date_of_return, order.date_of_return);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_reader, id_book);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", id_reader=" + id_reader +
                ", id_book=" + id_book +
                ", date_of_issuance=" + date_of_issuance +
                ", date_of_return=" + date_of_return +
                '}';
    }
}
