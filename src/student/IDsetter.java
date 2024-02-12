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
public class IDsetter {
    
    public int getId()
    {   
     int id=0;
     ArrayList <Integer> ids=new ArrayList <Integer>();
      try
      {
        
    
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
            
            String query="Select * from studinfo";
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                String idd=rs.getString(7);
                int biid=Integer.parseInt(idd);
                ids.add(biid);
            }
          
           if(ids.size()==0)
           {
             id=1;
           }
           else
           {
            int big=ids.get(0);
            for(int i=0;i<ids.size();i++)
             {
                 int aa=ids.get(i);
                 if(aa>big)
                {
                  big=aa;
                 }
            }
             id=big+1;
          }
    }
    catch(Exception ex)
    {
        System.out.println("Expection in inserter"+ex);
    }            
    return id;
    }
}
