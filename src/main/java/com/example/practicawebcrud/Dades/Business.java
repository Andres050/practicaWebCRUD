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
    public List<Product> list(){
        return productDAO.readAll();
    }
    public void insert(Product product) {
        productDAO.insert(product);
    }
    public void restartCataleg() {
        productDAO.deleteAllINFOonTABLE();
    }
    public Product searchProduct(String name){
        Product product1 = productDAO.readByName(name);
        if (product1!=null) {
            return new Product(product1.getIdPro(), product1.getNamePro(), product1.getDescriptPro(), product1.getPricePro());
        } else {
            return new Product();
        }
    }
    public Product updateProduct(int id, Product product){
        if (product.getNamePro() != null || product.getDescriptPro() != null) {
            productDAO.updateByID(product, id);
            return new Product(product.getIdPro(), product.getNamePro(), product.getDescriptPro(), product.getPricePro());
        } else {
            return new Product();
        }
    }

    public Product deleteByID (int id){
        productDAO.deleteByID(id);
        return productDAO.readByID(id);
    }
}
