/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.ProductDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class TransactionDTO {
    private String itemId;
    private String productId;
    private Date date;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getDate() {
        return date;
    }
    
    public String getDateString(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public void setDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            this.date = df.parse(date);
        } catch (ParseException ex) {
        }
    }
    
    public void display(){
        System.out.println("------------------------");
        System.out.println("Item ID    : " + String.valueOf(this.itemId));
        System.out.println("Product ID : " + String.valueOf(this.productId));
        System.out.println("Name       : " + new ProductDAO().getProductById(this.productId).getName());
        System.out.println("Date       : " + this.date.toString());
        System.out.println("------------------------");
    }
}