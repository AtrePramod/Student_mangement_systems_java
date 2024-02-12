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
public class marksupdate {
   //   department, sem, name, sub, marks
 public boolean updatedata(String department,String  sem,String name,String sub,String marks)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
            Statement st=con.createStatement();
             //   department, sem, name, sub, marks

        String query="update marksinfo set department='"+department+"',sem='"+sem+"',marks='"+marks+"',sub='"+sub+"'  where sub='"+sub+"'and name='"+name+"'";
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
