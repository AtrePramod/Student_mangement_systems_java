/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sms01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PRAMOD
 */
public class marksinfofetcher {
    public  ArrayList getDetails(String name)
    {
         ArrayList marksinfo=new ArrayList();
      try
      { 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
        //    department, sem, name, sub, marks
            String query="Select * from marksinfo where name=('"+name+"')" ;
            ResultSet rs=st.executeQuery(query);
             while(rs.next())
            {
                ArrayList temp=new ArrayList();
                temp.add(rs.getString(4));
                temp.add(rs.getString(5));
                marksinfo.add(temp);
             }
             
        }
      
    catch(Exception e)
    {
        System.out.println("Expection at  marksfetcher"+e);
    }   
       return marksinfo;
    } 
}
