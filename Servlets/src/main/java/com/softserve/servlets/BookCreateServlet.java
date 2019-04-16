package com.softserve.servlets;

import com.softserve.controllers.BookService;
import com.softserve.controllers.impl.BookServiceImpl;
import com.softserve.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/book-create")
public class BookCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        book.setName(request.getParameter("name"));
        book.setReleaseDate(Date.valueOf(request.getParameter("release_date")));
        book.setAvailable(true);
        BookService bookService = new BookServiceImpl();
        bookService.createBook(book);
        response.sendRedirect(request.getContextPath() +"/book");
    }
}
