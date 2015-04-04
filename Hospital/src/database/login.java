/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import view.frmAppointment;

/**
 *
 * @author esra
 */
public class login {
    connection c=new connection();
    //ResultSet rs1=null;
    
    public void signIn(String identificationNumber,String password) throws SQLException
    {
     try
        {   
     
            c.connect();
            Statement komut = c.con.createStatement();
            ResultSet rs = komut.executeQuery("select * from PATIENT order by IDENTIFICATION_NUMBER");
            while (rs.next()) {
                if(identificationNumber.equals(rs.getString("IDENTIFICATION_NUMBER")))
                {
                    if(password.equals(rs.getString("PASSWORD")))
                    {
                        
                        frmAppointment fA=new frmAppointment(identificationNumber);
                        fA.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Bilgilerinizi Yanlış Girdiniz");
                    }
                }
                               
           }
        c.con.close();
        }catch (Exception s)
            {
                System.out.print(s.getMessage());
            }
    }  
    
}
