/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author esra
 */
public class signUp {
    connection c=new connection();
    boolean sonuc;
    public boolean control(String idenNum){
        try{
            
            c.connect();
            Statement komut=c.con.createStatement();
            ResultSet rs = komut.executeQuery("select * from PATIENT order by IDENTIFICATION_NUMBER");
            while(rs.next())
            {
                if(idenNum.equals(rs.getString("IDENTIFICATION_NUMBER")))
                {
                    JOptionPane.showMessageDialog(null, "Daha önce bu TC numarası ile kayıt yapılmıştır.");
                    sonuc=false;
                }    
                else
                {
                    sonuc=true;
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"HATA: "+ex);
        }
        return sonuc;
    
    }
    
    public void signUp(String name,String surname,String idenNum,String mumName,String dadName,String phoneNum,String address,String mail,String pass){
        try{
            c.connect();
            PreparedStatement komut1=c.con.prepareStatement("insert into PATIENT(PATIENT_NAME,PATIENT_LASTNAME,IDENTIFICATION_NUMBER,P_MUM_NAME,P_DAD_NAME,PHONE_NUMBER,PATIENT_ADDRESS,PATIENT_MAIL,PASSWORD)"
                        + " values(?,?,?,?,?,?,?,?,?)");
                    komut1.setString(1, name);
                    komut1.setString(2, surname);
                    komut1.setString(3, idenNum);
                    komut1.setString(4, mumName);
                    komut1.setString(5, dadName);
                    komut1.setString(6, phoneNum);
                    komut1.setString(7, address);
                    komut1.setString(8, mail);
                    komut1.setString(9, pass);
                    komut1.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Kaydınız Tamamlanmıştır.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
    }
}
