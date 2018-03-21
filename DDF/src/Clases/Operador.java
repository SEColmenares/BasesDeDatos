/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author u1401
 */
public class Operador {
    
 private List<Atributo> _atri;
 private List<Dependencias> _dep;
 
 public Operador(){
  _atri = new ArrayList<Atributo>();
  _dep = new ArrayList<Dependencias>();
}
 public void setDependencias( List<Dependencias> dep){
    _dep.clear();
   _dep.addAll(dep);  
 }
 public void setAtributos(List<Atributo> atri){
    _atri.clear();
   _atri.addAll(atri);
 }
 public ArrayList CalcularRecubrimiento(String dt){
    
   List<Dependencias> L =new ArrayList<Dependencias>();
   HashMap<String,String> cierres = new HashMap<String,String>();
   String da ="";
   
   for(Dependencias dep : _dep){    
   if(dep.getImplicados().size()>1) L.addAll(DesTrivial(dep));
   else L.add(dep);       
   } 
   _dep.clear();
   _dep.addAll(L);
   L.clear();
     SetInfo(da, "L0");
   for(Dependencias dep : _dep){
   if(dep.getImplicantes().size()<=1){
    L.add(dep);
    continue;
   }   
    DltAtextraños(dep, cierres);
    L.add(dep); 
   }
   
   _dep.clear();
   _dep.addAll(L);
    SetInfo(da, "L1");
    for(Dependencias dep : L){   
        _dep.remove(dep);      
        String cierredep=Cierre(dep.getEtCante());
        if(!cierredep.contains(dep.getEtCado()))_dep.add(dep);          
   }
    SetInfo(da, "L2");
    return new ArrayList<>(_dep);
 }
 private void SetInfo(String da, String ps){
      da += ps+"={";      
   for(Dependencias deps: _dep ){
            
            da+=deps.getEtCante()+"->"+deps.getEtCado()+";";
   }
   da+="}\n";
 }
 
 private List<Dependencias> DesTrivial(Dependencias dep){  
   int num = dep.getImplicados().size();
   int cont=0;
   List<Dependencias> arydep= new ArrayList<Dependencias>();
   for(Atributo at : dep.getImplicados()){
    List<Atributo> atlist= new ArrayList<Atributo>();
    List<Atributo> implic= new ArrayList<Atributo>();
    atlist.add(at);
    implic.addAll(dep.getImplicantes());
    arydep.add(new Dependencias(implic,atlist,false));
    cont++;
   }
    return arydep; 
 }
 private String Cierre(String at){
    
    ///calcular bien el cierre
    String cierre = at;    
    boolean cambio=false;
    while(!cambio)
    {
        cambio=true;
        for(Dependencias dep : _dep){
            if(containsAny(cierre,dep.getEtCante().toCharArray())&&!cierre.contains(dep.getEtCado()))
            {
                cierre+=dep.getEtCado();
                cambio =false;
            }
        }    
    }
    
    // agrego esto para que el cierre salga ordenado bien bonito
    
    char[] chars = cierre.toCharArray();
    Arrays.sort(chars);
    String cierreOrdenado = new String(chars);
    
    return cierreOrdenado;
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
      if(cont==searchChars.length)return true;
      else return false;
  }
 private List<String> ACalcular(char[] input, int k){
  List<String> subsets = new ArrayList<>();
  int[] s = new int[k];
  
  if(k<= input.length){
   for(int i =0;(s[i]=i)<k-1;i++);
   subsets.add(getSubset(input, s));
   for(;;){
       int i;
       for(i=k-1;i>=0&& s[i]==input.length-k +i ;i--);
       if(i<0){
         break;  
       }
       s[i]++;
       for(++i ; i<k;i++){
           s[i]=s[i-1]+1;
       }
       subsets.add(getSubset(input,s));
   }
  }
  return subsets;   
 }
 
 public String getSubset(char[] input, int[] subset){
     String result = "";
     for(int i=0;i < subset.length;i++)
         result += input[subset[i]];
     return result;
 }
 public void DltAtextraños(Dependencias dep, HashMap<String,String> cierres){
      // este for es cuando hay mas de dos atributos
   int num =dep.getImplicantes().size()-1;
   char[] etCante=dep.getEtCante().toCharArray();
 
 if(num>1)
 {  
   for(int i=0;i<num;i++)
   {
    if(num<=1)break;
    List<String> atCierre = ACalcular(etCante, i+1);  
    for(String at : atCierre){
     if(!cierres.containsKey(at)){
      cierres.put(at,Cierre(at));
     } 
     if(cierres.get(at).contains(dep.getEtCado())){
      // en aborrar va el atributo extraño pero me mame jjaja
      String aborra=dep.getEtCante().replaceAll(at,"");
      if(aborra.length()>1){
        for(char ath :aborra.toCharArray()){
          dep.DltCante(String.valueOf(ath));
          cierres.clear();
        }       
      }
      else{
          dep.DltCante(aborra);
          cierres.clear();
      }
       etCante=dep.getEtCante().toCharArray();
       num =dep.getImplicantes().size()-1;
       i=0;
       break;
     }   
    }  
   }
   
 }
 if(num<2){
  // este for es cuando solo hay dos atributos en implicantes
  
    for(int i =0; i<dep.getImplicantes().size();i++ ){
         dlt2(dep.getImplicantes().get(i).getEtiqueta(), dep, cierres);
     }
  }
     
 }
 public void dlt2(String at , Dependencias dep,HashMap<String,String> cierres  ){
            
     
     if(!cierres.containsKey(at)){
      cierres.put(at,Cierre(at));
      }
     if(cierres.get(at).contains(dep.getEtCado())){
           dep.DltCante(dep.getEtCante().replace(at, ""));
           cierres.clear();
     }  
 }
 
