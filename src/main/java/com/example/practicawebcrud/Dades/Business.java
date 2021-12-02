package com.example.practicawebcrud.Dades;

import com.example.practicawebcrud.Domini.Product;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/* Esta clase se encarga de coger los metodos de ProductDAO y realiza algunas operaciones con esa informacion para despues cada .jsp pueda usarlo */
public class Business {

    /* Creo un objeto productDAO para poder llamar a los metodos creados en la misma classe */
    private final ProductDAO productDAO = new ProductDAO();

    /* Este metodo lo que hace es coger la lista de productDAO y la imprime cada una de ellas */
    /* No me sirve por ahora en este ejercicio porque no necesito que me lo imprima, sino quiero solo la informacion para depues darle forma en el html */
    public void listProduct(PrintWriter printWriter){
        List<Product> productList = productDAO.readAll();
        printWriter.println("<div style='text-align:center'>");
        for (int i = 0; i < productList.size(); i++) {
            printWriter.println(Arrays.toString(new Object[]{productList.get(i).getIdPro(), productList.get(i).getNamePro(), productList.get(i).getDescriptPro(), productList.get(i).getPricePro()}));
            printWriter.println("<br><hr><br>");
        }
        printWriter.println("</div>");
    }

    /* Esta clase es la que remplaza a listProduct() ya que para este ejercicio quiero que me pase la informacion tal qual para poder hacer un for en el .jsp y mostrarlo como deseo*/
    public List<Product> list(){
        return productDAO.readAll();
    }

    /* Solo llama a un metodo para insertar el producto, no necesita nada mas que insertarlo */
    public void insert(Product product) {
        productDAO.insert(product);
    }

    /* Solo llama a un metodo para deleteAllINFOonTABLE() el producto, para eliminar la llista de la bbdd */
    public void restartCataleg() {
        productDAO.deleteAllINFOonTABLE();
    }

    /* Este metodo lo que hace es mirar por el nombre insertado por parametro pasarlo a un buscador en productDAO el qual necesita
    tambien ese nombre, ya realizado eso necesitaremos guardar el producto que a encontrado, con este producto miro si ha encontrado o no y lo devulvo */
    public Product searchProductName(String name){
        Product product1 = productDAO.readByName(name);
        if (product1!=null) {
            return new Product(product1.getIdPro(), product1.getNamePro(), product1.getDescriptPro(), product1.getPricePro());
        } else {
            return new Product();
        }
    }
    public Product searchProductID(int id){
        Product product1 = productDAO.readByID(id);
        if (product1!=null) {
            return product1;
        } else {
            return new Product();
        }
    }

    /* Este metodo hace un update del producto enviado por parametro, este update se realiza en la id selecionada tambien por parametro */
    public Product updateProduct(int id, Product product){
        if (product.getNamePro() != null || product.getDescriptPro() != null) {
            productDAO.updateByID(product, id);
            return new Product(product.getIdPro(), product.getNamePro(), product.getDescriptPro(), product.getPricePro());
        } else {
            return new Product();
        }
    }

    /* Este metodo necesita solo la id donde quieres eliminar el producto, la qual la elimina y me envia el producto eliminado por si lo necesito decir (ESTE ES EL PRODUCTO ELIMINADO )*/
    public Product deleteByID (int id){
        Product product = productDAO.readByID(id);
        productDAO.deleteByID(id);
        return product;
    }
}
