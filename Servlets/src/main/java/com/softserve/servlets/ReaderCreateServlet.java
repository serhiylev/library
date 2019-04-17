package com.softserve.servlets;

import com.softserve.controllers.ReaderService;
import com.softserve.controllers.impl.ReaderServiceImpl;
import com.softserve.entity.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-reader")
public class ReaderCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Reader reader = new Reader();
        reader.setFirstName(request.getParameter("FirstName"));
        reader.setLastName(request.getParameter("LastName"));
        reader.setAge(Integer.valueOf(request.getParameter("age")));
        ReaderService readerService = new ReaderServiceImpl();
        readerService.createReader(reader);
        response.sendRedirect(request.getContextPath() + "/reader");
    }
}
