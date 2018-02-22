/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author jhon_quiceno
 */
public class Manejador {
 private Info _info;
 private Dibujador _paint;
 
 public Manejador(){
    _paint = new Dibujador();
}
 
 public Dibujador getPaint(){
     return _paint;
 }
 public void Cargar(String jsonString)
 {   
      try{
            Gson gson = new Gson();                
            _info  = gson.fromJson(jsonString, Info.class);                
        }catch(JsonSyntaxException e){
            System.err.println("JsonSyntaxException: " + e.getMessage());
        }   
 } 
 
 
 public void Exportar()
 {
     List<Atributo> atributos = new ArrayList<Atributo>();
     atributos.add( new Atributo("Avion", "A"));
     atributos.add( new Atributo("Bebe", "B"));
     atributos.add( new Atributo("Casa", "C"));
     atributos.add( new Atributo("Dedo", "D"));
     atributos.add( new Atributo("Etiqueta", "E"));
     atributos.add( new Atributo("Fabula", "F"));
     List<Atributo> unoo =new ArrayList<Atributo>();
     unoo.add( new Atributo("Avion", "A"));
     List<Atributo> unos =new ArrayList<Atributo>();
     unos.add( new Atributo("Bebe", "B"));
     unos.add( new Atributo("Casa", "C"));
     Dependencias uno = new Dependencias(unoo,unos, false);
     Dependencias dos = new Dependencias(unoo,unos, false);
     Dependencias tres = new Dependencias(unoo,unos, false);
     ArrayList<Dependencias> dep = new ArrayList<>();
     dep.add(uno);
     dep.add(dos);
     dep.add(tres);
     _info = new Info(atributos, dep);
      Gson gson = new GsonBuilder().setPrettyPrinting().create();

      String jsonEjemplo = gson.toJson(_info);
 }
 
    public void Apintar(){
       for(Dependencias dep :_info.getDependencias()){
           dep.GenerarFigura();
           _paint.AgregarRangoFigura(dep.getFigCado().getShape());
           _paint.AgregarRangoFigura(dep.getFigCante().getShape());
       }  
       
    }

    void CargarDependencias(List<Dependencias> dependencias) {
        
        _info = new Info((ArrayList<Dependencias>) dependencias);
    }
    
}


  class Info {
  private List<Atributo> atributos;
  private ArrayList<Dependencias> dependencias;
  
  public Info(List<Atributo> atri,ArrayList<Dependencias> dep )
  {
   atributos = atri;
   dependencias = dep;
  };
  
  public Info(ArrayList<Dependencias> dep )
  {
      dependencias = dep;
  };
  
  public List<Atributo> getAtributos() {
    return atributos;
  }

  public void setAtributos(List<Atributo> atri) {
    this.atributos = atri;
  }
 
  public ArrayList<Dependencias> getDependencias() {
    return dependencias;
  }
 
  public void setDependencias(ArrayList<Dependencias> age) {
    this.dependencias = dependencias;
  }
}
