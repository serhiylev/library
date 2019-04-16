package com.softserve.servlets;

import com.softserve.controllers.AuthorService;
import com.softserve.controllers.impl.AuthorServiceImpl;
import com.softserve.entity.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create_author")
public class AuthorCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author author = new Author();
        author.setFirstName(request.getParameter("FIRSTNAME"));
        author.setLastName(request.getParameter("LASTNAME"));
        author.setAge(Integer.valueOf(request.getParameter("AGE")));
        AuthorService authorService = new AuthorServiceImpl();
        authorService.createAuthor(author);
        response.sendRedirect(request.getContextPath() + "/author");
    }
}
