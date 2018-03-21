/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 *
 * @author u1401
 */
public class FiguraConjunto {
    
        private List<Shape> _fig;
        private HashMap<String,Point> _etiqueta;
        private Color _color;
        private Point _posicion;
        private List<Atributo> _dato;

        public FiguraConjunto(List<Atributo> listaAtributos,int x, int y) {
           super();    
           _etiqueta = new HashMap<String,Point>();
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
                Point Pt = new Point(_posicion.x+i*30,_posicion.y);
                Rectangle2D Fi =new Rectangle2D.Double(Pt.x, Pt.y, 30, 20);
                _etiqueta.put(_dato.get(i).getEtiqueta(),new Point(Pt.x+15,Pt.y+15));
                _fig.add(Fi);                 
            }
            if(_fig.size()>1)_fig.add(new Rectangle2D.Double(_posicion.x-(5*_fig.size()), _posicion.y-5, 40*_fig.size(), 30));
            return _fig;
        }
        public Rectangle2D getContenedor(){
            return _fig.get(_fig.size()-1).getBounds2D();
        }
        public HashMap<String,Point> getEtiquetas (){
            return _etiqueta;
        }
        
    
}
