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
public class foundDoctor {
    int doctorRef;
    public int doctorPatient(String docName){
        connection c=new connection();
        
            try{
                c.connect();
                Statement komut=c.con.createStatement();
                String sql="Select LOGICALREF from DOCTOR where DOCTOR_NAME='"+docName+"'";
                ResultSet rs=komut.executeQuery(sql);
            while(rs.next())    
            doctorRef = rs.getInt("LOGICALREF");
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,""+e);
            }
        return doctorRef;
    }
    
}
