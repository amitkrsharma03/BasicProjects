package Dice;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImgSer {
    public static JLabel loadImage(String path){
        BufferedImage img;
        JLabel imgContainer;
        try{
            InputStream inputStream=ImgSer.class.getResourceAsStream(path);
            img=ImageIO.read(inputStream);
            imgContainer=new JLabel(new ImageIcon(img));
            return imgContainer;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void Update(JLabel imgContainer, String path){
        BufferedImage img;
        try{
            InputStream inputStream=ImgSer.class.getResourceAsStream(path);
            img=ImageIO.read(inputStream);
            imgContainer.setIcon(new ImageIcon(img));
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
}
