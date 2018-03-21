/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cyber Dragon
 */
public class LectorDependeciasTest {
    
    public LectorDependeciasTest() {
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
     * Test of LeerDependencias method, of class LectorDependecias.
     */
    @Test
    public void testLeerDependencias() {
        System.out.println("LeerDependencias");
        String texto = "";
        LectorDependecias instance = new LectorDependecias();
        List<Dependencias> expResult = null;
        List<Dependencias> result = instance.LeerDependencias(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
