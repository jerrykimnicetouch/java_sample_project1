/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

/**
 *
 * @author wsl nly
 */
public class MovingChecker extends MovingShape{
    
    private int horizontalNumBlock, verticalNumBlock; //assignment description
    private int squareSizeWidth, squareSizeHeight;
    
    
     public MovingChecker(){
        super();
        this.horizontalNumBlock = 2 + (int)( Math.random() * 5 ) ; //2 to 7 random number
        this.verticalNumBlock = 2 + (int)( Math.random() * 5 ) ; //2 to 7 random number
    }
    
    public MovingChecker(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
        super(x, y, w, h, mw, mh, c, fc,  pathType);
         this.horizontalNumBlock = 2 + (int)( Math.random() * 5 ) ; //2 to 7 random number
        this.verticalNumBlock = 2 + (int)( Math.random() * 5 ) ; //2 to 7 random number

    }
    
    public void draw(Graphics g){
                  
                      
           this.squareSizeWidth = (int)(this.width / this.horizontalNumBlock);
           this.squareSizeHeight = (int)(this.height / this.verticalNumBlock);
          
           for (int i = 0; i < this.horizontalNumBlock; i++){
                for (int j = 0; j < this.verticalNumBlock ; j++){
                    
                    int x = this.topLeft.x + (int)( i * this.squareSizeWidth);
                    int y = this.topLeft.y + (int)( j * this.squareSizeHeight);
                   
                    if ( (i+j) % 2 == 0 ) {
                        
                        g.setColor(this.fillColor);
                        g.fillRect(x, y, squareSizeWidth, squareSizeHeight);
                   
                    } else {
                        
                        g.setColor(this.borderColor);
                        g.fillRect(x, y, squareSizeWidth, squareSizeHeight);
                        
                    }
                   
                    
                }
            }
         
    }
    
    public boolean contains(Point p){
      
       if(  (this.topLeft.x <= p.x  && p.x <= (this.topLeft.x + this.width)) && (this.topLeft.y <= p.y  && p.y <= (this.topLeft.y + this.height)) ){ 
            this.setSelected(true);
            // System.out.println("MovingChecker selected!");
            JOptionPane.showMessageDialog(null, "MovingChecker selected!");
            return true;
        }else{
            this.setSelected(false);
            return false;
        }
    
    }
}
