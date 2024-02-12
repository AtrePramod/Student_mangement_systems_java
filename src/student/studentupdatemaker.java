/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;
import sms01.*;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author PRAMOD
 */
public class studentupdatemaker {
    // name, dob, emailid, mobile, department, sem, iid
 public boolean updatedata(String name,String  dob,String emailid,String mobile,String department,String sem,String iid)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
                                        // name, dob, emailid, mobile, department, sem, iid

        String query="update studinfo set name='"+name+"',dob='"+dob+"',emailid='"+emailid+"',mobile='"+mobile+"',department='"+department+"',sem='"+sem+"' where iid='"+iid+"'";
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
