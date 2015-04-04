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
public class getBranch {
    
    public ArrayList<String> getBranch()
    {       
        ArrayList<String> branch=new ArrayList();
        connection c=new connection();
            try{
                c.connect();
                Statement komut=c.con.createStatement();
                String sql="Select * from BRANCH";
                ResultSet rs=komut.executeQuery(sql);
                while(rs.next())
                {
                    branch.add(rs.getString("BRANCH_NAME"));
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,""+e);
            }
        return branch;
    }
}
