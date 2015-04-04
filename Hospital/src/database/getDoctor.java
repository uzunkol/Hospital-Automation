/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author esra
 */
public class getDoctor {
   
    public ArrayList<String> getDoctor(String hospitalName,String branchName)
    {       
        ArrayList<String> doctor=new ArrayList();
        connection c=new connection();
            try{
                c.connect();
                Statement komut=c.con.createStatement();
                String sql="Select * from DOCTOR where HOSPITALREF=(Select LOGICALREF from HOSPITAL where HOSPITAL_NAME='"+hospitalName+"')and " +
"BRANCHREF=(Select LOGICALREF from BRANCH where BRANCH_NAME='"+branchName+"')";
                ResultSet rs=komut.executeQuery(sql);
                
                while(rs.next())
                {
                    doctor.add(rs.getString("DOCTOR_NAME"));
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,""+e);
            }
        return doctor;

    }
}    
