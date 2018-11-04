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

/**
 *
 * @author wsl nly
 */
public class MovingRectangle extends MovingShape{
    
    
    public MovingRectangle(){
        super();
    }
    
    public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
        super(x, y, w, h, mw, mh, c, fc,  pathType);
        
        //JOptionPane.showMessageDialog(null, ""+w, "InfoBox: " +  w, JOptionPane.INFORMATION_MESSAGE);

    }
    
    public void draw(Graphics g){
                  
            g.setColor(this.borderColor);
            g.drawRect(this.topLeft.x,this.topLeft.y , this.width, this.height);
            g.setColor(this.fillColor);
            g.fillRect(this.topLeft.x,this.topLeft.y , this.width, this.height);
         
    }
    
    public boolean contains(Point p){
      
        if(  (this.topLeft.x <= p.x  && p.x <= (this.topLeft.x + this.width)) && (this.topLeft.y <= p.y  && p.y <= (this.topLeft.y + this.height)) ){ 
            this.setSelected(true);
            System.out.println("MovingRectangle selected!");
           //JOptionPane.showMessageDialog(null, "MovingRectangle selected!");
            return true;
        }else{
            this.setSelected(false);
            return false;
        }
    
    }
}
