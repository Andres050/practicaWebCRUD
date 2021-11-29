package com.example.practicawebcrud.web;

import com.example.practicawebcrud.Dades.Business;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "";
        Business business = new Business();
        HttpSession misession = request.getSession(true);
        user = request.getParameter("user");

        if (user!=null) {
            misession.setAttribute("user",user);
            request.setAttribute("llista",business.list());
            request.getRequestDispatcher("Catalogo.jsp").forward(request,response);
        } else {
            request.setAttribute("mis","Usuario selecionado incorrecto");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
