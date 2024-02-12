/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import staff.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author PRAMOD
 */
public class studentmaker {
    
   // name, dob, emailid, mobile, department, sem, iid
    public boolean insertData(String name,String dob,String emailid,String mobile,String department,String sem,String iid)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
             
            
            String query="insert into studinfo values('"+name+"','"+dob+"','"+emailid+"','"+mobile+"','"+department+"','"+sem+"','"+iid+"')";
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
