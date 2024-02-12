/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sms01;

 
import student.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PRAMOD
 */
public class emailidfetcher {
    public String getDetails(String name)
    {
         String emailid="";
      try
      { 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
        //    department, sem, name, sub, marks
            String query="Select * from studinfo where name=('"+name+"')" ;
            ResultSet rs=st.executeQuery(query);
             if(rs.next())
            {
                emailid=rs.getString(3);
            }
            System.out.println("email is "+emailid);
        }
      
    catch(Exception e)
    {
        System.out.println("Expection at datafetcher"+e);
    }   
       return emailid;
    }
    
}
