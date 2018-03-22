/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Cyber Dragon
 */
public class CreadorScripts {

    List<Atributo> atributos = new ArrayList<Atributo>();
    List<Dependencias> dependecias = new ArrayList<Dependencias>();
    
    public CreadorScripts(Info informacion) {
        atributos = informacion.getAtributos();
        dependecias = informacion.getDependencias();
    }

    StringBuilder CrearContenidoScripts() {
        
        // primero se crea la tabla inicial a partir de
        StringBuilder contenidoScript = new StringBuilder();
        
        contenidoScript.append("Create table TablaPrueba (");
        
        for (int i = 0; i < atributos.size(); i++) {
            if (i != atributos.size()-1)
            {
                contenidoScript.append(atributos.get(i).getNombre() + " NVARCHAR(max) " + ",");
            }
            else
            {
                contenidoScript.append(atributos.get(i).getNombre() + " NVARCHAR(max)" + ")");
            }
        }
        
        // se modelan las claves candidatas como indices?
        
        /*
        for (int i = 0; i < dependecias.size(); i++) {
            if (i != dependecias.size())
            {
                contenidoScript.append(dependecias.get(i) + " NVARCHAR(max) " + ",");
            }
            else
            {
                contenidoScript.append(dependecias.get(i) + " NVARCHAR(max)" + ")");
            }
        }
        */
        
        return contenidoScript;
    }  

    void CrearScript(StringBuilder contenidoScript) {
        
        FileWriter fw = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("/home/me/Documents"));
        chooser.setSelectedFile(new File("DependenciasFuncionales.sql"));
        chooser.setDialogTitle("Seleccione una carpeta para guardar el archivo");
        
        // chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);           
        
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                fw = new FileWriter(chooser.getSelectedFile());
                fw.write(contenidoScript.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    fw.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    
}
