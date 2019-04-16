package com.softserve.servlets;

import com.softserve.controllers.AuthorService;
import com.softserve.controllers.impl.AuthorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/author")
public class AuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthorService authorService = new AuthorServiceImpl();
        request.setAttribute("authors", authorService.retrieveAllAuthors());
        request.getRequestDispatcher("author.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AuthorService authorService = new AuthorServiceImpl();
        Integer id = Integer.valueOf(request.getParameter("ID"));
        authorService.deleteAuthorById(id);
        response.sendRedirect("/author");
    }
}
