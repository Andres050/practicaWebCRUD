package com.example.practicawebcrud.Dades;

import com.example.practicawebcrud.Domini.Product;

import javax.servlet.jsp.JspWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Business {
    private final ProductDAO productDAO = new ProductDAO();

    public void listProduct(PrintWriter printWriter){
        List<Product> productList = productDAO.readAll();
        printWriter.println("<div style='text-align:center'>");
        for (int i = 0; i < productList.size(); i++) {
            printWriter.println(Arrays.toString(new Object[]{productList.get(i).getIdPro(), productList.get(i).getNamePro(), productList.get(i).getDescriptPro(), productList.get(i).getPricePro()}));
            printWriter.println("<br><hr><br>");
        }
        printWriter.println("</div>");
    }
    public void insert(Product product) {
        productDAO.insert(product);
    }
    public void restartCataleg() {
        productDAO.deleteAllINFOonTABLE();
    }
    public void searchProduct(String name,PrintWriter printWriter){
        Product product1 = productDAO.readByName(name);
        if (product1!=null) {
            printWriter.println("<h1 style='text-align:center'>PRODUCT</h1>");
            printWriter.println(Arrays.toString(new Object[]{product1.getIdPro(), product1.getNamePro(), product1.getDescriptPro(), product1.getPricePro()}));
        } else {
            printWriter.println("<p>Product dont finded!!!</p>");
        }
    }
    public void updateProduct(int id, PrintWriter printWriter, Product product){
        if (Objects.equals(product.getNamePro(), "Vacio") && product.getIdPro() == 0) {
            printWriter.println("DONT EXIST updateProduct");
        } else {
            printWriter.println(Arrays.toString(new Object[]{product.getIdPro(), product.getNamePro(), product.getDescriptPro(), product.getPricePro()}));
            printWriter.println("Product going to be DELETED....");
        }
        if (product.getNamePro() != null || product.getDescriptPro() != null) {
            productDAO.updateByID(product, id);
        } else {
            printWriter.println("Product doesnt defined!!!");
        }
    }

    public void deleteByID (int id, PrintWriter printWriter){
        printWriter.println(productDAO.readByID(id));
        printWriter.println(id);
        productDAO.deleteByID(id);
    }
}
