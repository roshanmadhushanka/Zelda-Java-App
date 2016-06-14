/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import DAO.ProductDAO;
import javax.swing.JOptionPane;
import zelda.Login;
import zelda.Monitor;
import zeldacon.Internet;

/**
 *
 * @author User
 */
public class Boot {
    private boolean initilizeSystem = false;
    
    public boolean run(){
        
        //Check internet connection status
         if(!Internet.checkStatus()){
             JOptionPane.showMessageDialog(null, "No internet connection :(", "Boot Error", JOptionPane.ERROR_MESSAGE);
             return false;
         }   
            
        //Update Product data
        if(!ProductDAO.update()){
            JOptionPane.showMessageDialog(null, "System update failed :(", "Boot Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
       
        //Login Access Control
        FileHandler fh = new FileHandler();
        fh.read("login.sx");
        if(fh.getStatusOfOperation() == false){
            JOptionPane.showMessageDialog(null, "IO system failed :(", "Boot Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
          
        //Load Login
        Login.getForm().setVisible(true);
        
        //Load Monitor Application
        //Monitor.getForm().setVisible(true);
        
        
        return true;
    }
}
