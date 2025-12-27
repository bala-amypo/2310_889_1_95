package com.example.demo.servlet;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/hello-servlet")
public class SimpleHelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.setContentType("text/plain");
        resp.getWriter().write("Hello from Simple Servlet");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(200);
    }
    @Override
    public String getServletInfo() { return "SimpleHelloServlet"; }
}