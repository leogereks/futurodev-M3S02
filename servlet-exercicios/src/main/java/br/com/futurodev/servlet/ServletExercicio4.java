package br.com.futurodev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletExercicio4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form_post.html").forward(req,resp);
    }

    //    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    }
}
