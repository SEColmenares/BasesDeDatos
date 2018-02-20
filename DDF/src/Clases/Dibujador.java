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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author u1401
 */
public class Dibujador extends JPanel{
    
 private List<Shape> _figuras;
 private Graphics2D g2;
 
 public Dibujador(){
     _figuras = new ArrayList<Shape>();
     setSize(1000,1000);
     setVisible(true);
 }
 
 public void paint (Graphics g){
   super.paintComponent(g);
   g2 = (Graphics2D) g.create();
    for (Shape item : _figuras) {
          g2.draw(item);
      }
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
 
   public List<Shape> getShape() {
    return _figuras;
   }
   public void setShape(List<Shape> Fig){
     _figuras=Fig;  
   }
    public static void main(String[] args) {
      // Run the GUI codes on the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Dibujador(); // Let the constructor do the job
         }
      });
   }
        
    
}

