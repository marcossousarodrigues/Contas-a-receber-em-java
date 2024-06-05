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
import utils.FactoryConnection;

/**
 *
 * @author Marcos
 */
public class NatureDao {
    
    public void create(Nature nature) {
        String sql = "";
        sql += " INSERT INTO tb_natures ";
        sql += " (name, description, type, cost_center, account, blocked) ";
        sql += " VALUES (?, ?, ?, ?, ?, ?) ";

        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nature.getName());
            stmt.setString(2, nature.getDescription());
            stmt.setString(3, nature.getType());
            stmt.setString(4, nature.getCostCenter());
            stmt.setString(5, nature.getAccount());
            stmt.setString(6, nature.getBlocked());
            
            stmt.execute();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    
    public void update(Nature nature) {
        String sql = "";
        sql += " UPDATE tb_natures ";
        sql += " SET name=?, description=?, type=?, cost_center=?, account=?, blocked=? ";
        sql += " WHERE id=? ";

        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nature.getName());
            stmt.setString(2, nature.getDescription());
            stmt.setString(3, nature.getType());
            stmt.setString(4, nature.getCostCenter());
            stmt.setString(5, nature.getAccount());
            stmt.setString(6, nature.getBlocked());
            stmt.setInt(7, nature.getId());
            
            stmt.executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    
    
    public static void delete(Nature nature)
    {
        
        try{
           
            Connection conn = null;
            FactoryConnection connection = new FactoryConnection();
        
            PreparedStatement stmt;
            String sql = "DELETE FROM tb_natures WHERE id = ?";
        
            conn = connection.getConnection();
            stmt = conn.prepareStatement(sql);
        
            stmt.setInt(1, nature.getId());
        
            stmt.executeUpdate();
    
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       
    }
    
    public ArrayList<Nature> selectAll() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_natures";
        
        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        ArrayList<Nature> list = new ArrayList<Nature>();
        
        try{
            
            while(rs.next()) {

                Nature nature = new Nature.NatureBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .type(rs.getString("type"))
                        .costCenter(rs.getString("cost_center"))
                        .account(rs.getString("account"))
                        .blocked(rs.getString("blocked"))
                        .build();
                
                list.add(nature);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public static ArrayList<Nature> selectById(int id) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_natures WHERE id = ?";
        
        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        rs = stmt.executeQuery();
        
        ArrayList<Nature> list = new ArrayList<Nature>();
        
        try{
            
            while(rs.next()) {

                Nature nature = new Nature.NatureBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .type(rs.getString("type"))
                        .costCenter(rs.getString("cost_center"))
                        .account(rs.getString("account"))
                        .blocked(rs.getString("blocked"))
                        .build();
                
                list.add(nature);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public static Nature selectNature(int id) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_natures WHERE id = ?";
        
        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        rs = stmt.executeQuery();
        
        Nature nature = null;
      
        while(rs.next())
        {
            nature = new Nature.NatureBuilder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .description(rs.getString("description"))
                    .type(rs.getString("type"))
                    .costCenter(rs.getString("cost_center"))
                    .account(rs.getString("account"))
                    .blocked(rs.getString("blocked"))
                    .build();
        }
        
        return nature;
    }
    
     public ArrayList<Nature> selectByField(String field, String fieldValue) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();

        PreparedStatement stmt;
        ResultSet rs;
        
        
        String sql = "SELECT * FROM tb_natures WHERE "+field+" LIKE ? ";

        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, "%" + fieldValue + "%");
        
        rs = stmt.executeQuery();

        ArrayList<Nature> list = new ArrayList<Nature>();

        try {

            while (rs.next()) {

                Nature natures = new Nature.NatureBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .type(rs.getString("type"))
                        .costCenter(rs.getString("cost_center"))
                        .account(rs.getString("account"))
                        .blocked(rs.getString("blocked"))
                        .build();

                list.add(natures);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    
}
