/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import javax.swing.JOptionPane;

public class MovingShapePattern extends MovingShape{
    
    int radius;
    
    public MovingShapePattern(){
        super();
      
    }
    
    public MovingShapePattern(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
        super(x, y, w, h, mw, mh, c, fc,  pathType);
        

    }
    
    public void draw(Graphics g){
                  
        this.radius = (int) this.width/ 2 ;
        
        Hexagon hexagon = new Hexagon(new Point(this.topLeft.x, this.topLeft.y), this.radius );
        
        g.setColor(this.borderColor);
        g.drawPolygon(hexagon.getHexagon());
         
    }
    
    public boolean contains(Point p){
      
       if(  ( (this.topLeft.x - this.radius) <= p.x  && p.x <= (this.topLeft.x + this.radius)) && 
               ( (this.topLeft.y - this.radius)<= p.y  && p.y <= (this.topLeft.y + this.radius)) ){ 
            this.setSelected(true);
            System.out.println("MovingShapePattern selected!");
            //JOptionPane.showMessageDialog(null, "MovingShapePattern selected!");
            
            return true;
        }else{
            this.setSelected(false);
            return false;
        }
    
    }
    
     private class Hexagon {
        private final int radius;

        private final Point center;

        private final Polygon hexagon;

        public Hexagon(Point center, int radius) {
            this.center = center;
            this.radius = radius;
            this.hexagon = createHexagon();
        }

        private Polygon createHexagon() {
            Polygon polygon = new Polygon();

            for (int i = 0; i < 6; i++) {
                int xval = (int) (center.x + radius
                        * Math.cos(i * 2 * Math.PI / 6D));
                int yval = (int) (center.y + radius
                        * Math.sin(i * 2 * Math.PI / 6D));
                polygon.addPoint(xval, yval);
            }

            return polygon;
        }

        public int getRadius() {
            return radius;
        }

        public Point getCenter() {
            return center;
        }

        public Polygon getHexagon() {
            return hexagon;
        }

    }
    
    
}
