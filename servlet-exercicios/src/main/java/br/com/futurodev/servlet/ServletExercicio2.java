package br.com.futurodev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletExercicio2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        writer.println("<h2>Insira login e senha para autenticacao:<h2/>");

        if (login.equals("admin")) {

        }if (senha.equals("password")){
            writer.println("<h2>Bem vindo,<h2/>"+login);
        } else {
            writer.println("<h2>Login ou senha invalidos<h2/>");
        }
    }
}
