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
public class loginstaffmaker {
    public boolean dologin(String emid,String password )
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
            
    String query="Select * from staffinfo where emid='"+emid+"'and password='"+password+"'";
        ResultSet rs=st.executeQuery(query);
        if(rs.next())
                    flag=true;
        else
            flag=false;
        con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            flag=false;
        }
        return flag;
    }   
    
}
