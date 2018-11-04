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
import java.awt.Rectangle;
import javax.swing.JOptionPane;

/**
 *
 * @author wsl nly
 */
public class MovingGradient extends MovingShape{
    
   
    
     public MovingGradient(){
        super();
      
    }
    
    public MovingGradient(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
        super(x, y, w, h, mw, mh, c, fc,  pathType);
        

    }
    
    public void draw(Graphics g){
                  
           Color firstColor = this.fillColor;
           Color secondColor = this.borderColor;
           
           int bottomRightX = this.topLeft.x + this.width;
           int bottomRightY = this.topLeft.y + this.height;
                   
           Graphics2D g2d = (Graphics2D) g;
                      
           GradientPaint gradient = new GradientPaint(this.topLeft.x, this.topLeft.y, firstColor, bottomRightX, bottomRightY, secondColor);
           g2d.setPaint(gradient);

           g2d.fill(new Rectangle(this.topLeft.x, this.topLeft.y, this.width, this.height));
        
           
         
    }
    
    public boolean contains(Point p){
      
       if(  (this.topLeft.x <= p.x  && p.x <= (this.topLeft.x + this.width)) && (this.topLeft.y <= p.y  && p.y <= (this.topLeft.y + this.height)) ){ 
            this.setSelected(true);
            System.out.println("MovingGradient selected!");
            //JOptionPane.showMessageDialog(null, "MovingGradient selected!");
            return true;
        }else{
            this.setSelected(false);
            return false;
        }
    
    }
    
}
