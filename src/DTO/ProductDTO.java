/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author User
 */
public class ProductDTO {
    int id;
    private String name;
    private String description;
    private double price;
    private String type;

    public ProductDTO(){
        
    }
    
    public ProductDTO(int id, String name, String description, float price, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void display(){
        System.out.println("-----------------------------");
        System.out.println("ID          : " + String.valueOf(id));
        System.out.println("Name        : " + name);
        System.out.println("Description : " + description);
        System.out.println("Price       : " + String.valueOf(price));
        System.out.println("Type        : " + type);
        System.out.println("-----------------------------");
    }
}
