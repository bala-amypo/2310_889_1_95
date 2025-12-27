package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello-servlet")
public class SimpleHelloServlet extends HttpServlet {

    // Must be public to allow the TestNG suite to call it directly
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.setStatus(200);
        resp.getWriter().write("Hello from Simple Servlet");
    }

    // Must be public for the test suite
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
    }

    // Must be public to satisfy the test case calling .service()
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "SimpleHelloServlet";
    }
}