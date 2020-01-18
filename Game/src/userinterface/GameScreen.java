/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import objectgame.MainCharacter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import objectgame.EnemiManager;
import objectgame.Land;
import util.Resource;

/**
 *
 * @author hainam
 */
public class GameScreen extends JPanel implements Runnable, KeyListener {
    public static final int Game_first_state = 0;
    public static final int Game_play_state = 1;
    public static final int Game_over_state = 2;
    public static final float Gravity = 0.05f;
    public static final float Groundy = 300;
    private MainCharacter mainCharacter;
    private Thread thread;
    private Land land;
    private EnemiManager enemiManager;
    private int score;
    
    private int gameState = Game_first_state;
    
    private BufferedImage imageGameOver;
    
   
    
    public GameScreen(){
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(50);
        mainCharacter.setY(50);
        land = new Land(this);
        enemiManager = new EnemiManager(mainCharacter, this);
        imageGameOver = Resource.getResourceImage("data/lose.png");
    }
    
    public void startGame(){
        thread.start();
    }

    @Override
    public void run() {
        while(true){
        //System.out.println(i++);
            try {
                update();
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
    }
    
    public void update(){
        switch(gameState){
            case Game_play_state:
            mainCharacter.update();
            land.update();
            enemiManager.update();
            if(!mainCharacter.getAlive()){
                gameState = Game_over_state;
                
            }
            break;
        }
        
    }
    
    public void plusScore(int score){
        this.score += score;
        
    }
    
    @Override
    public void paint(Graphics g){
       g.setColor(Color.white);
       g.fillRect(0, 0, 1400, 400);
       g.setColor(Color.black);
       g.drawLine(0, (int)Groundy, 1400, (int)Groundy);
       
        switch(gameState){
            case Game_first_state:
                mainCharacter.draw(g);
                land.draw(g);
                break;
            case Game_play_state:
                land.draw(g);
                mainCharacter.draw(g);
                enemiManager.draw(g);
                g.setColor(Color.red);
                g.drawString("SCORE: " + String.valueOf(score),1200,20);
                break;
            case Game_over_state:
                land.draw(g);
                mainCharacter.draw(g);
                enemiManager.draw(g);
                g.drawImage(imageGameOver,550,100,null);
                break;   
       }    
       
//       land.draw(g);
//       mainCharacter.draw(g);
//       enemiManager.draw(g);
       
    }
    
    public void resetGame(){
        mainCharacter.setAlive(true);
        mainCharacter.setX(50);
        mainCharacter.setY(50);
        enemiManager.reset();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if(gameState==Game_first_state){
                    gameState=Game_play_state;
                } else if(gameState==Game_play_state) {
                    mainCharacter.jump();
                } else if (gameState==Game_over_state){
                    resetGame();
                    gameState = Game_play_state;
                }
               break;
        }
    }
}
