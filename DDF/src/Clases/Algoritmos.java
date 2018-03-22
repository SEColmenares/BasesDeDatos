/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Tes America
 */

public class Algoritmos {
    
    ArrayList<Atributo> _atributo;
    ArrayList<Dependencias>_dep;
    Relacion _1FN;
    ArrayList<Relacion> _2FN;
    Operador _operador;

    public Algoritmos(ArrayList<Atributo> _atributo, ArrayList<Dependencias>_dep) {
        _1FN = new Relacion(_dep,_atributo);
        CalcularClaveR(_1FN);
    }
    
    ArrayList<Relacion> Calcular2FN(){
        
      _2FN = new ArrayList<>();
      _2FN.add(_1FN);
      Iterator<Relacion> iteradorR = _2FN.iterator();
      while(iteradorR.hasNext()){
          Relacion RT= iteradorR.next();
          if(RT.getFormaNormal().equals("2FN"))continue;
          for(int i =0; i<RT.getDependencias().size();i++){                  
              if(EsParcial(RT.getDependencias().get(i), RT.getLlave()))
              {
                  ArrayList<Dependencias> dp = new ArrayList<>();
                  dp.add(RT.getDependencias().get(i));
                  Relacion rdp =new Relacion(dp);
                  CalcularClaveR(rdp);
                  rdp.setFormaNormal("2FN");
                  rdp.setNombreR( RT.getNombreR()+(i+1) );
                  _2FN.add(rdp);
                  ArrayList<Dependencias> dp2 = new ArrayList<>();
                  dp2.addAll(RT.getDependencias());
                  dp2.remove(i);
                  Relacion rdp2 =new Relacion(dp2);
                  CalcularClaveR(rdp2);
                  rdp2.setNombreR( RT.getNombreR()+(i+2) );
                  _2FN.add(rdp2);
                  _2FN.remove(RT);
                  iteradorR = _2FN.iterator();
                  break;
              } 
              RT.setFormaNormal("2FN");
          }  
      }
      return new ArrayList<>(_2FN) ;
    }
    
    void CalcularProyeccion(ArrayList proy){
     
        ArrayList G = CalcularRM();
        ArrayList W = new ArrayList(_atributo);
        W.removeAll(proy);
        Iterator<Atributo> itW = W.iterator();
        while(itW.hasNext()){
            Atributo at = itW.next();
            W.remove(at);
            
        }
        
    }
    ArrayList CalcularRM(){
        _operador = new Operador();
        _operador.setAtributos(_atributo);
        _operador.setDependencias(_dep);
        return _operador.CalcularRecubrimiento("");
    }
    void CalcularClaveR(Relacion R){
        _operador = new Operador();
        _operador.setAtributos(R.getAtributos());
        _operador.setDependencias(R.getDependencias());
        List<String> claves =_operador.CalcularClavesCandidatas();
        R.setLlave(claves.toArray(new String[claves.size()]));             
    }
    boolean EsParcial(Dependencias dep , String[] Keys){
        
        for(String key :Keys){           
          if(containsAny(key, dep.getEtCante().toCharArray()))return true;  
        }
      return false;  
    }
    
       public static boolean containsAny(String str, char[] searchChars) {
      int cont=0;
      if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
          return false;
      }
      for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          for (int j = 0; j < searchChars.length; j++) {
              if (searchChars[j] == ch) {
                  cont++;
              }
          }
      }
      if(cont==searchChars.length && cont!= str.length())return true;
      else return false;
  }

    ArrayList Calcular3FN() {

        ArrayList<Relacion> _3FN = new ArrayList<>();
        _3FN.add(_1FN);
        Iterator<Relacion> iteradorR = _2FN.iterator();
        while(iteradorR.hasNext()){
            Relacion RT = iteradorR.next();
            
            // primero se evalua que la relación este en segunda formal
            
            if(RT.getFormaNormal().equals("2FN"))continue;
            
            // luego se debe validar que no contenga dependencias transitivas excepto por superclave
            
            for(int i =0; i<RT.getDependencias().size();i++){
                if(EsParcial(RT.getDependencias().get(i), RT.getLlave()))
                {
                    
                  ArrayList<Dependencias> dp = new ArrayList<>();
                  dp.add(RT.getDependencias().get(i));
                  Relacion rdp =new Relacion(dp);
                  CalcularClaveR(rdp);
                  rdp.setFormaNormal("2FN");
                  rdp.setNombreR( RT.getNombreR()+(i+1) );
                  _2FN.add(rdp);
                  ArrayList<Dependencias> dp2 = new ArrayList<>();
                  dp2.addAll(RT.getDependencias());
                  dp2.remove(i);
                  Relacion rdp2 =new Relacion(dp2);
                  CalcularClaveR(rdp2);
                  rdp2.setNombreR( RT.getNombreR()+(i+2) );
                  _2FN.add(rdp2);
                  _2FN.remove(RT);
                  iteradorR = _2FN.iterator();
                  break;
              } 
              RT.setFormaNormal("2FN");
          }  
      }
      return new ArrayList<>(_2FN) ;
    }
       
    
}