/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.awt.geom.AffineTransform;

/**
 *
 * @author u1401
 */
public class Dibujador extends JPanel{
    
 private HashMap<String,Shape> _figuras;
 private List<Shape> _tem;
 private List<Point[]> _flechas;
 private List<Point[]> _flechasAetiqueta;
 private Graphics2D g2;
 private Rectangle _marco;
 private HashMap<String,Point>_etiqueta;
 private int ARR_SIZE = 4;
 
 
 
 public Dibujador(){
     _figuras = new HashMap<String,Shape>();
     _tem = new ArrayList<Shape>();
     _flechas = new ArrayList<Point[]>();
     _flechasAetiqueta = new ArrayList<Point[]>();
     _etiqueta = new HashMap<String,Point>();
     
//     _marco = new Rectangle(100, 100,200,200);
      setSize(1000,1000);
//      setSize(100,100);
     setVisible(true);
 }
 
 public void paint (Graphics g){
   super.paintComponent(g);
   
   _marco = new Rectangle(30,30,g.getClipBounds().width-60,g.getClipBounds().height-60);
   g2 = (Graphics2D) g.create();
   g2.draw(_marco);
    for (Shape item : _tem) {
          g2.setColor(Color.BLACK);
          g2.draw(item);            
      }
    
 
    for (String et : _etiqueta.keySet()){
         g2.setColor(Color.BLUE);
         g2.drawString(et,_etiqueta.get(et).x, _etiqueta.get(et).y);
    }
      for (Point[] fc : _flechas){
         g2.setColor(Color.red);
         drawArrowLine(g2,fc[0],fc[1]);
    }
    for (Point[] fc : _flechasAetiqueta){
         g2.setColor(Color.GREEN);
         g2.drawLine(fc[0].x, fc[0].y, fc[1].x, fc[1].y);
      }
 
    
    
 }
 
private void drawArrowLine(Graphics2D g, Point ini, Point fin) {
    int dx = fin.x - ini.x, dy = fin.y - ini.y;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - ARR_SIZE, xn = xm, ym = ARR_SIZE, yn = -ARR_SIZE, x;
    double sin = dy / D, cos = dx / D;

    x = xm*cos - ym*sin + ini.x;
    ym = xm*sin + ym*cos + ini.y;
    xm = x;

    x = xn*cos - yn*sin + ini.x;
    yn = xn*sin + yn*cos + ini.y;
    xn = x;

    int[] xpoints = {fin.x, (int) xm, (int) xn};
    int[] ypoints = {fin.y, (int) ym, (int) yn};

    g.drawLine(ini.x, ini.y, fin.x, fin.y);
    g.fillPolygon(xpoints, ypoints, 3);
}
  @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            for (Shape item : _figuras.values()) {
               g2.draw(item);
             }

            g2.dispose();
        }
   
        
   public void AgregarFigura(String etiqueta ,Shape fig){
      _figuras.put(etiqueta,fig);     
   }
   public void AgregarFlecha(Point[] fle){
      _flechas.add(fle);     
   }
    public void AgregarFlechaAetiqueta(Point[] fle){
      _flechasAetiqueta.add(fle);     
   }
   public void AgregarTemp(List<Shape> fle){
      _tem.addAll(fle);     
   }
   public Point UltimaPosicion(){    
      if(_figuras.size()!=0)return _tem.get(_figuras.size()-1).getBounds().getLocation();
      else return new Point(50,30);
   }
   public void setMarco(Rectangle marco){
       _marco=marco;
   }
   public boolean ContienAtributo(String etiqueta){
   return _etiqueta.containsKey(etiqueta);
   }
   public void AgregarEtiqueta(String et , Point pt)
   {
       _etiqueta.put(et, pt);
   }
   public Point getPuntoAtributo(String etq){
   return _figuras.get(etq).getBounds().getLocation();
   }
   public Point getPuntoEtiqueta(String et){
   return _etiqueta.get(et);
   }
   public boolean content(Point pt){
      return _marco.contains(pt);
   }
//    public static void main(String[] args) {
////       Run the GUI codes on the Event-Dispatching thread for thread safety
//      SwingUtilities.invokeLater(new Runnable() {
//         @Override
//         public void run() {
//            new Dibujador(); // Let the constructor do the job
//         }
//      });
//   }
        
    
}

