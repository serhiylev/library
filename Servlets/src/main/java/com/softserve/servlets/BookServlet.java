package com.softserve.servlets;

import com.softserve.controllers.BookController;
import com.softserve.controllers.impl.BookControllerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookController bookController = new BookControllerImpl();
        request.setAttribute("Books",bookController.retrieveAllBooks());
        request.getRequestDispatcher("WEB-INF/jsp/book.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
