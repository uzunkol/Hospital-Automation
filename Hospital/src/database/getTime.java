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
public class getTime {
    public ArrayList<String> getTime(String doctorName,String apDate){
        ArrayList<String> time=new ArrayList();
        connection c=new connection();
            try{
                c.connect();
                Statement komut=c.con.createStatement();
                String sql="select * from APPOINTMENT \n" +
                            "where DATE='"+apDate+"' and\n" +
                            "DOCTORREF=(Select LOGICALREF from DOCTOR\n" +
                            "where DOCTOR_NAME='"+doctorName+"')";
                ResultSet rs=komut.executeQuery(sql);
                
                while(rs.next())
                {
                    time.add(rs.getString("TIME"));
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,""+e);
            }
        return time;
    }
}
