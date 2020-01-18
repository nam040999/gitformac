/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import static userinterface.GameScreen.Gravity;
import static userinterface.GameScreen.Groundy;
import util.Animation;
import util.Resource;

/**
 *
 * @author hainam
 */
public class MainCharacter {
    private float x = 40;
    private float y = 0;
    private float speedY= 0;
    private Animation characterRun;
    private Rectangle rect;
    private boolean isAlive = true;
  
    
    public MainCharacter(){
        characterRun = new Animation(100);
        characterRun.addFrame(Resource.getResourceImage("data/pika1.png"));
        characterRun.addFrame(Resource.getResourceImage("data/pika2.png"));
        characterRun.addFrame(Resource.getResourceImage("data/pika3.png"));
        characterRun.addFrame(Resource.getResourceImage("data/pika4.png"));
        rect = new Rectangle();
    }
    
    public void update(){
        characterRun.update();
        if(y >= Groundy - characterRun.getFrame().getHeight()){
                    speedY = 0;
                    y = Groundy -characterRun.getFrame().getHeight()-1;
                } else {
                speedY+=Gravity;
                y+=speedY;
                }
        rect.x = (int)x;
        rect.y = (int)y;
        rect.width = characterRun.getFrame().getWidth();
        rect.height = characterRun.getFrame().getHeight();
    }
    
    public Rectangle getBound(){
        return rect;
    }
    
    public void draw (Graphics g){
       g.setColor(Color.black);
       g.fillRect((int) x,(int) y, characterRun.getFrame().getWidth(), characterRun.getFrame().getHeight());  
       g.drawImage(characterRun.getFrame(), (int)x, (int)y, null);
    }
    
    public void jump(){
        speedY = - 4;
        y += speedY;
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
    
    public void setAlive (boolean alive){
        isAlive = alive;
    }
    
    public boolean getAlive (){
        return isAlive;
    }
}
