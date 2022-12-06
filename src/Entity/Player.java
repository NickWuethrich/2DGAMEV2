package Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class Player implements KeyListener{
    private BufferedImage playerImageCharacter, playerUp, playerDown,playerDown1, playerDown2,playerDown3,playerDown4,playerDown5,playerRight, playerLeft ,playerAttack, player;
    private int CenterX;
    private int CenterY;
    ArrayList<Integer> spriteAnimationInit = new ArrayList<Integer>();
    private void spriteListInit(){
        spriteAnimationInit.add(13);
    }
    private int counter;
    private int counter2;
    private boolean attackState = false;


    public void loadPlayerImageCharacter() {
        try {

            playerImageCharacter = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile000.png"));
            playerUp = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile012.png"));
            playerDown = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile001.png"));
            playerDown1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile002.png"));
            playerDown2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile003.png"));
            playerDown3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile004.png"));
            playerDown4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile005.png"));
            playerLeft = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006left.png"));
            playerRight = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));
            playerAttack = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile043.png"));

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

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
    public void paint(Graphics g)  {
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

        counter++;
        if  (counter > 10) {
            spriteDirectionAnimation();
            counter = 0;
            }

        }
        //System.out.println(counter);
    public void resetAttackAnimation(){
        if(playerImageCharacter.equals(playerAttack)){
            try {
                Thread.sleep(1000);
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
                playerImageCharacter = playerAttack;
                resetAttackAnimation();
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
                //spriteDirectionAnimation();
/**
                if (attackState == false) {
                    try {

                        attackState = !attackState;


                        //attackState = true;
                        //spriteListInit();
                        //playerImageCharacter = playerAttack;
                        //this.attackState = false;
                        //playerAttack = playerRight;
                        //spriteDirectionAnimation();

                        spriteAnimationInit.set(0,4);
                        Thread.sleep(2000);
                        //moveRight();

                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                   // attackState = false;
                    attackState = !attackState;
                }

**/
                break;
        }


    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                stop();
                break;
            case KeyEvent.VK_DOWN:
                stop();
                break;

            case KeyEvent.VK_LEFT:
                stop();
                break;

            case KeyEvent.VK_RIGHT:
                stop();
                break;

            case  KeyEvent.VK_E:
                spriteAnimationInit.set(0,6);
                break;

        }

    }
}




