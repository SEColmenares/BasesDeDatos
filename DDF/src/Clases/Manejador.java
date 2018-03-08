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
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.List;
import java.awt.Point;
import java.util.Set;

/**
 *
 * @author jhon_quiceno
 */
public class Manejador {
 private Info _info;
 private Dibujador _paint;
 private int off=50;
 private Operador _operador;
 
 public Manejador(){
     
    _paint = new Dibujador();
    _operador = new Operador();
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
           Point IniCante = new Point(dep.getPosicion()[0],dep.getPosicion()[1]);
           Point IniCado = new Point(dep.getPosicion()[2],dep.getPosicion()[3]);                  
           if(!_paint.content(IniCante))IniCante=_paint.UltimaPosicion();
           if(!_paint.content(IniCado)){
               IniCado.x=IniCante.x+200;
               IniCado.y=IniCante.y+off;
               IniCante.y+=off;
           }
           off+=50;
           dep.setPosicion(new int[]{IniCante.x,IniCante.y,IniCado.x,IniCado.y});                  
           for(String et : dep.getFigCante().getEtiquetas().keySet()){                         
           if(_paint.ContienAtributo(et)){   
             if(dep.getFigCante().getEtiquetas().keySet().size()==1){
                 Point pt = _paint.getPuntoEtiqueta(et);
                 dep.setPosicionImplicante(new Point(pt.x-20,pt.y-15));
             }
             else{
                _paint.AgregarFlechaAetiqueta(new Point[]{dep.getFigCante().getEtiquetas().get(et),_paint.getPuntoEtiqueta(et)});
             }
           }
           else{
            _paint.AgregarEtiqueta(et, dep.getFigCante().getEtiquetas().get(et)); 
           } 
           }
           for(String et : dep.getFigCado().getEtiquetas().keySet()){ 
             if(_paint.ContienAtributo(et)){   
             if(dep.getFigCado().getEtiquetas().keySet().size()==1){
                 Point pt = _paint.getPuntoEtiqueta(et);
                 dep.setPosicionImplicado(new Point(pt.x-20,pt.y-15));
             }
             else{
                _paint.AgregarFlechaAetiqueta(new Point[]{dep.getFigCado().getEtiquetas().get(et),_paint.getPuntoEtiqueta(et)});
             }
           }
           else{
            _paint.AgregarEtiqueta(et, dep.getFigCado().getEtiquetas().get(et)); 
           } 
             
       }
           _paint.AgregarTemp(dep.getFigCado().getShape());
           _paint.AgregarTemp(dep.getFigCante().getShape());
           _paint.AgregarFlecha(dep.getFlecha()); 
           
       }
       
    }

    void CargarDependencias(List<Dependencias> dependencias) {
        
        _info = new Info((ArrayList<Dependencias>) dependencias);
    }
     public void setMarco(Rectangle marco)
  {
   _paint.setMarco(new Rectangle(marco.x+50,marco.y+50,marco.width-50,marco.height-50));
  }
     
     
     public void recubrimiento(){
     _operador.setAtributos(_info.getAtributos());
     _operador.setDependencias(_info.getDependencias());
     List<Dependencias> dp =_operador.CalcularRecubrimiento(); 
     _paint.ClearAll();
     _info.ClearDep();
     _info.addDep(dp);
     off=50;
     Apintar();
   }

    public List<String> CalcularClavesCandidatas() {
        _operador.setAtributos(_info.getAtributos());
        _operador.setDependencias(_info.getDependencias());
        List<String> dp =_operador.CalcularClavesCandidatas(); 
        return dp;
    }
    
    public String getDependenciasToString(){
        
        String dep = "";      
        for(Dependencias deps: _info.getDependencias() ){
            
            dep+=deps.getEtCante()+"->"+deps.getEtCado()+"\n";
        }
        return dep;
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
   
  public void ClearDep()
  {
     dependencias.clear();
  }
  public ArrayList<Dependencias> getDependencias() {
    return dependencias;
  }
 
  public void addDep(List<Dependencias> age) {
    dependencias.addAll(age);
  }
}
