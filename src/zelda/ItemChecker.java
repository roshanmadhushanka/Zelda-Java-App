/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import DAO.ItemDAO;
import DTO.ItemDTO;
import java.io.PrintStream;
import java.net.URLConnection;
import zeldacon.ServerConnection;

/**
 *
 * @author User
 */
public class ItemChecker {
    public enum Flag{
        COMMUNICATION_ERROR, PAID, NOT_PAID
    }
    
    private ServerConnection serverConnection;
    private URLConnection con;
    PrintStream ps = null; 
    
    public ItemChecker(){
        serverConnection = new ServerConnection("http://ynot.esy.es/CheckItemStatus.php");
    }
    
    public Flag isPaid(String id){
        try{
            ItemDAO itemDAO = new ItemDAO();
            ItemDTO itemDTO = itemDAO.getItemById(id);
            itemDTO.display();
            if(itemDTO.getStatus().equals("U")){
                return Flag.NOT_PAID;
            }else if(itemDTO.getStatus().equals("P")){
                return Flag.PAID;
            }else{
                return Flag.COMMUNICATION_ERROR;
            }
        } catch(Exception e){
            return Flag.COMMUNICATION_ERROR;
        }
        
    }
}
