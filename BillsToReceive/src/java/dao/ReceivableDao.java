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
import java.util.Date;
import models.Client;
import models.Nature;
import models.Product;
import models.Receivable;
import utils.FactoryConnection;
import utils.FactoryFormatTypes;


/**
 *
 * @author Marcos
 */
public class ReceivableDao {
    
    public void create(Receivable receivable) {
        
        FactoryFormatTypes formatTypes = new FactoryFormatTypes();
        
        String sql = "";
        sql += " INSERT INTO tb_receivable ";
        sql += " ( ";
        sql += " title, installments, title_type, title_value, title_amount, title_total, dt_payment, "; 
        sql += " dt_expiration, form_of_payment, pay, dt_emission, blocked, ";
        sql += " product_id, client_id, nature_id, user_id ";
        sql += " ) ";
        sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
              
            stmt.setString(1,   receivable.getTitle());
            stmt.setString(2,   receivable.getInstallments());
            stmt.setString(3,   receivable.getTitle_type());
            stmt.setDouble(4,   receivable.getTitle_value());
            stmt.setInt(5,      receivable.getTitle_amount());
            stmt.setDouble(6,   receivable.getTitle_total());
            stmt.setDate(7,     formatTypes.formatSqlDate(receivable.getDt_payment()) );
            stmt.setDate(8,     formatTypes.formatSqlDate(receivable.getDt_expiration()) );
            stmt.setString(9,   receivable.getForm_of_payment());
            stmt.setString(10,  receivable.getPay());
            stmt.setDate(11,    formatTypes.formatSqlDate(receivable.getDt_emission()) );
            stmt.setString(12,  receivable.getBlocked());
            stmt.setInt(13,     receivable.getProduct().getId());
            stmt.setInt(14,     receivable.getClient().getId());
            stmt.setInt(15,     receivable.getNature().getId());
            stmt.setInt(16,     receivable.getUser().getId());
           
            stmt.execute();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    
    public ArrayList<Receivable> selectAll() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_receivable";
        
        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        ArrayList<Receivable> list = new ArrayList<Receivable>();
        
        try{
            
            while(rs.next()) {
                
                // carregando relacionamentos 
                Product product = ProductDao.selectProduct(rs.getInt("product_id"));
                Nature nature = NatureDao.selectNature(rs.getInt("nature_id"));
                Client client = ClientDao.selectClient(rs.getInt("client_id"));
                                
                Receivable receivable = new Receivable.ReceivableBuilder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .installments(rs.getString("installments"))
                        .titleType(rs.getString("title_type"))
                        .title_value(rs.getDouble("title_value"))
                        .title_amount(rs.getInt("title_amount"))
                        .title_total(rs.getDouble("title_total"))
                        .dt_payment(rs.getDate("dt_payment"))
                        .dt_expiration(rs.getDate("dt_expiration"))
                        .form_of_payment(rs.getString("form_of_payment"))
                        .pay(rs.getString("pay"))
                        .dt_emission(rs.getDate("dt_emission"))
                        .blocked(rs.getString("blocked"))
                        .product(product)
                        .nature(nature)
                        .client(client)
                        .build();
               
                list.add(receivable);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public static Receivable selectReceivable(int id) throws ClassNotFoundException, SQLException
    {
        
        Receivable receivable = null;
        
        try{
            
            Connection conn = null;
            FactoryConnection connection = new FactoryConnection();

            PreparedStatement stmt;
            ResultSet rs;
            String sql = "SELECT * FROM tb_receivable WHERE id = ?";

            conn = connection.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            rs = stmt.executeQuery();
           
            
            while(rs.next()) {

                 // carregando relacionamentos 
                Product product = ProductDao.selectProduct(rs.getInt("product_id"));
                Nature nature = NatureDao.selectNature(rs.getInt("nature_id"));
                Client client = ClientDao.selectClient(rs.getInt("client_id"));
                
                receivable = new Receivable.ReceivableBuilder()
                       .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .installments(rs.getString("installments"))
                        .titleType(rs.getString("title_type"))
                        .title_value(rs.getDouble("title_value"))
                        .title_amount(rs.getInt("title_amount"))
                        .title_total(rs.getDouble("title_total"))
                        .dt_payment(rs.getDate("dt_payment"))
                        .dt_expiration(rs.getDate("dt_expiration"))
                        .form_of_payment(rs.getString("form_of_payment"))
                        .pay(rs.getString("pay"))
                        .dt_emission(rs.getDate("dt_emission"))
                        .blocked(rs.getString("blocked"))
                        .product(product)
                        .nature(nature)
                        .client(client)
                        .build();
            }
           
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return receivable;
    }
    
    
    public static ArrayList<Receivable> selectById(int id) throws ClassNotFoundException, SQLException
    {

        ArrayList<Receivable> list = new ArrayList<Receivable>();
        
        try{
            
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_receivable WHERE id = ?";
        
        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        rs = stmt.executeQuery();
       
            
            while(rs.next()) {

                  // carregando relacionamentos 
                Product product = ProductDao.selectProduct(rs.getInt("product_id"));
                Nature nature = NatureDao.selectNature(rs.getInt("nature_id"));
                Client client = ClientDao.selectClient(rs.getInt("client_id"));
                                
                Receivable receivable = new Receivable.ReceivableBuilder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .installments(rs.getString("installments"))
                        .titleType(rs.getString("title_type"))
                        .title_value(rs.getDouble("title_value"))
                        .title_amount(rs.getInt("title_amount"))
                        .title_total(rs.getDouble("title_total"))
                        .dt_payment(rs.getDate("dt_payment"))
                        .dt_expiration(rs.getDate("dt_expiration"))
                        .form_of_payment(rs.getString("form_of_payment"))
                        .pay(rs.getString("pay"))
                        .dt_emission(rs.getDate("dt_emission"))
                        .blocked(rs.getString("blocked"))
                        .product(product)
                        .nature(nature)
                        .client(client)
                        .build();

                list.add(receivable);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public static void delete(int id)
    {
        
        try{
           
            Connection conn = null;
            FactoryConnection connection = new FactoryConnection();
        
            PreparedStatement stmt;
            String sql = "DELETE FROM tb_receivable WHERE id = ?";
        
            conn = connection.getConnection();
            stmt = conn.prepareStatement(sql);
        
            stmt.setInt(1, id);
        
            stmt.executeUpdate();
    
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       
    }
    
    
    public static void update(Receivable receivable)
    {
        FactoryFormatTypes formatTypes = new FactoryFormatTypes();  
        
        String sql = "";
        sql += " UPDATE tb_receivable ";
        sql += " SET title=?, installments=?, title_type=?, title_value=?, title_amount=?,title_total=?, dt_payment=?, "; 
        sql += " dt_expiration=?, form_of_payment=?, pay=?, dt_emission=?, blocked=?, ";
        sql += " product_id=?, client_id=?, nature_id=? ";
        sql += " WHERE id = ?";
        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,   receivable.getTitle());
            stmt.setString(2,   receivable.getInstallments());
            stmt.setString(3,   receivable.getTitle_type());
            stmt.setDouble(4,   receivable.getTitle_value());
            stmt.setInt(5,      receivable.getTitle_amount());
            stmt.setDouble(6,   receivable.getTitle_total());
            stmt.setDate(7,     formatTypes.formatSqlDate(receivable.getDt_payment()) );
            stmt.setDate(8,     formatTypes.formatSqlDate(receivable.getDt_expiration()) );
            stmt.setString(9,   receivable.getForm_of_payment());
            stmt.setString(10,   receivable.getPay());
            stmt.setDate(11,     formatTypes.formatSqlDate(receivable.getDt_emission()) );
            stmt.setString(12,  receivable.getBlocked());
            stmt.setInt(13,     receivable.getProduct().getId());
            stmt.setInt(14,     receivable.getClient().getId());
            stmt.setInt(15,     receivable.getNature().getId());
            stmt.setInt(16,     receivable.getId());
            
            stmt.executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
       
    }
    
    
     public ArrayList<Receivable> selectByField(String field, String fieldValue) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();

        PreparedStatement stmt;
        ResultSet rs;
        
        
        String sql = "SELECT * FROM tb_receivable WHERE "+field+" LIKE ? ";

        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, "%" + fieldValue + "%");
        
        rs = stmt.executeQuery();

        ArrayList<Receivable> list = new ArrayList<Receivable>();

        try {

            while (rs.next()) {
                
                // carregando relacionamentos 
                Product product = ProductDao.selectProduct(rs.getInt("product_id"));
                Nature nature = NatureDao.selectNature(rs.getInt("nature_id"));
                Client client = ClientDao.selectClient(rs.getInt("client_id"));
                
                Receivable receivable = new Receivable.ReceivableBuilder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .installments(rs.getString("installments"))
                        .titleType(rs.getString("title_type"))
                        .title_value(rs.getDouble("title_value"))
                        .title_amount(rs.getInt("title_amount"))
                        .title_total(rs.getDouble("title_total"))
                        .dt_payment(rs.getDate("dt_payment"))
                        .dt_expiration(rs.getDate("dt_expiration"))
                        .form_of_payment(rs.getString("form_of_payment"))
                        .pay(rs.getString("pay"))
                        .dt_emission(rs.getDate("dt_emission"))
                        .blocked(rs.getString("blocked"))
                        .product(product)
                        .nature(nature)
                        .client(client)
                        .build();

                list.add(receivable);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
     
     
     public ArrayList<Receivable> selectByDtExpiration() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
         FactoryFormatTypes formatTypes = new FactoryFormatTypes();
        PreparedStatement stmt;
        ResultSet rs;
        
        
        String sql = "SELECT * FROM tb_receivable WHERE dt_expiration <= ? AND pay <> 1";

        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, formatTypes.convertDateToString(new Date()));
        
        rs = stmt.executeQuery();

        ArrayList<Receivable> list = new ArrayList<Receivable>();

        try {

            while (rs.next()) {
                
                // carregando relacionamentos 
                Product product = ProductDao.selectProduct(rs.getInt("product_id"));
                Nature nature = NatureDao.selectNature(rs.getInt("nature_id"));
                Client client = ClientDao.selectClient(rs.getInt("client_id"));
                
                Receivable receivable = new Receivable.ReceivableBuilder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .installments(rs.getString("installments"))
                        .titleType(rs.getString("title_type"))
                        .title_value(rs.getDouble("title_value"))
                        .title_amount(rs.getInt("title_amount"))
                        .title_total(rs.getDouble("title_total"))
                        .dt_payment(rs.getDate("dt_payment"))
                        .dt_expiration(rs.getDate("dt_expiration"))
                        .form_of_payment(rs.getString("form_of_payment"))
                        .pay(rs.getString("pay"))
                        .dt_emission(rs.getDate("dt_emission"))
                        .blocked(rs.getString("blocked"))
                        .product(product)
                        .nature(nature)
                        .client(client)
                        .build();

                list.add(receivable);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
}
