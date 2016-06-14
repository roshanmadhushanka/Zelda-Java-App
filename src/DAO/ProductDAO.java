/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ComboItem;
import DTO.ProductDTO;
import System.Security;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import zeldacon.Internet;
import zeldacon.ServerConnection;

/**
 *
 * @author User
 */
public class ProductDAO {
    private static HashMap<Integer, ProductDTO> productPool = new HashMap<>();
    private static boolean loadingUpdate = false;
    private static void initialize(){
        productPool = new HashMap<>(); 
    }
    
    public static boolean update(){
        ServerConnection serverConnection = new ServerConnection("http://ynot.esy.es/GetAllProductDetails.php");
        URLConnection con = serverConnection.getConnection();
        if(con != null){
            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = null;
                while((line = in.readLine()) != null){
                    if(line.length() > 0){
                        line = Security.decrypt(line);
                        line = line.replace("[", "");
                        line = line.replace("]", "");
                        line = line.replace("},{", "}//{");
                        String[] details = line.split("//");
                        for (String detail : details) {
                            ProductDTO product = new ProductDTO();
                            JSONObject obj = new JSONObject(detail);
                            product.setId(obj.getInt("id"));
                            product.setName(obj.getString("name"));
                            product.setDescription(obj.getString("description"));
                            product.setPrice(obj.getDouble("price"));
                            product.setType(obj.getString("type"));
                            productPool.put(product.getId(), product);
                        }
                    }
                }
                return true;
            }catch (IOException ex) {
                return false;
            }
        }
        return false;
    }
    
    public void insert(ProductDTO product){
        ServerConnection serverConnection = new ServerConnection("http://ynot.esy.es/AddProduct.php");
        URLConnection con = serverConnection.getConnection();
        if(con != null){
            con.setDoOutput(true);
            PrintStream ps = null;
            try {
                ps = new PrintStream(con.getOutputStream());
                ps.print("&productName="+product.getName());
                ps.print("&productDescription="+product.getDescription());
                ps.print("&productType="+product.getType());
                ps.print("&productPrice="+product.getPrice());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    if(line.length() > 0){
                        if(line.equals("Success")){
                            JOptionPane.showMessageDialog(null, "Product successfuly added", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }else if(line.equals("Product_match_error")){
                            JOptionPane.showMessageDialog(null, "Product already exsists", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }catch(IOException e){
                
            }
        }
    }
    
    public ArrayList getAllProducts(){
        if(productPool.isEmpty()){
            ProductDAO.update();
        }
        
        ArrayList<ProductDTO> productArray = new ArrayList<>();
        for(Integer key: productPool.keySet()){
            productArray.add(productPool.get(key));
        }
        return productArray;
    }
    
    public ArrayList<ComboItem> getAllProductsToCombo(){
        if(productPool.isEmpty()){
            ProductDAO.update();
        }
        
        ArrayList<ComboItem> comboItemArray = new ArrayList<>();
        for(Integer key: productPool.keySet()){
            comboItemArray.add(new ComboItem(String.valueOf(productPool.get(key).getId()), productPool.get(key).getName()));
        }
        return comboItemArray;
    }
    
    public ProductDTO getProductById(String id){
        if(productPool.isEmpty()){
            ProductDAO.update();
        }
        
        return productPool.get(Integer.parseInt(id));
    }
    
}
