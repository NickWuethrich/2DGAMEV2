package GameArea;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class GameAreaCell {


    private int cellX , cellY ,type;
    private Image cellImage;

    public GameAreaCell(){
        try {
            cellImage = ImageIO.read(getClass().getResource("/resources/images/tiledirt.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public GameAreaCell (int x , int y , int typeInt)  {
        this.cellX = x;
        this.cellY = y;
        this.type = typeInt;

        if (type == 1){
            try {
                cellImage = ImageIO.read(getClass().getResource("/resources/images/tiledirt.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void CellPaint(Graphics g){
        for(int i = 0; i < 800;i++){
            for (int j = 0 ; i < 500; i++){
                g.drawImage(cellImage, i, j,null) ;
            }
        }

    }

    public int getCellX() {
        return cellX;
    }

    public void setCellX(int cellX) {
        this.cellX = cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public void setCellY(int cellY) {
        this.cellY = cellY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Image getCellImage() {
        return cellImage;
    }

    public void setCellImage(Image cellImage) {
        this.cellImage = cellImage;
    }
}