  // metodo para el calculo de las claves del conjunto de dependencias.

    public List<String> CalcularClavesCandidatas(){
        
        List<String> clavesCantidatas = new ArrayList<>();
        List<String> clavesUtilizadas = new ArrayList();
        List<Atributo> atributos = _atri;
        List<Dependencias> dependencias = _dep;
        List<String> listaAtributosString = new ArrayList<>();        
        
        // Primero genero el conjunto T    
        
        for(Atributo atributo : atributos){
            listaAtributosString.add(atributo.getEtiqueta());
        }          
        java.util.Collections.sort(listaAtributosString);  
        
        List<String> T = new ArrayList(listaAtributosString);
        String stringConjuntoAtributos = String.join("", T);         
        
        // Primero genero el conjunto Y de todos los atributos a derecha        
        List<String> Y = ExtraerAtributosADerecha(dependencias);
        
        // se genera el conjunto Z = T-UY     
        List<String> Z = CompararListas(T,Y);
        
        String cierre = Cierre(String.join("", Z));       
        // se calcula el cierre de esta lista y se mira si es necesario continuar       
        
        if (cierre.trim().equals(stringConjuntoAtributos.trim()))
        {
            clavesCantidatas.add(String.join("", Z));
            return clavesCantidatas;
        }
        else
        {
            List<String> Vs = new ArrayList();
            
            // se calcula el conjunto de atributos precindibles
            List<String> X = ExtraerAtributosAIzquierda(dependencias);
            
            // se calculoa el conjunto W
            List<String> W = CompararListas(T, X);
            
            // se arman los conjuntos en base a lo obtenido, cantidad de atributos que se van a cosiderar de V
            List<String> V = CompararListas(T,W);      
            
            String cierreZString = Cierre(String.join("", Z));
            List<String> cierreZ = Arrays.asList(cierreZString.split(","));
            
            // se generan todas las posibles combinaciones de
            

            String str=V.toString().replaceAll(",", "");
            char[] Vchar = str.substring(1, str.length()-1).replaceAll(" ", "").toCharArray();          
            for (int k = 1; k <= V.size(); k++) {
                Vs.addAll(ACalcular(Vchar, k));
            }
            
            for (int i = 0; i < Vs.size(); i++) {
                
                // incluyo el primer atributo a Z            
                List<String> A = new ArrayList(cierreZ);
                A.add(Vs.get(i));
                java.util.Collections.sort(A);
                String clave = String.join("", A);
                
                if (!clavesUtilizadas.contains(clave))
                {
                    String cierreParcial =  Cierre(clave);               
                    if (stringConjuntoAtributos.trim().equals(cierreParcial.trim()))
                    {
                        // si la clave genera todo el conjunto de atributos se agrega a la lista de claves candidatas.
                        if (!EsSuperClave(clave,clavesCantidatas))
                        {
                            clavesCantidatas.add(clave);
                        }
                        clavesUtilizadas.add(clave);                   
                    }
                    else
                    {
                        // sino se agrega a la lista de claves utilizadas
                        clavesUtilizadas.add(clave);                       
                    }
                }
            }     
            return clavesCantidatas;
        }
    }


    private List<String> ExtraerAtributosADerecha(List<Dependencias> dependencias) {
        
        List<String> implicantes = new ArrayList<>();
        List<Atributo> listaAtributos = new ArrayList<>();
        
        for(Dependencias dep : dependencias){  
            
            listaAtributos = dep.getImplicados();
            for(Atributo atributo : listaAtributos){
                if (!implicantes.contains(atributo)){
                    implicantes.add(atributo.getEtiqueta());
                }
            }            
        }
        
        // ordeno los implicantes
        
        java.util.Collections.sort(implicantes);      
        // implicantesString = String.join("", implicantes);
        // return implicantesString;
        
        return implicantes;
    }
    
    private List<String> ExtraerAtributosAIzquierda(List<Dependencias> dependencias) {
        
        List<String> implicantes = new ArrayList<>();
        List<Atributo> listaAtributos = new ArrayList<>();
        
        for(Dependencias dep : dependencias){  
            
            listaAtributos = dep.getImplicantes();
            for(Atributo atributo : listaAtributos){
                if (!implicantes.contains(atributo.getEtiqueta())){
                    implicantes.add(atributo.getEtiqueta());
                }
            }            
        }
        
        java.util.Collections.sort(implicantes);  
        
        return implicantes;
    }
    
    private List<String> CompararListas(List<String> a, List<String> b) {
    List<String> resultado = new ArrayList<String>(a);
    for (String element : b) {
        // .add() returns false if element already exists
        if (resultado.contains(element)) {
            resultado.remove(element);
        }
    }
    java.util.Collections.sort(resultado);
    return resultado;
}

    private boolean EsSuperClave(String posibleClaveCandidata, List<String> clavesCantidatas) {
        
        boolean esSuperClave = false;
        
        for (String claveCandidata : clavesCantidatas) {
            if (containsAny(posibleClaveCandidata, claveCandidata.toCharArray())) {
                esSuperClave = true;
            }
        }
        
        return esSuperClave;
    }
         
    
}
