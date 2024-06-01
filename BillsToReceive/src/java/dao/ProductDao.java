/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Nature;
import models.Product;
import utils.FactoryConnection;

/**
 *
 * @author Marcos
 */
public class ProductDao {

    public void create(Product product) {
        String sql = "";
        sql += " INSERT INTO tb_products ";
        sql += " (name, description, price, blocked) ";
        sql += " VALUES (?, ?, ?, ?) ";

        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getBlocked());

            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    
    
     public void update(Product product) {
        String sql = "";
        sql += " UPDATE tb_products ";
        sql += " SET name=?, description=?, price=?, blocked=? ";
        sql += " WHERE id=? ";

        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getBlocked());
            stmt.setInt(5, product.getId());
            
            stmt.executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    
    
    public static void delete(Product product) {

        try {

            Connection conn = null;
            FactoryConnection connection = new FactoryConnection();

            PreparedStatement stmt;
            String sql = "DELETE FROM tb_products WHERE id = ?";

            conn = connection.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, product.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Product> selectAll() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();

        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_products";

        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        ArrayList<Product> list = new ArrayList<Product>();

        try {

            while (rs.next()) {

                Product product = new Product.ProductBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .price(rs.getDouble("price"))
                        .blocked(rs.getString("blocked"))
                        .build();

                list.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public ArrayList<Product> selectByField(String field, String fieldValue) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();

        PreparedStatement stmt;
        ResultSet rs;
        
        
        String sql = "SELECT * FROM tb_products WHERE "+field+" LIKE ? ";

        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, "%" + fieldValue + "%");
        
        rs = stmt.executeQuery();

        ArrayList<Product> list = new ArrayList<Product>();

        try {

            while (rs.next()) {

                Product product = new Product.ProductBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .price(rs.getDouble("price"))
                        .blocked(rs.getString("blocked"))
                        .build();

                list.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public static Product selectProduct(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();

        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_products WHERE id = ?";

        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        rs = stmt.executeQuery();

        Product prodcut = new Product();

        while (rs.next()) {
            prodcut.setId(rs.getInt("id"));
            prodcut.setName(rs.getString("name"));
            prodcut.setDescription(rs.getString("description"));
            prodcut.setPrice(rs.getDouble("price"));
            prodcut.setBlocked(rs.getString("blocked"));
        }

        return prodcut;
    }

}
