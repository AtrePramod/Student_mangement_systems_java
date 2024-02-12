/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sms01;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author PRAMOD
 */
public class Sms01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loginframe plog=new loginframe();
        plog.setVisible(true);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        plog.setSize(d);
        
        // TODO code application logic here
    }
    
}
