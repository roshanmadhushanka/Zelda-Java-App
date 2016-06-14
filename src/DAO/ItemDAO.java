/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ItemDTO;
import System.Security;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import zeldacon.ServerConnection;

/**
 *
 * @author User
 */
public class ItemDAO {
    
    public ItemDTO getItemById(String id){
        ServerConnection serverConnection = new ServerConnection("http://ynot.esy.es/GetAnyItemById.php");
        URLConnection con = serverConnection.getConnection();
        if(con != null){
            con.setDoOutput(true);
            PrintStream ps = null;
            try {
                ps = new PrintStream(con.getOutputStream());
                ps.print("itemID=" + id);
                
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    if(line.length() > 0){
                        line = Security.decrypt(line);
                        ItemDTO itemDTO = new ItemDTO();
                        JSONObject json = new JSONObject(line);
                        itemDTO.setId(json.getInt("id"));
                        itemDTO.setProductId(json.getInt("productId"));
                        itemDTO.setName(json.getString("name"));
                        itemDTO.setDescription(json.getString("description"));
                        itemDTO.setPrice(json.getDouble("price"));
                        itemDTO.setType(json.getString("type"));
                        itemDTO.setStatus(json.getString("status"));
                        return itemDTO;
                    }
                }        
            } catch (IOException ex) {
            } catch (JSONException ex){
            }finally{
                ps.close();
            }
        }
        return null;
    }
    
    public void insert(ItemDTO itemDTO){
        ServerConnection serverConnection = new ServerConnection("http://ynot.esy.es/AddItem.php");
        URLConnection con = serverConnection.getConnection();
        if(con != null){
            con.setDoOutput(true);
            PrintStream ps = null;
            try {
                ps = new PrintStream(con.getOutputStream());
                ps.print("&itemId=" + itemDTO.getId());
                ps.print("&productId="+itemDTO.getProductId());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    if(line.length() > 0){
                        if(line.equals("Success")){
                            JOptionPane.showMessageDialog(null, "Item successfuly added", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }else if(line.equals("Id_exist_error")){
                            JOptionPane.showMessageDialog(null, "Id already exsists", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }catch(IOException e){
                
            }
        }
    }
}
