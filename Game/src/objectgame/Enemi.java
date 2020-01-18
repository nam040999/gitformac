/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author hainam
 */
public abstract class Enemi {
    public abstract Rectangle getBound();
    public abstract void draw(Graphics g);
    public abstract void update();
    public abstract boolean isOutOfScreen();
    public abstract boolean isOver();
    public abstract boolean isScoreGot();
    public abstract void setIsScoreGot(boolean isScoreGot);
}
 