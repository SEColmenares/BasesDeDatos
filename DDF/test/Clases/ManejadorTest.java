/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Rectangle;
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
public class ManejadorTest {
    
    public ManejadorTest() {
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
     * Test of getPaint method, of class Manejador.
     */
    @Test
    public void testGetPaint() {
        System.out.println("getPaint");
        Manejador instance = new Manejador();
        Dibujador expResult = null;
        Dibujador result = instance.getPaint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Cargar method, of class Manejador.
     */
    @Test
    public void testCargar() {
        System.out.println("Cargar");
        String jsonString = "";
        Manejador instance = new Manejador();
        instance.Cargar(jsonString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Exportar method, of class Manejador.
     */
    @Test
    public void testExportar() {
        System.out.println("Exportar");
        Manejador instance = new Manejador();
        instance.Exportar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Apintar method, of class Manejador.
     */
    @Test
    public void testApintar() {
        System.out.println("Apintar");
        Manejador instance = new Manejador();
        instance.Apintar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CargarDependencias method, of class Manejador.
     */
    @Test
    public void testCargarDependencias() {
        System.out.println("CargarDependencias");
        List<Dependencias> dependencias = null;
        Manejador instance = new Manejador();
        instance.CargarDependencias(dependencias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarco method, of class Manejador.
     */
    @Test
    public void testSetMarco() {
        System.out.println("setMarco");
        Rectangle marco = null;
        Manejador instance = new Manejador();
        instance.setMarco(marco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recubrimiento method, of class Manejador.
     */
    @Test
    public void testRecubrimiento() {
        System.out.println("recubrimiento");
        Manejador instance = new Manejador();
        instance.recubrimiento();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcularClavesCandidatas method, of class Manejador.
     */
    @Test
    public void testCalcularClavesCandidatas() {
        System.out.println("CalcularClavesCandidatas");
        Manejador instance = new Manejador();
        List<String> expResult = null;
        List<String> result = instance.CalcularClavesCandidatas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDependenciasToString method, of class Manejador.
     */
    @Test
    public void testGetDependenciasToString() {
        System.out.println("getDependenciasToString");
        Manejador instance = new Manejador();
        String expResult = "";
        String result = instance.getDependenciasToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
