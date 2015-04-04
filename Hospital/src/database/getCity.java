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
public class getCity {
   
    public ArrayList<String> getCity()
    {       
        ArrayList<String> city=new ArrayList();
        connection c=new connection();
            try{
                c.connect();
                Statement komut=c.con.createStatement();
                String sql="Select * from CITY";
                ResultSet rs=komut.executeQuery(sql);
                while(rs.next())
                {
                    city.add(rs.getString("CITY_NAME"));
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,""+e);
            }
        return city;
    }
    
    
}
