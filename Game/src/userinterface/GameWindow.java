/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;


import javax.swing.JFrame;

/**
 *
 * @author hainam
 */
public class GameWindow extends JFrame {
    private GameScreen gameScreen;
    public GameWindow (){
        super("Pikachuzz");
        setSize(1400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen = new GameScreen();
        add(gameScreen);
        addKeyListener(gameScreen);
    }
    
    /**
     * @param args the command line arguments
     */
    public void startGame(){
        gameScreen.startGame();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        GameWindow gw = new GameWindow();
        gw.setVisible(true);
        gw.startGame();
    }
    
}
