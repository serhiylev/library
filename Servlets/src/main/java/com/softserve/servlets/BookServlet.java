package com.softserve.servlets;

import com.softserve.controllers.BookService;
import com.softserve.controllers.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/book")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookService bookController = new BookServiceImpl();
        request.setAttribute("books",bookController.retrieveAllBooks());
        request.getRequestDispatcher("book.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        Integer id = Integer.valueOf(request.getParameter("id"));
        bookService.deleteBookById(id);
        response.sendRedirect("/book");
    }
}
