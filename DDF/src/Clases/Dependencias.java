/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Point;
/**
 *
 * @author jhon_quiceno
 */
public class Dependencias {
    
    char[] _implicantes;
    char[] _implicados;
    boolean _EsTrivial;
    int[] _posicion={0,0};
    
    public Dependencias(char[] implicantes , char[] implicados, boolean EStrivial)
    {
        _implicantes=implicantes;
        _implicados=implicados;
        _EsTrivial=EStrivial;
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
        private Shape _figura;
        private Color _color;
        private String _Label;
        private Point _posicion;

        public FiguraAtributo(char[]dato,int[] posicion) {
            super();         
          _posicion = new Point(posicion[0], posicion[1]);         
        }
             
        public Shape getShape() {
            return _figura;
        }

        public void setShape(Shape shape) {
            this._figura = shape;
        }

        public Color getColor() {
            return _color;
        }

        public void setColor(Color color) {
            this._color = color;
        }
    }