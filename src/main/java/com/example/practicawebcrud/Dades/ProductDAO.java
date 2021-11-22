package com.example.practicawebcrud.Dades;

import com.example.practicawebcrud.Domini.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // ESCUELA

    String login = "andres5";
    String password = "andres12345A_";
    String database = "andres_database";
    String table = "productos";

    // CASA ANDRES
    /*
    String login = "admins";
    String password = "andres12345A_";
    String table = "productos";
     */

    String url = "jdbc:mysql://localhost:3306/"+database+"?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection connection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, login, password);
    }

    public void insert(Product product) {
        Connection conn = null;

        try {
            conn = connection();

            if (conn != null) {
                String insertString = "INSERT INTO "+table+" (namePro,descriptPro,pricePro)"+" VALUES (?,?,?)";
                PreparedStatement insertProduct = conn.prepareStatement(insertString);
                insertProduct.setString(1, product.getNamePro());
                insertProduct.setString(2,product.getDescriptPro());
                insertProduct.setDouble(3, product.getPricePro());
                insertProduct.executeQuery();
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Product> readAll(){
        Connection conn = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = connection();

            if (conn != null) {
                Statement sta = conn.createStatement();
                ResultSet result = sta.executeQuery("SELECT * FROM "+table);
                while(result.next()){
                    Product product = new Product(result.getInt("idPro"),result.getString("namePro"), result.getString("descriptPro"), result.getDouble("pricePro"));
                    products.add(product);
                }
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }

        return products;
    }

    public Product readByID(int id){
        Connection connection = null;

        try {
            connection = connection();

            if (connection != null) {
                Statement sta = connection.createStatement();
                ResultSet result = sta.executeQuery("SELECT * FROM "+table+" where idPro=\""+id+"\"");
                result.next();
                Product product = new Product(result.getInt("idPro"), result.getString("namePro"), result.getString("descriptPro"), result.getDouble("pricePro"));
                connection.close();
                return product;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return new Product("Vacio");
    }
    public Product readByName(String name){
        Connection connection = null;

        try {
            connection = connection();

            if (connection != null) {
                Statement sta = connection.createStatement();
                ResultSet result = sta.executeQuery("SELECT * FROM "+table+" where namePro=\""+name+"\"");
                result.next();
                Product product = new Product(result.getInt("idPro"), result.getString("namePro"), result.getString("descriptPro"), result.getDouble("pricePro"));
                connection.close();
                return product;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return new Product("Vacio");
    }
    public void updateByID(Product product, int id){
        Connection conn = null;

        try {
            conn = connection();

            if (conn != null) {
                String updateString = "update "+table+" set namePro = ? , descriptPro = ? , pricePro = ? where idPro= '"+id+"'";
                PreparedStatement updateProduct = conn.prepareStatement(updateString);
                updateProduct.setString(1, product.getNamePro());
                updateProduct.setString(2,product.getDescriptPro());
                updateProduct.setDouble(3, product.getPricePro());
                updateProduct.executeUpdate();
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    public void deleteByID(int id){
        Connection conn = null;

        try {
            conn = connection();

            if (conn != null) {
                String query = "delete from "+table+" where idPro= '"+id+"'";
                Statement sta = conn.createStatement();
                sta.executeUpdate(query);
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteAllINFOonTABLE(){
        try {
            Connection conn = connection();

            if (conn != null) {
                Statement sta = conn.createStatement();
                sta.executeUpdate("DELETE FROM "+table);
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
}
