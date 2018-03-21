/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Cyber Dragon
 */
public class Atributo {

    private final String nombre;
    private final String etiqueta;
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }
    
    public Atributo(String nombre, String etiqueta)
    {
        this.nombre = nombre;
        this.etiqueta = etiqueta;
    }

}
