/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.HashMap;
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
public class OperadorTest {
    
    public OperadorTest() {
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
     * Test of setDependencias method, of class Operador.
     */
    @Test
    public void testSetDependencias() {
        System.out.println("setDependencias");
        List<Dependencias> dep = null;
        Operador instance = new Operador();
        instance.setDependencias(dep);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtributos method, of class Operador.
     */
    @Test
    public void testSetAtributos() {
        System.out.println("setAtributos");
        List<Atributo> atri = null;
        Operador instance = new Operador();
        instance.setAtributos(atri);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcularRecubrimiento method, of class Operador.
     */
    @Test
    public void testCalcularRecubrimiento() {
        System.out.println("CalcularRecubrimiento");
        Operador instance = new Operador();
        List<Dependencias> expResult = null;
        List<Dependencias> result = instance.CalcularRecubrimiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsAny method, of class Operador.
     */
    @Test
    public void testContainsAny() {
        System.out.println("containsAny");
        String str = "";
        char[] searchChars = null;
        boolean expResult = false;
        boolean result = Operador.containsAny(str, searchChars);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubset method, of class Operador.
     */
    @Test
    public void testGetSubset() {
        System.out.println("getSubset");
        char[] input = null;
        int[] subset = null;
        Operador instance = new Operador();
        String expResult = "";
        String result = instance.getSubset(input, subset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DltAtextraños method, of class Operador.
     */
    @Test
    public void testDltAtextraños() {
        System.out.println("DltAtextra\u00f1os");
        Dependencias dep = null;
        HashMap<String, String> cierres = null;
        Operador instance = new Operador();
        instance.DltAtextraños(dep, cierres);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcularClavesCandidatas method, of class Operador.
     */
    @Test
    public void testCalcularClavesCandidatas() {
        System.out.println("CalcularClavesCandidatas");
        Operador instance = new Operador();
        List<String> expResult = null;
        List<String> result = instance.CalcularClavesCandidatas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
