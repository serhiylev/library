package com.softserve.servlets;

import com.softserve.controllers.ReaderService;
import com.softserve.controllers.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reader")
public class ReaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReaderService readerService = new ReaderServiceImpl();
        request.setAttribute("readers", readerService.retrieveAllReaders());
        request.getRequestDispatcher("reader.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReaderService readerService = new ReaderServiceImpl();
        Integer id = Integer.valueOf(request.getParameter("id"));
        readerService.deleteReaderById(id);
        response.sendRedirect("/reader");
    }
}
