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
public class ProductDTOTest {
    
    public ProductDTOTest() {
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
     * Test of getId method, of class ProductDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ProductDTO instance = new ProductDTO();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class ProductDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ProductDTO instance = new ProductDTO();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class ProductDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ProductDTO instance = new ProductDTO();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class ProductDTO.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ProductDTO instance = new ProductDTO();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class ProductDTO.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ProductDTO instance = new ProductDTO();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class ProductDTO.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        ProductDTO instance = new ProductDTO();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class ProductDTO.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        ProductDTO instance = new ProductDTO();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class ProductDTO.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        ProductDTO instance = new ProductDTO();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class ProductDTO.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        ProductDTO instance = new ProductDTO();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class ProductDTO.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        ProductDTO instance = new ProductDTO();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of display method, of class ProductDTO.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        ProductDTO instance = new ProductDTO();
        instance.display();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
