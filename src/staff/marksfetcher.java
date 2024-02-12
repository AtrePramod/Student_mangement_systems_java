/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package staff;

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
public class marksfetcher {
    public String getDetails(String name,String sub)
    {
         String marks="";
      try
      { 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
        //    department, sem, name, sub, marks
            String query="Select * from marksinfo where name=('"+name+"') and sub=('"+sub+"')" ;
            ResultSet rs=st.executeQuery(query);
             if(rs.next())
            {
               marks=rs.getString(5);
            }
            System.out.println("marks is "+marks);
        }
      
    catch(Exception e)
    {
        System.out.println("Expection at datafetcher"+e);
    }   
       return marks;
    }
    
}
