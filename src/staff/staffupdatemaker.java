/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package staff;
import student.*;
import sms01.*;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author PRAMOD
 */
public class staffupdatemaker {
   //    name, mobileno, emilid,sub, emid, password
 public boolean updatedata(String name,String  mobileno,String emailid,String sub,String emid,String password)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
                     //    name, mobileno, emilid,sub, emid, password
//name, mobileno, emilid, sub, emid, password
        String query="update staffinfo set name='"+name+"',mobileno='"+mobileno+"',emailid='"+emailid+"',sub='"+sub+"',password='"+password+"' where emid='"+emid+"'";
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
