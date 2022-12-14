package GameArea;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class Background{
    private final int backgrounfHeight = 600;

    private final int backgroundWidth = 800;

    private Image grassImage, Image;

    public Background(){
        this.loadMapImage();
    }
    private void loadMapImage(){
        try {
            grassImage = ImageIO.read(getClass().getResource("/resources/images/grass.png"));
            Image = ImageIO.read(getClass().getResource("/resources/images/29675.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(){
    }

    public void paintBackround(Graphics g){
        /**
        for (int i = 0 ;  i < backgroundWidth ; i++){
            for (int j = 0 ; j < backgrounfHeight ; j++){
                g.drawImage(grassImage,i ,j , null) ;
            }
        }
**/
            g.drawImage(Image,0,0,null);
    }

}
