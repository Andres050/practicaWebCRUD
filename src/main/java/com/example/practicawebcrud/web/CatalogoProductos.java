package com.example.practicawebcrud.web;

import com.example.practicawebcrud.Dades.Business;
import com.example.practicawebcrud.Dades.ProductDAO;
import com.example.practicawebcrud.Domini.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "CatalogoProductos", value = "/CatalogoProductos")
public class CatalogoProductos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Business business = new Business();
        HttpSession misession = request.getSession(true);
        String user = (String) misession.getAttribute("user");

        /* Si no me existe el user no aparece nada y te llega a registrarte */
        if (user!=null) {
            String action = request.getParameter("action");
            request.setAttribute("message", action);
            String id = request.getParameter("id");
            request.setAttribute("singleProduct", id);

            switch (action) {
                case "edit":
                    request.setAttribute("id", id);
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
                    break;
                case "delete":
                    business.deleteByID(Integer.parseInt(id));
                    break;
                case "add":
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("addProduct.jsp").forward(request, response);
                    break;
                case "view":
                    request.setAttribute("viewProduct", business.searchProductID(Integer.parseInt(id)));
                    request.setAttribute("action", action);
                    request.getRequestDispatcher("view.jsp").forward(request,response);
                    break;
                case "removeAll":
                    business.restartCataleg();
                    break;
            }

            request.getRequestDispatcher("Catalogo.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Business business = new Business();
        HttpSession misession = request.getSession(true);
        String user = (String) misession.getAttribute("user");

        if (user != null) {
            //ADD PRODUCT
            String idPro = null;
            String name = null;
            String descript = null;
            String price = null;
            String action = null;

            try {
                idPro = request.getParameter("idPro");
                name = request.getParameter("namePro");
                descript = request.getParameter("descriptPro");
                price = request.getParameter("pricePro");
                action = (String) request.getAttribute("action");
            } catch (Exception ignored) {

            }
            assert action != null;
            assert price != null;
            boolean is = true;
            Product product = new Product(0, "NULL PRODUCT", "THIS IS A NULL PRODUCT", 0);
            if (idPro != null) {
                ProductDAO productDAO = new ProductDAO();
                productDAO.updateByID(new Product(name, descript, Double.parseDouble(price)), Integer.parseInt(idPro));
            } else {
                business.insert(new Product(name, descript, Double.parseDouble(price)));
            }
            request.setAttribute("message", product);
            request.setAttribute("llista", business.list());
            request.getRequestDispatcher("Catalogo.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
