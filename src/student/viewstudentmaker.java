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

/**
 *
 * @author PRAMOD
 */
public class viewstudentmaker {
    public void viewAllstudent()
    {
       try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
               
            String query="Select * from studinfo";
            ResultSet rs1=st1.executeQuery(query);        
            ResultSet rs2=st2.executeQuery(query);        
            
            int row=0;
            while(rs1.next())
            {
                row++;
            }
            int i=0;
            String [][] data=new String[row][7];
           // name, dob, emailid, mobile, department, sem, iid
                while(rs2.next())
                {
                    String name=rs2.getString(1);
                    String  dob=rs2.getString(2);
                    String emailid=rs2.getString(3);
                    String  mobile=rs2.getString(4);
                    String department=rs2.getString(5);
                    String   sem=rs2.getString(6);
                    String iid=rs2.getString(7);
                data[i][0]=name;
                data[i][1]= dob;
                data[i][2]=emailid;
                data[i][3]=mobile;
                data[i][4]= department;
                data[i][5]= sem;
                data[i][6]= iid;
                i++;
                                }
                viewstudentframe.data1=data;
        }
        catch(Exception e)
        {
            System.out.println(e);
             
        }
    }
    
}
