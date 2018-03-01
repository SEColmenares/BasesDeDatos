/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


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
   _dep=dep;  
 }
 public void setAtributos(List<Atributo> atri){
   _atri=atri;
 }
 public List<Dependencias> CalcularRecubrimiento(){
   
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
    for(Dependencias dep : L){   
        _dep.remove(dep);      
        String cierredep=Cierre(dep.getEtCante());
        if(!cierredep.contains(dep.getEtCado()))_dep.add(dep);          
   }
    
    return new ArrayList<Dependencias>(_dep);
 }
 
 private List<Dependencias> DesTrivial(Dependencias dep){  
   int num = dep.getImplicados().size();
   int cont=0;
   List<Dependencias> arydep= new ArrayList<Dependencias>();
   for(Atributo at : dep.getImplicados()){
    List<Atributo> atlist= new ArrayList<Atributo>();
    atlist.add(at);
    arydep.add(new Dependencias(dep.getImplicantes(),atlist,false));
    cont++;
   }
    return arydep; 
 }
 private String Cierre(String at){
     ///calcular bien  el cierre
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
    return cierre;
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
   boolean parar =true;
 
 if(num>1)
 {
   for(int i=0;i<num;i++)
   {
    List<String> atCierre = ACalcular(etCante, num-i);  
    for(String at : atCierre){
     if(!cierres.containsKey(at)){
      cierres.put(at,Cierre(at));
     } 
     if(cierres.get(at).contains(dep.getEtCado())){
      // en aborrar va el atributo extraño pero me mame jjaja
      String aborra=dep.getEtCante().replaceAll(at,"");
       dep.DltCante(aborra);
       parar=false;
       etCante=dep.getEtCante().toCharArray();
       num =dep.getImplicantes().size()-1;
       i=0;
     }   
    }  
    if(parar)break;
    parar=true;
   }
   
 }
 if(num<2){
  // este for es cuando solo hay dos atributos en implicantes
    for(Atributo at : dep.getImplicantes()){
              
     if(!cierres.containsKey(at.getEtiqueta())){
      cierres.put(at.getEtiqueta(),Cierre(at.getEtiqueta()));
      }
     if(cierres.get(at.getEtiqueta()).contains(dep.getEtCado())){
           dep.DltCante(at.getEtiqueta());
     }           
     }
  }
     
 }

    
}
