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
 * @author Tes America
 */
public class Relacion {
    
      private ArrayList<Atributo> _atributos;

     private String _formaNormal="1FN";

     /**
      * Get the value of _formaNormal
      *
      * @return the value of _formaNormal
      */
     public String getFormaNormal() {
         return _formaNormal;
     }

     /**
      * Set the value of _formaNormal
      *
      * @param _formaNormal new value of _formaNormal
      */
     public void setFormaNormal(String _formaNormal) {
         this._formaNormal = _formaNormal;
     }

    public Relacion( ArrayList<Dependencias> _dependencias) {
        this._dependencias = _dependencias;
        _atributos = new  ArrayList<Atributo>();
          for(Dependencias de :_dependencias){
          addatri(de.getImplicantes());
          addatri(de.getImplicados());
      } 
    }
    public Relacion(ArrayList<Dependencias> _dependencias,ArrayList<Atributo> _atributos){
       this._dependencias = _dependencias;
       this._atributos = _atributos;
    }

     private String _nombreR ="R";

     /**
      * Get the value of _nombreR
      *
      * @return the value of _nombreR
      */
     public String getNombreR() {
         return _nombreR;
     }

     /**
      * Set the value of _nombreR
      *
      * @param _nombreR new value of _nombreR
      */
     public void setNombreR(String _nombreR) {
         this._nombreR = _nombreR;
     }

     /**
      * Get the value of _atributos
      *
      * @return the value of _atributos
      */
     public ArrayList<Atributo> getAtributos() {
         return _atributos;
     }

     /**
      * Set the value of _atributos
      *
      * @param _atributos new value of _atributos
      */
     public void setAtributos(ArrayList<Atributo> _atributos) {
         this._atributos = _atributos;
     }
     
     private ArrayList<Dependencias> _dependencias;

     /**
      * Get the value of _dependencias
      *
      * @return the value of _dependencias
      */
     public ArrayList<Dependencias> getDependencias() {
         return _dependencias;
     }

     /**
      * Set the value of _dependencias
      *
      * @param _dependencias new value of _dependencias
      */
     public void setDependencias(ArrayList<Dependencias> _dependencias) {
         this._dependencias = _dependencias;
     }

     private String[] _llaves;

     /**
      * Get the value of _llave
      *
      * @return the value of _llave
      */
     public String[] getLlave() {
         return _llaves;
     }

     /**
      * Set the value of _llave
      *
      * @param _llave new value of _llave
      */
     public void setLlave(String[] _llave) {
         this._llaves = _llave;
     }
     
       public void addatri(List<Atributo> at){
      boolean cont = false;
      for(Atributo ath : at){
      for(Atributo att :_atributos){
          if(att.getEtiqueta().trim().equals(ath.getEtiqueta())){
              cont=true;
              break;
          }
      }
       if(!cont)_atributos.add(ath);
       cont = false;
      }
  }
    
    
}
