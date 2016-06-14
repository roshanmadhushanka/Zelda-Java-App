/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Message {
    public static void reCheckCustomer(){
        JOptionPane.showMessageDialog(null, "Please recheck the last customer", "Identify Error", JOptionPane.ERROR_MESSAGE);
    }
}
