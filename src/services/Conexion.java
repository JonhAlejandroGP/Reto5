package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Connection connect; 
 
    public Conexion(String url) { 
        super(); 
        connectDB(url); 
    } 
     
  
 
    public Connection connectDB(String url) { 
 
 
        try { 
            connect = DriverManager.getConnection(url, "root", "");             
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
        } 
        return connect; 
    } 
 
    public ResultSet executeQuery(String sql) { 
        ResultSet rs = null; 
        try { 
            Statement stmt = connect.createStatement(); 
            rs = stmt.executeQuery(sql); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        return rs; 
    }  
}
