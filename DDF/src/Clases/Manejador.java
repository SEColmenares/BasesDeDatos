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
import java.util.HashSet;

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
     char[] at ={'A','B','C','D','E','F',};
     Atributos att = new Atributos(at);
     char[] unoo ={'A'};
     char[] unos ={'B','C'};
     Dependencias uno = new Dependencias(unoo,unos, false);
     Dependencias dos = new Dependencias(unoo,unos, false);
     Dependencias tres = new Dependencias(unoo,unos, false);
     ArrayList<Dependencias> dep = new ArrayList<>();
     dep.add(uno);
     dep.add(dos);
     dep.add(tres);
     _info = new Info(att, dep);
      Gson gson = new GsonBuilder().setPrettyPrinting().create();

      String jsonEjemplo = gson.toJson(_info);
 }
 
    public void Apintar(){
       for(Dependencias dep :_info.getDependencias()){
           dep.GenerarFigura();
           _paint.AgregarRangoFigura(dep.implicado.getShape());
           _paint.AgregarRangoFigura(dep.implicante.getShape());
       }  
       
    }
    
}


  class Info {
  private Atributos atributos;
  private ArrayList<Dependencias> dependencias;
  
  public Info(Atributos atri,ArrayList<Dependencias> dep )
  {
   atributos = atri;
   dependencias = dep;
  };
  
  public Atributos getAtributos() {
    return atributos;
  }

  public void setAtributos(Atributos atri) {
    this.atributos = atri;
  }
 
  public ArrayList<Dependencias> getDependencias() {
    return dependencias;
  }
 
  public void setDependencias(ArrayList<Dependencias> age) {
    this.dependencias = dependencias;
  }
}
