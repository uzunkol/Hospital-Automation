/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author esra
 */
public class foundPatient {
    int patientRef;
    public int foundPatient(String identification){
        connection c=new connection();
        
            try{
                c.connect();
                Statement komut=c.con.createStatement();
                String sql="Select LOGICALREF from PATIENT where IDENTIFICATION_NUMBER='"+identification+"'";
                ResultSet rs=komut.executeQuery(sql);
            while(rs.next())    
            patientRef = rs.getInt("LOGICALREF");
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,""+e);
            }
        return patientRef;
    }
    
}
