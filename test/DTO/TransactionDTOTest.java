/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;
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
public class TransactionDTOTest {
    
    public TransactionDTOTest() {
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
     * Test of getItemId method, of class TransactionDTO.
     */
    @Test
    public void testGetItemId() {
        System.out.println("getItemId");
        TransactionDTO instance = new TransactionDTO();
        String expResult = "";
        String result = instance.getItemId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemId method, of class TransactionDTO.
     */
    @Test
    public void testSetItemId() {
        System.out.println("setItemId");
        String itemId = "";
        TransactionDTO instance = new TransactionDTO();
        instance.setItemId(itemId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductId method, of class TransactionDTO.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        TransactionDTO instance = new TransactionDTO();
        String expResult = "";
        String result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductId method, of class TransactionDTO.
     */
    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        String productId = "";
        TransactionDTO instance = new TransactionDTO();
        instance.setProductId(productId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class TransactionDTO.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        TransactionDTO instance = new TransactionDTO();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateString method, of class TransactionDTO.
     */
    @Test
    public void testGetDateString() {
        System.out.println("getDateString");
        TransactionDTO instance = new TransactionDTO();
        String expResult = "";
        String result = instance.getDateString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class TransactionDTO.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        TransactionDTO instance = new TransactionDTO();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of display method, of class TransactionDTO.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        TransactionDTO instance = new TransactionDTO();
        instance.display();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
