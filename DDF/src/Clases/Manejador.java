/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 *
 * @author jhon_quiceno
 */
public class Manejador {
 private Info _info;
 Serializador _ser;
 
 public void Cargar()
 {
     String jsonString="";
      try{
            Gson gson = new Gson();                
            _info  = gson.fromJson(jsonString, Info.class);                
        }catch(JsonSyntaxException e){
            System.err.println("JsonSyntaxException: " + e.getMessage());
        }   
 } 
    
    
}


  class Info {
  private ArrayList<Atributos> Atributos;
  private ArrayList<Dependencias> Dependencias;
  
  public Info(){};
  
  public ArrayList<Atributos> getAtributos() {
    return Atributos;
  }

  public void setAtributos(ArrayList<Atributos> name) {
    this.Atributos = Atributos;
  }
 
  public ArrayList<Dependencias> getDependencias() {
    return Dependencias;
  }
 
  public void setDependencias(ArrayList<Dependencias> age) {
    this.Dependencias = Dependencias;
  }
}
