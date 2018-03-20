/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
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
public class InfoTest {
    
    public InfoTest() {
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
     * Test of getAtributos method, of class Info.
     */
    @Test
    public void testGetAtributos() {
        System.out.println("getAtributos");
        Info instance = null;
        List<Atributo> expResult = null;
        List<Atributo> result = instance.getAtributos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtributos method, of class Info.
     */
    @Test
    public void testSetAtributos() {
        System.out.println("setAtributos");
        List<Atributo> atri = null;
        Info instance = null;
        instance.setAtributos(atri);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ClearDep method, of class Info.
     */
    @Test
    public void testClearDep() {
        System.out.println("ClearDep");
        Info instance = null;
        instance.ClearDep();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDependencias method, of class Info.
     */
    @Test
    public void testGetDependencias() {
        System.out.println("getDependencias");
        Info instance = null;
        ArrayList<Dependencias> expResult = null;
        ArrayList<Dependencias> result = instance.getDependencias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDep method, of class Info.
     */
    @Test
    public void testAddDep() {
        System.out.println("addDep");
        List<Dependencias> age = null;
        Info instance = null;
        instance.addDep(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
