/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sms01;

import staff.*;
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
public class namefetcher {
    public ArrayList getDetails()
    {
        ArrayList ar=new ArrayList();
      try
      {
        
    
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
        //    name, dob, emailid, mobile, department, sem, iid
            String query="Select * from studinfo";
            ResultSet rs=st.executeQuery(query);
               
            while(rs.next())
            {
               String name=rs.getString(1);
               ar.add(name) ;
            }
            System.out.println("ar is "+ar);
        }
      
    catch(Exception e)
    {
        System.out.println("Expection at datafetcher"+e);
    }   
       return ar;
    }
    
}
