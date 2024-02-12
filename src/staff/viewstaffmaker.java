/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PRAMOD
 */
public class viewstaffmaker {
    public void viewAllstaff()
    {
       try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
               
            String query="Select * from staffinfo";
            ResultSet rs1=st1.executeQuery(query);        
            ResultSet rs2=st2.executeQuery(query);        
            
            int row=0;
            while(rs1.next())
            {
                row++;
            }
            int i=0;
            String [][] data=new String[row][5];
            //name, mobileno, emailid,sub, emid, password
                while(rs2.next())
                {
                    String name=rs2.getString(1);
                    String mobileno=rs2.getString(2);
                    String emailid=rs2.getString(3);
                    String  sub=rs2.getString(4);
                    String emid=rs2.getString(5);
                data[i][0]=name;
                data[i][1]=mobileno;
                data[i][2]=emailid;
                data[i][3]=sub;
                data[i][4]= emid;
                i++;
         }
                viewstaffframe.data1=data;
        }
        catch(Exception e)
        {
            System.out.println(e);
             
        }
    }
    
}
