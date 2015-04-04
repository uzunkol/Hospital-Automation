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
public class getHospital {
    
    public ArrayList<String> getHospital(String city)
    {       
        ArrayList<String> hospital=new ArrayList();
        connection c=new connection();
            try{
                c.connect();
                Statement komut=c.con.createStatement();
                String sql="Select * from HOSPITAL where CITYREF=(Select LOGICALREF from CITY where CITY_NAME='"+city+"')";
                ResultSet rs=komut.executeQuery(sql);
                
                while(rs.next())
                {
                    hospital.add(rs.getString("HOSPITAL_NAME"));
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,""+e);
            }
        return hospital;
    }

}
