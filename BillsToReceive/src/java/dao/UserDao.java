/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.User;
import utils.FactoryConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Product;

/**
 *
 * @author Marcos
 */
public class UserDao {
    
    public void create(User user)
    {
        String  sql = "";
        sql += " INSERT INTO tb_users (name, surname, email, password, permission, blocked) ";
        sql += " VALUES (?, ?, ?, ?, ?, ?) ";
        
        FactoryConnection connection = new FactoryConnection();
        try
        {
            Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, user.getName() );
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getPermission());
            stmt.setString(6, user.getBlocked());
            
            stmt.executeUpdate();
            
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
    }
    
    public void update(User user) {
        
        String sql = "";
        sql += " UPDATE tb_users ";
        sql += " SET name=?, surname=?, email=?, password=?, permission=?, blocked=? ";
        sql += " WHERE id=? ";

        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getPermission());
            stmt.setString(6, user.getBlocked());
            stmt.setInt(7, user.getId());
            
            stmt.executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    
    
    
    public ArrayList<User> selectAll() throws ClassNotFoundException
    {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_users";
        
        ArrayList<User> list = new ArrayList<User>();
        
        try{
        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        
            while(rs.next()) {

                User user = new User.UserBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .permission(rs.getString("permission"))
                        .blocked(rs.getString("blocked"))
                        .build();
                
                list.add(user);
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    
    public User selectById(User user)
    {
       String sql = "SELECT * FROM tb_users WHERE id=? ";
       
       
       FactoryConnection connection = new FactoryConnection();
       
       User usr = null;
       
       try
       {
            Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            
            ResultSet rs = stmt.executeQuery();
            
            
            while( rs.next() )
            {
                 usr = new User.UserBuilder()
                      .id(Integer.parseInt(rs.getString("id")))
                      .name(rs.getString("name"))
                      .surname(rs.getString("surname"))
                      .email(rs.getString("email"))
                      .password(rs.getString("password"))
                      .permission(rs.getString("permission"))                      
                      .blocked(rs.getString("blocked"))
                      .build();
            }
            
            
       }
       catch(Exception e)
       {
    
       }
       
       return usr;
    }
     
    
    public User selectByEmail(User user)
    {
       String sql = "SELECT * FROM tb_users WHERE email=? ";
        
       User usr = new User();
       
       FactoryConnection connection = new FactoryConnection();
       try
       {
            Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            
            ResultSet rs = stmt.executeQuery();
            
            while( rs.next() )
            {
              User userBuild = new User.UserBuilder()
                      .id(rs.getInt("id"))
                      .name(rs.getString("name"))
                      .surname(rs.getString("surname"))
                      .email(rs.getString("email"))
                      .permission(rs.getString("permission"))
                      .password(rs.getString("password"))                      
                      .blocked(rs.getString("blocked"))
                      .build();
                       usr = userBuild;
            }
            
            
       }
       catch(Exception e)
       {
           
       }
       
       return usr;
    }
    
    public static void delete(User user)
    {
        
        try{
           
            Connection conn = null;
            FactoryConnection connection = new FactoryConnection();
        
            PreparedStatement stmt;
            String sql = "DELETE FROM tb_users WHERE id = ?";
        
            conn = connection.getConnection();
            stmt = conn.prepareStatement(sql);
        
            stmt.setInt(1, user.getId());
        
            stmt.executeUpdate();
    
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       
    }
    
     public ArrayList<User> selectByField(String field, String fieldValue) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();

        PreparedStatement stmt;
        ResultSet rs;
        
        
        String sql = "SELECT * FROM tb_users WHERE "+field+" LIKE ? ";

        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, "%" + fieldValue + "%");
        
        rs = stmt.executeQuery();

        ArrayList<User> list = new ArrayList<User>();

        try {

            while(rs.next()) {

                User user = new User.UserBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .permission(rs.getString("permission"))
                        .blocked(rs.getString("blocked"))
                        .build();
                
                list.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
}
