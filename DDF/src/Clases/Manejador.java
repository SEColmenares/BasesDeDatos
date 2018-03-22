/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.awt.Rectangle;
import java.util.List;
import java.awt.Point;
import java.awt.Event;
import java.util.HashMap;
import java.util.ListIterator;

/**
 *
 * @author jhon_quiceno
 */

public class Manejador {
 private Info _info;
 private Dibujador _paint;
 private int off=50;
 private Operador _operador;
 public  Event _set;
 private HashMap<String,ArrayList>_relaciones;
 private static IEventHandler _event;
 
 public Manejador( Dibujador paint){
     
    _paint = paint;
    _operador = new Operador();
    _relaciones = new HashMap<>();
}
 
 public Dibujador getPaint(){
     return _paint;
 }
 
 public void setEvento(IEventHandler ev){
   _event = ev;
 }
 private void triggerText(String imprimir){
     (_event).onChange(imprimir);
 }
 public void Cargar(String jsonString)
 {   
      try{
            Gson gson = new Gson(); 
            java.lang.reflect.Type fooType = new TypeToken<Info>() {}.getType(); 
            _info  = gson.fromJson(jsonString, fooType);                
        }catch(JsonSyntaxException e){
            System.err.println("JsonSyntaxException: " + e.getMessage());
        }   
 } 
 
 
 public String Exportar()
 {
       Gson gson = new Gson();
     java.lang.reflect.Type fooType = new TypeToken<Info>() {}.getType();  
      String jsonEjemplo =  gson.toJson(getInfo(), fooType);
      return jsonEjemplo;
 }
 
    public void Apintar(){
       off=50;
        _paint.ClearAll();
       for(Dependencias dep :getInfo().getDependencias()){
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
        
        
        if(getInfo()==null)_info = new Info((ArrayList<Dependencias>) dependencias);
        else{
            for(Dependencias de :dependencias){
                getInfo().addatri(de.getImplicantes());
                getInfo().addatri(de.getImplicados());               
            }
            getInfo().addDep(dependencias);
        }
            
            
    }
     public void setMarco(Rectangle marco)
  {
   _paint.setMarco(new Rectangle(marco.x+50,marco.y+50,marco.width-50,marco.height-50));
  }
     
     
     public void recubrimiento(){
        String dt ="";
     _operador.setAtributos(getInfo().getAtributos());
     _operador.setDependencias(getInfo().getDependencias());
     List<Dependencias> dp =_operador.CalcularRecubrimiento(dt); 
     _paint.ClearAll();
        getInfo().ClearDp();
        getInfo().addDep(dp);
     
     off=50;
     Apintar();
   }
     public void clear (){
         getInfo().ClearAt();
         getInfo().ClearDp();
         _paint.ClearAll();
         off=50;
     }
    public List<String> CalcularClavesCandidatas() {
        _operador.setAtributos(getInfo().getAtributos());
        _operador.setDependencias(getInfo().getDependencias());
        List<String> dp =_operador.CalcularClavesCandidatas(); 
        return dp;
    }
    public void calcular2FN(){
        String aImprimir="2 Forma Normal \n";
        Algoritmos alg = new Algoritmos(getInfo().getAtributos(), getInfo().getDependencias());
        _relaciones.put("2FN", alg.Calcular2FN());
        ListIterator li = _relaciones.get("2FN").listIterator();
        while (li.hasNext()) {
            Relacion R =(Relacion)li.next();
            aImprimir += R.getNombreR() +"\n"+getDependenciasToString(R.getAtributos(),R.getDependencias())+"\n";            
        }
        triggerText(aImprimir);      
    }
    
    public String getDependenciasToString(){
        
        String dep = "L={";      
        for(Dependencias deps: getInfo().getDependencias() ){
            
            dep+=deps.getEtCante()+"->"+deps.getEtCado()+";";
        }
        dep+="}\nT={";
        for(Atributo at : getInfo().getAtributos()){
           dep+=at.getNombre()+"("+at.getEtiqueta()+");"; 
        }
        dep+="}";
        return dep;
        
    }
        public String getDependenciasToString(ArrayList<Atributo> att,ArrayList<Dependencias> depps ){
        
        String dep = "L={";      
        for(Dependencias deps: depps ){
            
            dep+=deps.getEtCante()+"->"+deps.getEtCado()+";";
        }
        dep+="}\nT={";
        for(Atributo at : att){
           dep+=at.getNombre()+"("+at.getEtiqueta()+");"; 
        }
        dep+="}";
        return dep;
        
    }

    /**
     * @return the _info
     */
    public Info getInfo() {
        return _info;
    }

    void calcular3FN() {
        String aImprimir="2 Forma Normal \n";
        Algoritmos alg = new Algoritmos(getInfo().getAtributos(), getInfo().getDependencias());
        _relaciones.put("3FN", alg.Calcular3FN());
        ListIterator li = _relaciones.get("3FN").listIterator();
        while (li.hasNext()) {
            Relacion R =(Relacion)li.next();
            aImprimir += R.getNombreR() +"\n"+getDependenciasToString(R.getAtributos(),R.getDependencias())+"\n";            
        }
        triggerText(aImprimir);   
    }
            
    
}


  class Info {
  private ArrayList<Atributo> atributos;
  private ArrayList<Dependencias> dependencias;
  
  public Info(ArrayList<Atributo> atri,ArrayList<Dependencias> dep )
  {
   atributos = atri;
   dependencias = dep;
  };
  
  public Info(ArrayList<Dependencias> dep )
  {
      dependencias = dep;
      atributos = new ArrayList<Atributo>();
      for(Dependencias de :dep){
          addatri(de.getImplicantes());
          addatri(de.getImplicados());
      }
  };
  
  public ArrayList<Atributo> getAtributos() {
    return atributos;
  }

  public void setAtributos(List<Atributo> atri) {
    this.atributos.addAll(atri);
  }
   
  public void ClearDp()
  {
     dependencias.clear();
  }
    public void ClearAt()
  {
     atributos.clear();
  }
  public ArrayList<Dependencias> getDependencias() {
    return dependencias;
  }
 
  public void addDep(List<Dependencias> age) {
    dependencias.addAll(age);
  }
  public void addatri(List<Atributo> at){
      boolean cont = false;
      for(Atributo ath : at){
      for(Atributo att :atributos){
          if(att.getEtiqueta().trim().equals(ath.getEtiqueta())){
              cont=true;
              break;
          }
      }
       if(!cont)atributos.add(ath);
       cont = false;
      }
  }
}
