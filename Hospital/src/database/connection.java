/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author esra
 */
public class connection {
    public Connection con;
    public void connect(){
        try {
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=HOSPITAL;user=sa;password=12345Qw";
 con = DriverManager.getConnection(connectionUrl);
  } catch (SQLException e) {
 System.out.println("SQL Exception: " + e.toString());
         } catch (ClassNotFoundException cE) {
           System.out.println("Class Not Found Exception: " + cE.toString());
         }
    }
}
      

