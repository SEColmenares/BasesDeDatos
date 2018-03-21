/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cyber Dragon
 */
public class LectorDependecias {
    
    LectorDependecias(){};

    //List<Atributo> listaAtributos = new ArrayList<>();
    
    List<Dependencias> LeerDependencias(String texto) {
        
        // listaAtributos = LeerListaAtributos(texto);
        
        List<Dependencias> listaDependencias = new ArrayList<>();
        
        // se separan las dependecias que se ingresen
        
        String[] dependenciasString = texto.split(";");
        
        for (int i = 0; i < dependenciasString.length; i++) {
            
            // para cada dependencia se leen los atributos
            
            String dependenciaString =  dependenciasString[i];
            String[] atributos = dependenciaString.split("->");
            
            List<Atributo> implicados = MapeartAtributos(atributos[0]);
            List<Atributo> implicantes = MapeartAtributos(atributos[1]);
            
            Dependencias dependecia = new Dependencias(implicados, implicantes, true);
            listaDependencias.add(dependecia);
        }
        
        return listaDependencias;
    }

    private List<Atributo> LeerListaAtributos(String texto) {
        
        List<Atributo> lista =  new ArrayList<>();
        String[] arr = texto.split("(?<!^)");
        for (int i = 0; i < arr.length; i++) {    
            
            lista.add(new Atributo(arr[i],arr[i]));            
        }
        
        return lista;        
    }

    private List<Atributo> MapeartAtributos(String atributos) {
    
        List<Atributo> listaAtributos = LeerListaAtributos(atributos);
        return listaAtributos;
    }
    
}
