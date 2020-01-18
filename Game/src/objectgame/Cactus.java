/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import util.Resource;

/**
 *
 * @author hainam
 */
public class Cactus extends Enemi {
    private BufferedImage image;
    private int posX, posY;
    private Rectangle rect;
    private MainCharacter mainCharacter;
    private boolean isScoreGot = false;
    
    public Cactus(MainCharacter mainCharacter){
        this.mainCharacter = mainCharacter;
        image = Resource.getResourceImage("data/ct1.png");
        posX = 300;
        posY = 230;
        rect = new Rectangle();
    }

    
    public void update(){
        posX-=4;
        rect.x  = posX;
        rect.y  = posY;
        rect.width = image.getWidth();
        rect.height = image.getHeight();
    }
    
    @Override
    public Rectangle getBound(){
        return rect;
    }
     
    @Override
    public void draw(Graphics g){
        g.drawImage(image,posX,posY,null);
        
    }
    
    public void setX(int x){
        posX = x;
    }
    
    public void setY(int y){
        posY= y;
    }
    
    public void setImage(BufferedImage image){
        this.image = image;
    }

    @Override
    public boolean isOutOfScreen() {
        return (posX + image.getWidth() < 0);
    }

    @Override
    public boolean isOver() {
        return (mainCharacter.getX() > posX);
    }

    @Override
    public boolean isScoreGot() {
        return isScoreGot;
    }

    @Override
    public void setIsScoreGot(boolean isScoreGot) {
       this.isScoreGot = isScoreGot;
    }
    
    
}
