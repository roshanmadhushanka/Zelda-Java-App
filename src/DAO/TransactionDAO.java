/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TransactionDTO;
import System.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import zeldacon.ServerConnection;

/**
 *
 * @author User
 */
public class TransactionDAO {
    private static ArrayList<TransactionDTO> transactions;
    
    public void update(){
        ServerConnection serverConnection = new ServerConnection("http://ynot.esy.es/GetItemTransactions.php");
        URLConnection con = serverConnection.getConnection();
        if(con != null){
            try{
                transactions  = new ArrayList<>();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = null;
                while((line = in.readLine()) != null){
                    if(line.length() > 0){
                        line = line.replace("[", "");
                        line = line.replace("]", "");
                        line = line.replace("},{", "}//{");
                        String[] details = line.split("//");
                        for(String detail: details){
                            TransactionDTO transaction = new TransactionDTO();
                            JSONObject obj = new JSONObject(detail);
                            transaction.setItemId(obj.getString("item_id"));
                            transaction.setProductId(obj.getString("product_id"));
                            transaction.setDate(obj.getString("date"));
                            transactions.add(transaction);
                        }
                    }
                }
            }catch(IOException e){
            }catch(JSONException e){
            }
        }
    }
    
    public ArrayList<TransactionDTO> getAllTransactions(){
        update();
        return transactions;
    }
}
