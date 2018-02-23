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

/**
 *
 * @author u1401
 */
public class Dibujador extends JPanel{
    
 private List<Shape> _figuras;
 private List<Point[]> _flechas;
 private Graphics2D g2;
 private Rectangle _marco;
 
 
 
 public Dibujador(Rectangle marco, Graphics g){
     _figuras = new ArrayList<Shape>();
//      g2 = (Graphics2D) g.create();
//      _marco = new Rectangle(marco.x+10, marco.y+10,marco.width-20,marco.height-20);
     _marco = new Rectangle(100, 100,200,200);
//      setSize(marco.width-100,marco.height-100);
      setSize(100,100);
//      g2.setColor(Color.BLACK);
//     g2.draw(_marco);
     setVisible(true);
 }
 
 public void paint (Graphics g){
   super.paintComponent(g);
   g2 = (Graphics2D) g.create();
    for (Shape item : _figuras) {
          g2.setColor(Color.BLACK);
          g2.draw(item);      
      }
//    for (Point[] fc : _flechas){
//         g2.setColor(Color.red);
//         g2.drawLine(fc[0].x, fc[0].y, fc[1].x, fc[1].y);
//    }
 }
  @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            for (Shape item : _figuras) {
               g2.draw(item);
             }

            g2.dispose();
        }
   
   public void AgregarFigura(Shape fig){
      _figuras.add(fig);     
   }
   public void AgregarFlecha(Point[] fle){
      _flechas.add(fle);     
   }
    public void AgregarRangoFigura(List<Shape> fig){
      _figuras.addAll(fig);     
   }
    
    
   public List<Shape> getShape() {
    return _figuras;
   }
   public void setShape(List<Shape> Fig){
     _figuras=Fig;  
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

