/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sms01;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author PRAMOD
 */
public class adminupdatemaker {
 public boolean updatedata(String password,String  username)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
            
        String query="update admininfo set password='"+password+"' where username='"+username+"'";
        int x=st.executeUpdate(query);
        if(x>0)
        
            flag=true;
        else
            flag=false;
        }
        catch(Exception e)
        {
            System.out.println(e);
            flag=false;
        }
        return flag;
    }   

    
}
