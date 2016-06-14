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
public class ComboItemTest {
    
    public ComboItemTest() {
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
     * Test of getKey method, of class ComboItem.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        ComboItem instance = new ComboItem("1", "Samsung");
        String expResult = "1";
        String result = instance.getKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setKey method, of class ComboItem.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        ComboItem instance = new ComboItem();
        instance.setKey("1");
        assertEquals("1", instance.getKey());
    }

    /**
     * Test of getValue method, of class ComboItem.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        ComboItem instance = new ComboItem("arg1", "arg2");
        String expResult = "arg2";
        String result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class ComboItem.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        String value = "1";
        ComboItem instance = new ComboItem();
        instance.setValue(value);
        assertEquals(value, instance.getValue());
    }

    /**
     * Test of toString method, of class ComboItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComboItem instance = new ComboItem("arg1", "arg2");
        String expResult = "arg2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
