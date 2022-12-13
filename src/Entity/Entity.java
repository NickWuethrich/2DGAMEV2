package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public abstract class Entity {
    protected  BufferedImage defaultSprite;
    private int counter,i;
    public abstract void  paintCharacters(Graphics g);
    public abstract void update();
    public void EntityAnimation(BufferedImage playerDirection, List<BufferedImage> characterImages ,  int playIndexStart, int playIndexEnd) {
        counter++;
        if (defaultSprite.equals(playerDirection)) {
            if (counter > 0) {
                i = playIndexStart;
                defaultSprite = characterImages.get(i);
                if (counter > 8) {
                    i = playIndexStart + 1;
                    defaultSprite = characterImages.get(i);
                    if (counter > 16) {
                        i = playIndexStart + 2;
                        defaultSprite = characterImages.get(i);
                        if (counter > 32) {
                            i = playIndexStart + 3;
                            defaultSprite = characterImages.get(i);
                            if (counter > 48) {
                                i = playIndexStart + 4;
                                defaultSprite = characterImages.get(i);
                                if (counter > 56) {
                                    i = playIndexEnd;
                                    defaultSprite = characterImages.get(i);
                                    counter = 0;

                                }
                            }
                        }
                    }
                }
            }
        }
    }




















}