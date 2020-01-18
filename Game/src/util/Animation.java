/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hainam
 */
public class Animation {
    private List<BufferedImage> frames;
    private int frameindex = 0;
    private int deltaTime;
    private long previousTime;
    
    public  Animation(int deltaTime){
        this.deltaTime = deltaTime;
        frames = new ArrayList<BufferedImage>();
        
    }
    public void update(){
        if(System.currentTimeMillis()-previousTime>deltaTime){
        frameindex++;
        if(frameindex >= frames.size()){
            frameindex = 0;
            }
        previousTime = System.currentTimeMillis();
        }
    }
    
    public void addFrame(BufferedImage frame){
        frames.add(frame);
    }
    
    public BufferedImage getFrame(){
        if (frames.size()>0){
            return frames.get(frameindex);
        }
        return null;
    }
}
