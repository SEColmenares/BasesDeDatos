/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author jhon_quiceno
 */
public class Dependencias {
    
    char[] _implicantes;
    char[] _implicados;
    boolean _EsTrivial;
    int[] _posicion={0,0};
    public FiguraAtributo implicado;
    public FiguraAtributo implicante;
    
    public Dependencias(char[] implicantes , char[] implicados, boolean EStrivial)
    {
        _implicantes=implicantes;
        _implicados=implicados;
        _EsTrivial=EStrivial;
        implicado = new FiguraAtributo(implicados,_posicion);
        implicante = new FiguraAtributo(implicantes,_posicion);
    }
    
    public void GenerarFigura(){
        implicado = new FiguraAtributo(_implicados,_posicion);
        implicante = new FiguraAtributo(_implicantes,_posicion);
    }
    
    public void setImplicantes(char[] implicantes){ _implicantes=implicantes;}
    public char[] getImplicantes(){ return _implicantes;}
    
    public void setImplicado(char[] implicados){ _implicados=implicados;}
    public char[] getImplicados(){ return _implicados;}
    
    public void setEsTrivial(boolean EsTrivial){ _EsTrivial=EsTrivial;}
    public boolean getEstrivial(){ return _EsTrivial;}
    
    public void setPosicion(int[] Posicion){ _posicion=Posicion;}
    public int[] getPosicion(){ return _posicion;}
       
}

 class FiguraAtributo {
        private List<Shape> _fig;
        private Color _color;
        private String _label="";
        private Point _posicion;
        private char[] _dato;
        
        public FiguraAtributo(char[]dato,int[] posicion) {
            super();         
          _dato=dato;
          _posicion = new Point(posicion[0], posicion[1]);  
          for(int i =0;i < dato.length;i++)_label+=dato[i];
          _fig=CrearShape(dato);
        }
        
       
        public List<Shape> getShape() {
            return _fig;
        }
        public Color getColor() {
            return _color;
        }
        public void setColor(Color color) {
            this._color = color;
        }
        
        public void SetPosition(Point pos){
            _posicion = pos;          
            _fig = CrearShape(_dato);
        }
        private List<Shape> CrearShape(char[]dato){
            
            _fig = new ArrayList<Shape>();
            for(int i =0;i<dato.length;i++){
                _fig.add(new Rectangle2D.Double(_posicion.x+i*2, _posicion.y, 50, 50));
            }
            if(_fig.size()>1)_fig.add(new Rectangle2D.Double(_posicion.x-2, _posicion.y, 70, 70));
            return _fig;
        }
    }