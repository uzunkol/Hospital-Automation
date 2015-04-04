/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

/**
 *
 * @author esra
 */
public class saveAp {
    public void saveAp(int patientRef,int doctorRef,String date,String time){
        connection c=new connection();
            try{
                c.connect();
                PreparedStatement komut=c.con.prepareStatement("insert into APPOINTMENT(PATIENTREF,DOCTORREF,DATE,TIME) values(?,?,?,?)");
                
                komut.setInt(1, patientRef);
                komut.setInt(2, doctorRef);
                komut.setString(3, date);
                komut.setString(4, time);
                komut.executeUpdate();
                JOptionPane.showMessageDialog(null,"Randevunuzun Kaydedilmiştir");
                                   
    } catch(Exception e){
                JOptionPane.showMessageDialog(null,"HATA: "+e);
    }
    }
}
