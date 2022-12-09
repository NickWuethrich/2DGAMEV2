package Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player implements KeyListener {
    private BufferedImage playerImageCharacter, playerUp, playerDown, playerDown1, playerDown2, playerDown3, playerDown4, playerDown5, playerDown6, playerDown7, playerRight, playerLeft;
    private BufferedImage playerLeft1, playerLeft2,playerLeft3,playerLeft4,playerLeft5,playerLeft6;
    private BufferedImage playerUpDefault ,playerUp1, playerUp2, playerUp3, playerUp4,playerUpAttack,playerUpAttack1,playerUpAttack2,playerUpAttack3,playerUpAttack4,playerUpAttack5,playerUpAttack6;
    private BufferedImage playerRight1, playerRight2,playerRight3,playerRight4,playerRight5,playerRight6,playerAttackRight1,playerAttackRight2,playerAttackRight3,playerAttackRight4,playerAttackRight, playerRightDefault;
    private int CenterX;
    private int CenterY;

    private int playIndexStart, playIndexEnd;
    ArrayList<Integer> spriteAnimationInit = new ArrayList<Integer>();
    List<BufferedImage> playerImages = new ArrayList<BufferedImage>();

    AffineTransform tx = new AffineTransform();



    private void spriteListInit() {
        spriteAnimationInit.add(13);
    }

    private int counter,i;
    private boolean attackState = false;

    public void loadPlayerImageCharacter() {

        tx.scale(1, -1);
        try {
            playerImageCharacter = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile000.png"));


            playerUpDefault = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile012.png"));
            playerUp = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile012.png"));
            playerUp1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile013.png"));
            playerUp2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile014.png"));
            playerUp3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile015.png"));
            playerUp4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile016.png"));

            playerUpAttack1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile017.png"));

            playerRightDefault  = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));
            playerRight = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));
            playerRight1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile025.png"));
            playerRight2= ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile026.png"));
            playerRight3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile027.png"));
            playerRight4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile028.png"));
            playerRight5 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile029.png"));
            playerRight6 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));

            playerLeft = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006left.png"));
            playerLeft1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile025left.png"));
            playerLeft2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile026left.png"));
            playerLeft3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile027left.png"));
            playerLeft4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile028left.png"));
            playerLeft5 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile029left.png"));
            playerLeft6 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006left.png"));


            playerDown = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile001.png"));
            playerDown1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile018.png"));
            playerDown2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile019.png"));
            playerDown3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile020.png"));
            playerDown4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile021.png"));
            playerDown5 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile022.png"));
            playerDown6 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile023.png"));
            playerDown7 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile000.png"));

            playerAttackRight= ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile042.png"));
            playerAttackRight1= ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile042.png"));
            playerAttackRight2= ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile043.png"));
            playerAttackRight3= ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile044.png"));
            playerAttackRight4= ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile045.png"));



        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void playerImageList() {
        playerImages.add(playerDown1);
        playerImages.add(playerDown2);
        playerImages.add(playerDown3);
        playerImages.add(playerDown4);
        playerImages.add(playerDown5);
        playerImages.add(playerDown6);

        playerImages.add(playerUp1);
        playerImages.add(playerUp2);
        playerImages.add(playerUp3);
        playerImages.add(playerUp4);
        playerImages.add(playerUp3);
        playerImages.add(playerUp2);

        playerImages.add(playerRight1);
        playerImages.add(playerRight2);
        playerImages.add(playerRight3);
        playerImages.add(playerRight4);
        playerImages.add(playerRight5);
        playerImages.add(playerRight6);

        playerImages.add(playerAttackRight1);
        playerImages.add(playerAttackRight1);
        playerImages.add(playerAttackRight2);
        playerImages.add(playerAttackRight2);
        playerImages.add(playerAttackRight3);
        playerImages.add(playerAttackRight4);

        playerImages.add(playerUpAttack1);
        playerImages.add(playerUpAttack2);
        playerImages.add(playerUpAttack3);
        playerImages.add(playerUpAttack3);
        playerImages.add(playerUpAttack4);
        playerImages.add(playerUpAttack4);

        playerImages.add(playerLeft1);
        playerImages.add(playerLeft2);
        playerImages.add(playerLeft3);
        playerImages.add(playerLeft4);
        playerImages.add(playerLeft5);
        playerImages.add(playerLeft6);





    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    private int Speed = 0;


    public int getCenterX() {
        return CenterX;
    }

    public void setCenterX(int centerX) {
        CenterX = centerX;
    }

    public int getCenterY() {
        return CenterY;
    }

    public void setCenterY(int centerY) {
        CenterY = centerY;
    }

    public void paint(Graphics g) {
        g.drawImage(playerImageCharacter, getCenterX(), getCenterY(), null);
    }

    public void update() {

        if (CenterX <= 6) {
            CenterX = 6;
        }
        if (CenterX >= 756) {
            CenterX = 750;
        }
        if (CenterY <= 6)
            CenterY = 6;

        if (CenterY >= 420) {
            CenterY = 420;
        }
        Speed = 6;
        spriteDirectionAnimation();
        playerAnimation(playerDown, 0, 5);
        playerAnimation(playerUp, 6, 11);
        playerAnimation(playerRight,12,17);
        playerAnimation(playerAttackRight,18,23);
        playerAnimation(playerLeft,24,29);
    }

    public void playerAnimation(BufferedImage playerDirection, int playIndexStart, int playIndexEnd) {
        playerImageList();
        counter++;
            if (playerImageCharacter.equals(playerDirection)) {
                if (counter > 10) {
                    i=playIndexStart;
                    playerImageCharacter = playerImages.get(i);
                    if (counter > 20) {
                        i=playIndexStart+1;
                        playerImageCharacter = playerImages.get(i);
                        if (counter > 30) {
                            i= playIndexStart+2;
                            playerImageCharacter = playerImages.get(i);
                            if (counter > 40) {
                                i= playIndexStart+3;
                                playerImageCharacter = playerImages.get(i);
                                if (counter > 50) {
                                    i= playIndexStart+4;
                                    playerImageCharacter = playerImages.get(i);
                                    if (counter > 50) {
                                        i= playIndexEnd;
                                        playerImageCharacter = playerImages.get(i);
                                            counter = 0;
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }

    public void resetAttackAnimation(){
        if(playerImageCharacter.equals(playerAttackRight4)){
            try {
                Thread.sleep(15);
                playerImageCharacter = playerRight;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void spriteDirectionAnimation() {
        spriteListInit();
            if (spriteAnimationInit.get(0) == 1) {
                playerImageCharacter = playerUp;
            }
            if (spriteAnimationInit.get(0)== 7){
                playerImageCharacter=playerUpAttack;
            }
            if (spriteAnimationInit.get(0) == 2) {
                playerImageCharacter = playerDown;
            }
            if (spriteAnimationInit.get(0) == 3) {
                playerImageCharacter = playerLeft;
            }
            if (spriteAnimationInit.get(0) == 4) {
                playerImageCharacter = playerRight;
            }
            if (spriteAnimationInit.get(0) == 5) {
                playerImageCharacter = playerAttackRight;
            }
    }


    public void moveUP(){
        CenterY -= Speed;
    }

    public void moveDown(){
        CenterY += Speed;
    }

    public void moveRight() {
        CenterX += Speed;
    }

    public void moveLeft() {
        CenterX -= Speed;

    }

    public void stop() {
        Speed = 0;
    }



    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                spriteAnimationInit.set(0,1);
                moveUP();
                break;

            case KeyEvent.VK_DOWN:
                spriteAnimationInit.set(0,2);
                moveDown();
                break;

            case KeyEvent.VK_LEFT:
                spriteAnimationInit.set(0,3);
                moveLeft();
                break;

            case KeyEvent.VK_RIGHT:
                spriteAnimationInit.set(0,4);
                moveRight();
                break;

            case KeyEvent.VK_E:
                spriteAnimationInit.set(0,5);
                if(playerImageCharacter.equals(playerUp)){
                    spriteAnimationInit.set(0,7);
                }
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                spriteAnimationInit.set(0,6);
                playerImageCharacter = playerUp;
                stop();
                break;
            case KeyEvent.VK_DOWN:
                spriteAnimationInit.set(0,6);
                playerImageCharacter = playerDown7;
                stop();
                break;

            case KeyEvent.VK_LEFT:
                spriteAnimationInit.set(0,6);
                playerImageCharacter = playerLeft6;
                stop();
                break;

            case KeyEvent.VK_RIGHT:
                spriteAnimationInit.set(0,6);
                playerImageCharacter = playerRightDefault;
                stop();
                break;

            case  KeyEvent.VK_E:
                spriteAnimationInit.set(0,6);
                playerImageCharacter=playerRightDefault;

                break;

        }

    }
}




