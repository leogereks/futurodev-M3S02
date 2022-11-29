package br.com.futurodev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Tratamento ex 4", urlPatterns = "/tratamentopost.do")

public class ServletExercicio4Tratamento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<h1>Média das notas</h1>");

        String nome = req.getParameter("nome");
        String nomeDisciplina = req.getParameter("nomeDisciplina");
        double nota1 = Double.parseDouble(req.getParameter("nota1"));
        double nota2 = Double.parseDouble(req.getParameter("nota2"));
        double nota3 = Double.parseDouble(req.getParameter("nota3"));
        double nota4 = Double.parseDouble(req.getParameter("nota4"));
        double soma = nota1 + nota2 + nota3 + nota4;

        writer.println("Olá " + nome + " suas notas sao respectivamente: " + nota1 + "-" + nota2 + "-" + nota3 + "-" + nota4);

        double media = soma / 4;
        writer.println("Sendo assim, sua média na disciplina " + nomeDisciplina + " é " + media);

        if (media > 7) {
            writer.println("e voce está APROVADO");
        } else if (media >= 6 || media <= 6.9) {
            writer.println("e voce está em RECUPERACAO");
        } else {
            writer.println("e voce está REPROVADO");
        }
    }
}
