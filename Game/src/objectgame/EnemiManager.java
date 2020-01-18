/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import userinterface.GameScreen;
import util.Resource;

/**
 *
 * @author hainam
 */
public class EnemiManager {
    private List<Enemi> enemies;
    private Random random;
    
    private BufferedImage imagePokeBall1, imagePokeBall2; 
    private MainCharacter mainCharacter;
    private GameScreen gameScreen;
    
    public EnemiManager(MainCharacter mainCharacter, GameScreen gameScreen){
        this.mainCharacter = mainCharacter;
        this.gameScreen = gameScreen;
        enemies = new ArrayList<Enemi>();
        imagePokeBall1= Resource.getResourceImage("data/ct1.png");
        imagePokeBall2= Resource.getResourceImage("data/ct2.png");
        random = new Random();
        enemies.add(getRandomPokeBall());
      
    }  
    
    public void update(){
        for ( Enemi e : enemies){
            e.update();
            if(e.isOver()&& !e.isScoreGot()){
                gameScreen.plusScore(20);
                e.setIsScoreGot(true);
            }
            if(e.getBound().intersects(mainCharacter.getBound())){
                mainCharacter.setAlive(false);
            }
        }    
        Enemi firstEnemi = enemies.get(0);
        if (enemies.get(0).isOutOfScreen()){
            enemies.remove(firstEnemi);
            enemies.add(getRandomPokeBall());
        }
    
    }
    
 
    public void draw(Graphics g){
        for(Enemi e: enemies){
            e.draw(g);
        }
    }
    
    public void reset(){
        enemies.clear();
        enemies.add(getRandomPokeBall());
    }
    
    private PokeBall getRandomPokeBall(){
        PokeBall pokeBall;
        pokeBall = new PokeBall(mainCharacter);
        pokeBall.setX(1400);
        if(random.nextBoolean()){
            pokeBall.setImage(imagePokeBall1);
        }else { 
            pokeBall.setImage(imagePokeBall2);
            
        }
        return pokeBall;
    }
} 
