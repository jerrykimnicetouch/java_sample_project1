/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;

public class MovingOval extends MovingShape{
    
    public MovingOval(){
        super();
    }
    
    public MovingOval(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
        super(x, y, w, h, mw, mh, c, fc,  pathType);
        
        //JOptionPane.showMessageDialog(null, ""+w, "InfoBox: " +  w, JOptionPane.INFORMATION_MESSAGE);

    }
    
    public void draw(Graphics g){
                  
            g.setColor(this.borderColor);
            g.drawOval(this.topLeft.x,this.topLeft.y , this.width, this.height);
            g.setColor(this.fillColor);
            g.fillOval(this.topLeft.x,this.topLeft.y , this.width, this.height);
  
    }
    
    public boolean contains(Point p){
     
       Point EndPt = new Point(topLeft.x + this.width, topLeft.y + this.height); 
       double dx = (2 * p.x - topLeft.x - EndPt.x) / (double) width; 
       double dy = (2 * p.y - topLeft.y - EndPt.y) / (double) height;
       if(dx * dx + dy * dy < 1.0){
           System.out.println("MovingOval selected!");
           //JOptionPane.showMessageDialog(null, "MovingOval selected!");
       }
       return dx * dx + dy * dy < 1.0; 
  
    }
   
   
}
