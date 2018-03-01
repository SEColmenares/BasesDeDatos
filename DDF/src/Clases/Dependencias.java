/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author jhon_quiceno
 */
public class Dependencias {
    
    private List<Atributo> _implicantes;
    private List<Atributo> _implicados;
    private boolean _EsTrivial;
    private int[] _posicion={0,0,0,0};
    private FiguraConjunto implicado;
    private FiguraConjunto implicante;
    private Point[] _vector;
    private String _etqImplicados="";
    private String _etqImplicante="";
    
    
    // sobrecarga con la clase atributo
    public Dependencias(List<Atributo> implicantes , List<Atributo> implicados, boolean EStrivial)
    {
        this._implicantes=implicantes;
        this._implicados=implicados;
        _EsTrivial=EStrivial;       
        GenerarFigura();
    }
    
    public void GenerarFigura(){
        _etqImplicados="";
        _etqImplicante="";
        implicado = new FiguraConjunto(_implicados,_posicion[2],_posicion[3]);
        implicante = new FiguraConjunto(_implicantes,_posicion[0],_posicion[1]);
        GenerarFlecha();
        _implicantes.forEach(item->_etqImplicante+=item.getEtiqueta());
        _implicados.forEach(item->_etqImplicados+=item.getEtiqueta());
    }
    private void GenerarFlecha(){
        Rectangle2D inicio = implicante.getShape().get(implicante.getShape().size()-1).getBounds2D();
        Rectangle2D fin = implicado.getShape().get(implicado.getShape().size()-1).getBounds2D();
        Point x = new Point((int)inicio.getMaxX(),(int)inicio.getCenterY());
        Point y = new Point((int)fin.getMinX(),(int)fin.getCenterY());
        _vector = new Point[] {x,y};
    }
    
    public void setImplicantes(List<Atributo> implicantes){ _implicantes=implicantes;}
    public List<Atributo> getImplicantes(){ return _implicantes;}
      
    public void setImplicado(List<Atributo> implicados){ _implicados=implicados;}
    public List<Atributo> getImplicados(){ return _implicados;}
    
    public FiguraConjunto getFigCante(){ return implicante;}
    public FiguraConjunto getFigCado(){ return implicado;}
       
    public void setEsTrivial(boolean EsTrivial){ _EsTrivial=EsTrivial;}
    public boolean getEstrivial(){ return _EsTrivial;}
    
    public void setPosicion(int[] Posicion){      
        _posicion=Posicion;
        implicante.SetPosition(new Point(Posicion[0],Posicion[1]));
        implicado.SetPosition(new Point(Posicion[2],Posicion[3]));
        GenerarFlecha();
    }
     public void setPosicionImplicado(Point pt){      
        _posicion[2]=pt.x;
        _posicion[3]=pt.y;
        implicado.SetPosition(pt);
        GenerarFlecha();
    }
    public void setPosicionImplicante(Point pt){      
        _posicion[0]=pt.x;
        _posicion[1]=pt.y;
        implicante.SetPosition(pt);
        GenerarFlecha();
    }
    public void setInicio(Point ini){
        _vector[0]=ini;
    }
    public void setFin(Point fin){
        _vector[1]=fin;
    }
    public Point[] getFlecha(){
        return _vector;
    }
        public void DltCante(String et){
       Atributo aborrar=null;
       _etqImplicante="";
       for(Atributo at: _implicantes){
           if(at.getEtiqueta().equals(et))
           {
               aborrar=at;
               continue;
           }
           _etqImplicante+=at.getEtiqueta();         
       }
       if(aborrar!=null)_implicantes.remove(aborrar);
    }
    public String getEtCado(){
     return _etqImplicados;   
    }
    public String getEtCante(){
     return _etqImplicante;   
    }
    public int[] getPosicion(){ return _posicion;}
       
}
