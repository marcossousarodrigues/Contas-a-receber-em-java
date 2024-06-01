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
import models.Client;
import models.Nature;
import utils.FactoryConnection;

/**
 *
 * @author Marcos
 */
public class ClientDao {
    
    
    public void create(Client client) {
        
        String sql = "";
        sql += " INSERT INTO tb_clients ";
        sql += " (name, person, cnpj_cpf, email, tel, cep, country, state, city,";
        sql += " neighborhood, street, number, blocked ) ";
        
        sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            
            stmt.setString(1,   client.getName());
            stmt.setString(2,   client.getPerson());
            stmt.setString(3,   client.getCnpj_cpf());
            stmt.setString(4,   client.getEmail());
            stmt.setString(5,   client.getTel());
            stmt.setString(6,   client.getCep());
            stmt.setString(7,   client.getCountry());
            stmt.setString(8,   client.getState());
            stmt.setString(9,   client.getCity());
            stmt.setString(10,   client.getNeighborhood());
            stmt.setString(11,  client.getStreet());
            stmt.setString(12,  client.getNumber());
            stmt.setString(13,  client.getBlocked());
            
            stmt.execute();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    
    
    public void update(Client client) {
        String sql = "";
        sql += " UPDATE tb_clients ";
        sql += " SET name=?, person=?, cnpj_cpf=?, email=?, tel=?, cep=?, country=?, state=?, city=?,";
        sql += " neighborhood=?, street=?, number=?, blocked=? ";
        sql += " WHERE id=? ";

        try {
            // abrindo conexão e executando a query
            FactoryConnection connection = new FactoryConnection();
            Connection conn = connection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,   client.getName());
            stmt.setString(2,   client.getPerson());
            stmt.setString(3,   client.getCnpj_cpf());
            stmt.setString(4,   client.getEmail());
            stmt.setString(5,   client.getTel());
            stmt.setString(6,   client.getCep());
            stmt.setString(7,   client.getCountry());
            stmt.setString(8,   client.getState());
            stmt.setString(9,   client.getCity());
            stmt.setString(10,   client.getNeighborhood());
            stmt.setString(11,  client.getStreet());
            stmt.setString(12,  client.getNumber());
            stmt.setString(13,  client.getBlocked());
            stmt.setInt(14, client.getId());
            
            stmt.executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    
    
    public static void delete(Client client)
    {
        try{
           
            Connection conn = null;
            FactoryConnection connection = new FactoryConnection();
        
            PreparedStatement stmt;
            String sql = "DELETE FROM tb_clients WHERE id = ?";
        
            conn = connection.getConnection();
            stmt = conn.prepareStatement(sql);
        
            stmt.setInt(1, client.getId());
        
            stmt.executeUpdate();
    
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       
    }
    
    public ArrayList<Client> selectAll() throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_clients";
        
        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        ArrayList<Client> list = new ArrayList<Client>();
        
        try{
            
            while(rs.next()) {

                Client client = new Client.ClientBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .person(rs.getString("person"))
                        .cnpjCpf(rs.getString("cnpj_cpf"))
                        .email(rs.getString("email"))
                        .tel(rs.getString("tel"))
                        .cep(rs.getString("cep"))
                        .country(rs.getString("country"))
                        .state(rs.getString("state"))
                        .city(rs.getString("city"))
                        .neighborhood(rs.getString("neighborhood"))
                        .street(rs.getString("street"))
                        .number(rs.getString("number"))
                        .blocked(rs.getString("blocked"))
                        
                        .build();

                list.add(client);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    
    public static Client selectClient(int id) throws ClassNotFoundException, SQLException
    {
        Connection conn = null;
        FactoryConnection connection = new FactoryConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT * FROM tb_clients WHERE id = ?";
        
        conn = connection.getConnection();
        stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        rs = stmt.executeQuery();
        
        Client client = new Client();
      
        while(rs.next())
        {
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("name"));
            client.setPerson(rs.getString("person"));
            client.setCnpj_cpf(rs.getString("cnpj_cpf"));
            client.setEmail(rs.getString("email"));
            client.setTel(rs.getString("tel"));
            client.setCep(rs.getString("cep"));
            client.setCountry(rs.getString("country"));
            client.setState(rs.getString("state"));
            client.setCity(rs.getString("city"));
            client.setNeighborhood(rs.getString("neighborhood"));
            client.setStreet(rs.getString("street"));
            client.setNumber(rs.getString("number"));
            client.setBlocked(rs.getString("blocked"));
        }
        
        return client;
    }
    
}
