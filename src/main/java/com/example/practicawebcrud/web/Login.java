package com.example.practicawebcrud.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = ""; String password = "";
        user = request.getParameter("user");
        password = request.getParameter("password");

        if (user.equals("andres") && password.equals("12345")) {
            request.setAttribute("user",user);
            request.setAttribute("password",password);
            request.getRequestDispatcher("Catalogo.jsp").forward(request,response);
        } else {
            request.setAttribute("mis","Usuario selecionado incorrecto");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
