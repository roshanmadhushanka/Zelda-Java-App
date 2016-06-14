/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeldacon;

/**
 *
 * @author User
 */
import java.net.*;
public class Internet {
    public static boolean checkStatus(){
        Socket socket = new Socket();
        InetSocketAddress address = new InetSocketAddress("www.google.com", 80);
        try{
            socket.connect(address, 3000);
            return true;
        }catch(Exception e){
            return false;
        }finally{
            try{
                socket.close();
            }catch(Exception e){
            }
        }
    }
}
