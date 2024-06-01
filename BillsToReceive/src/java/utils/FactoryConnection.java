/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//
/**
 *
 * @author Marcos
 */
public class FactoryConnection {
    private static Connection connection = null;
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/dbbillstoreceive";
    private static String user = "root";
    private static String pass = "";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return connection;
    }
    
}
