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
    
    private List<Atributo> _implicantes;
    private List<Atributo> _implicados;
    private boolean _EsTrivial;
    private int[] _posicion={0,0,0,0};
    private FiguraAtributo implicado;
    private FiguraAtributo implicante;
    private Point[] _vector;
    
    
    // sobrecarga con la clase atributo
    public Dependencias(List<Atributo> implicantes , List<Atributo> implicados, boolean EStrivial)
    {
        this._implicantes=implicantes;
        this._implicados=implicados;
        _EsTrivial=EStrivial;       
        GenerarFigura();
    }
    
    public void GenerarFigura(){
        implicado = new FiguraAtributo(_implicados,_posicion[2],_posicion[3]);
        implicante = new FiguraAtributo(_implicantes,_posicion[0],_posicion[1]);
        GenerarFlecha();
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
    
    public FiguraAtributo getFigCante(){ return implicante;}
    public FiguraAtributo getFigCado(){ return implicado;}
       
    public void setEsTrivial(boolean EsTrivial){ _EsTrivial=EsTrivial;}
    public boolean getEstrivial(){ return _EsTrivial;}
    
    public void setPosicion(int[] Posicion){      
        _posicion=Posicion;
        implicante.SetPosition(new Point(Posicion[0],Posicion[1]));
        implicante.SetPosition(new Point(Posicion[2],Posicion[3]));
        GenerarFlecha();
    }
    public int[] getPosicion(){ return _posicion;}
       
}

 class FiguraAtributo {
     
        private List<Shape> _fig;
        private Color _color;
        private String _label="";
        private Point _posicion;
        private List<Atributo> _dato;

        public FiguraAtributo(List<Atributo> listaAtributos,int x, int y) {
           super();         
           _posicion = new Point(x, y); 
           _dato=listaAtributos;
           _fig=CrearShape();
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
            _fig = CrearShape();
        }
        private List<Shape> CrearShape(){
            
            _fig = new ArrayList<>();
            for(int i =0;i<_dato.size();i++){
                _posicion.x+=5;
                _fig.add(new Rectangle2D.Double(_posicion.x+i*30, _posicion.y, 30, 20));
                _label+=_dato.get(i).getEtiqueta();
            }
            if(_fig.size()>1)_fig.add(new Rectangle2D.Double(_posicion.x-(5*_fig.size()), _posicion.y-5, 40*_fig.size(), 30));
            return _fig;
        }
    }