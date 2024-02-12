/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PRAMOD
 */
public class studentDatafetcher {
    public ArrayList getDetails(String id)
    {
        ArrayList ar=new ArrayList();
      try
      {
        
    
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
            
            String query="Select * from studinfo where iid=('"+id+"')";
            ResultSet rs=st.executeQuery(query);
               
            if(rs.next())
            {
                ar.add(rs.getString(1));
                ar.add(rs.getString(2));
                ar.add(rs.getString(3));
                ar.add(rs.getString(4));
                ar.add(rs.getString(5));
                ar.add(rs.getString(6));
                ar.add(rs.getString(7));
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
