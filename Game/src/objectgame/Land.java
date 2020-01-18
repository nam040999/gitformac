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
import userinterface.GameScreen;
import static userinterface.GameScreen.Groundy;
import util.Resource;

/**
 *
 * @author hainam
 */
public class Land {
    private List<ImageLand> listImage;
    private BufferedImage imageLand1, imageLand2, imageLand3;
    public Land(GameScreen game){
        imageLand1 = Resource.getResourceImage("data/land1.png");
        imageLand2 = Resource.getResourceImage("data/land2.png");
        imageLand3 = Resource.getResourceImage("data/land3.png");
        listImage = new ArrayList<ImageLand>();
        int numberOfLandTitle = 1400 / imageLand1.getWidth()+2;
        for (int i = 0; i < numberOfLandTitle; i++) {
            ImageLand imageLand = new ImageLand();
            imageLand.posX = (int) (i*imageLand1.getWidth());
            imageLand.image = imageLand1;
            listImage.add(imageLand);
        }
        
    }
    
    public void update(){
        for(ImageLand imageLand: listImage){
            imageLand.posX-=4;
        }
        ImageLand firstElement = listImage.get(0);
        if(listImage.get(0).posX + imageLand1.getWidth()<0){
            firstElement.posX = listImage.get(listImage.size()-1).posX+ imageLand1.getWidth();
            listImage.add(firstElement);
            listImage.remove(0);
        }
    }
    
    public void draw(Graphics g){
        for(ImageLand imageLand:listImage){
        g.drawImage(imageLand.image, imageLand.posX,(int) Groundy , null);
        }
          
    }
    private class ImageLand {
         int posX;
         BufferedImage image;
    }
}
