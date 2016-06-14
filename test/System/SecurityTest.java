/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

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
public class SecurityTest {
    
    public SecurityTest() {
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
     * Test of encrypt method, of class Security.
     */
    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        String input = "Hello Test";
        String expResult = "7+LnL5GemD3raczxRQ9hAw==";
        String result = Security.encrypt(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class Security.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        String input = "7+LnL5GemD3raczxRQ9hAw==";
        String expResult = "Hello Test";
        String result = Security.decrypt(input);
        assertEquals(expResult, result);
    }
    
}
