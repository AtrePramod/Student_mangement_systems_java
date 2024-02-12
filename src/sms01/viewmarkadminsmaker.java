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

/**
 *
 * @author PRAMOD
 */
public class viewmarkadminsmaker {
    public void viewAllmarks()
    {
       try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
               
            String query="Select * from marksinfo";
            ResultSet rs1=st1.executeQuery(query);        
            ResultSet rs2=st2.executeQuery(query);        
            
            int row=0;
            while(rs1.next())
            {
                row++;
            }
            int i=0;
            String [][] data=new String[row][5];
            //department, sem, name, sub, marks
                while(rs2.next())
                {
                    String department=rs2.getString(1);
                    String sem=rs2.getString(2);
                    String name=rs2.getString(3);
                    String  sub=rs2.getString(4);
                    String marks=rs2.getString(5);
                data[i][0]=department;
                data[i][1]=sem;
                data[i][2]=name;
                data[i][3]=sub;
                data[i][4]= marks;
                i++;
         }
                viewmarksadminframe.data=data;
               
        }
        catch(Exception e)
        {
            System.out.println(e);
             
        }
    }
    
}
