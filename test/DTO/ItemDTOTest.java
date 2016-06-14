/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ItemDTOTest {
    
    public ItemDTOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class ItemDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ItemDTO instance = new ItemDTO();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class ItemDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        ItemDTO instance = new ItemDTO();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getProductId method, of class ItemDTO.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        ItemDTO instance = new ItemDTO();
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductId method, of class ItemDTO.
     */
    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        int productId = 1;
        ItemDTO instance = new ItemDTO();
        instance.setProductId(productId);
        assertEquals(productId, instance.getProductId());
    }

    /**
     * Test of getName method, of class ItemDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ItemDTO instance = new ItemDTO();
        instance.setName("TestName");
        String expResult = "TestName";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class ItemDTO.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Test Name";
        ItemDTO instance = new ItemDTO();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getDescription method, of class ItemDTO.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ItemDTO instance = new ItemDTO();
        instance.setDescription("Test Description");
        String expResult = "Test Description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class ItemDTO.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Description";
        ItemDTO instance = new ItemDTO();
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    /**
     * Test of getPrice method, of class ItemDTO.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        ItemDTO instance = new ItemDTO();
        instance.setPrice(20.50);
        Double expResult = 20.50;
        Double result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class ItemDTO.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        Double price = 10.50;
        ItemDTO instance = new ItemDTO();
        instance.setPrice(price);
        assertEquals(price, instance.getPrice());
    }

    /**
     * Test of getType method, of class ItemDTO.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        ItemDTO instance = new ItemDTO();
        instance.setType("Electronic");
        String expResult = "Electronic";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class ItemDTO.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "Other";
        ItemDTO instance = new ItemDTO();
        instance.setType(type);
        assertEquals(type, instance.getType());
    }

    /**
     * Test of getStatus method, of class ItemDTO.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ItemDTO instance = new ItemDTO();
        instance.setStatus("U");
        String expResult = "U";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class ItemDTO.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "P";
        ItemDTO instance = new ItemDTO();
        instance.setStatus(status);
        assertEquals(status, instance.getStatus());
    }

    /**
     * Test of getQuantity method, of class ItemDTO.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ItemDTO instance = new ItemDTO();
        instance.setQuantity(10);
        int expResult = 10;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuantity method, of class ItemDTO.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 5;
        ItemDTO instance = new ItemDTO();
        instance.setQuantity(quantity);
        assertEquals(quantity, instance.getQuantity());
    }

    /**
     * Test of getMaxQuantity method, of class ItemDTO.
     */
    @Test
    public void testGetMaxQuantity() {
        System.out.println("getMaxQuantity");
        ItemDTO instance = new ItemDTO();
        instance.setMaxQuantity(100);
        int expResult = 100;
        int result = instance.getMaxQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxQuantity method, of class ItemDTO.
     */
    @Test
    public void testSetMaxQuantity() {
        System.out.println("setMaxQuantity");
        int maxQuantity = 50;
        ItemDTO instance = new ItemDTO();
        instance.setMaxQuantity(maxQuantity);
        assertEquals(maxQuantity, instance.getMaxQuantity());
    }
    
}
