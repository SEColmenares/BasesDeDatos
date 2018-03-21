/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Point;
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
public class DependenciasTest {
    
    public DependenciasTest() {
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
     * Test of GenerarFigura method, of class Dependencias.
     */
    @Test
    public void testGenerarFigura() {
        System.out.println("GenerarFigura");
        Dependencias instance = null;
        instance.GenerarFigura();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImplicantes method, of class Dependencias.
     */
    @Test
    public void testSetImplicantes() {
        System.out.println("setImplicantes");
        List<Atributo> implicantes = null;
        Dependencias instance = null;
        instance.setImplicantes(implicantes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImplicantes method, of class Dependencias.
     */
    @Test
    public void testGetImplicantes() {
        System.out.println("getImplicantes");
        Dependencias instance = null;
        List<Atributo> expResult = null;
        List<Atributo> result = instance.getImplicantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImplicado method, of class Dependencias.
     */
    @Test
    public void testSetImplicado() {
        System.out.println("setImplicado");
        List<Atributo> implicados = null;
        Dependencias instance = null;
        instance.setImplicado(implicados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImplicados method, of class Dependencias.
     */
    @Test
    public void testGetImplicados() {
        System.out.println("getImplicados");
        Dependencias instance = null;
        List<Atributo> expResult = null;
        List<Atributo> result = instance.getImplicados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFigCante method, of class Dependencias.
     */
    @Test
    public void testGetFigCante() {
        System.out.println("getFigCante");
        Dependencias instance = null;
        FiguraConjunto expResult = null;
        FiguraConjunto result = instance.getFigCante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFigCado method, of class Dependencias.
     */
    @Test
    public void testGetFigCado() {
        System.out.println("getFigCado");
        Dependencias instance = null;
        FiguraConjunto expResult = null;
        FiguraConjunto result = instance.getFigCado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEsTrivial method, of class Dependencias.
     */
    @Test
    public void testSetEsTrivial() {
        System.out.println("setEsTrivial");
        boolean EsTrivial = false;
        Dependencias instance = null;
        instance.setEsTrivial(EsTrivial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstrivial method, of class Dependencias.
     */
    @Test
    public void testGetEstrivial() {
        System.out.println("getEstrivial");
        Dependencias instance = null;
        boolean expResult = false;
        boolean result = instance.getEstrivial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicion method, of class Dependencias.
     */
    @Test
    public void testSetPosicion() {
        System.out.println("setPosicion");
        int[] Posicion = null;
        Dependencias instance = null;
        instance.setPosicion(Posicion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicionImplicado method, of class Dependencias.
     */
    @Test
    public void testSetPosicionImplicado() {
        System.out.println("setPosicionImplicado");
        Point pt = null;
        Dependencias instance = null;
        instance.setPosicionImplicado(pt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicionImplicante method, of class Dependencias.
     */
    @Test
    public void testSetPosicionImplicante() {
        System.out.println("setPosicionImplicante");
        Point pt = null;
        Dependencias instance = null;
        instance.setPosicionImplicante(pt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInicio method, of class Dependencias.
     */
    @Test
    public void testSetInicio() {
        System.out.println("setInicio");
        Point ini = null;
        Dependencias instance = null;
        instance.setInicio(ini);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFin method, of class Dependencias.
     */
    @Test
    public void testSetFin() {
        System.out.println("setFin");
        Point fin = null;
        Dependencias instance = null;
        instance.setFin(fin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlecha method, of class Dependencias.
     */
    @Test
    public void testGetFlecha() {
        System.out.println("getFlecha");
        Dependencias instance = null;
        Point[] expResult = null;
        Point[] result = instance.getFlecha();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DltCante method, of class Dependencias.
     */
    @Test
    public void testDltCante() {
        System.out.println("DltCante");
        String et = "";
        Dependencias instance = null;
        instance.DltCante(et);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEtCado method, of class Dependencias.
     */
    @Test
    public void testGetEtCado() {
        System.out.println("getEtCado");
        Dependencias instance = null;
        String expResult = "";
        String result = instance.getEtCado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEtCante method, of class Dependencias.
     */
    @Test
    public void testGetEtCante() {
        System.out.println("getEtCante");
        Dependencias instance = null;
        String expResult = "";
        String result = instance.getEtCante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosicion method, of class Dependencias.
     */
    @Test
    public void testGetPosicion() {
        System.out.println("getPosicion");
        Dependencias instance = null;
        int[] expResult = null;
        int[] result = instance.getPosicion();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
