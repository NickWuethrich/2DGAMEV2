package Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;

public class Player implements KeyListener {
    private Image playerImageCharacter, playerUp, playerDown, playerRight, playerLeft;
    private int CenterX;
    private int CenterY;

    ArrayList<Integer> animationDirectionCounter = new ArrayList<Integer>();

    public void setAnimationDirectionInit(){
            animationDirectionCounter.add(12);
            //for (int i : animationDirectionCounter){
           // System.out.println(i);

    }





    public void loadPlayerImageCharacter() {

        try {
            playerImageCharacter = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile000.png"));
            playerUp = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile012.png"));
            playerDown = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile001.png"));
            playerLeft = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));
            playerRight = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));


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
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        setAnimationDirectionInit();

        // g2d.drawImage(playerImageCharacter, getCenterX(), getCenterY(), null);
        if (animationDirectionCounter.get(0) == 0) {
            playerImageCharacter = playerUp;
            //g2d.drawImage(playerUp, getCenterX(), getCenterY(), null);
        } else {
            if (animationDirectionCounter.get(0) == 1) {
                playerImageCharacter = playerDown;
                //g2d.drawImage(playerDown, getCenterX(), getCenterY(), null);
            } else {
                playerImageCharacter = playerLeft;
                if (animationDirectionCounter.get(0) == 2) {
                    //g2d.drawImage(playerRight, getCenterX(), getCenterY(), null);
                } else {
                    if (animationDirectionCounter.get(0) == 3) {
                        playerImageCharacter = playerRight;
                        //g2d.drawImage(playerLeft, getCenterX(), getCenterY(), null);
                    }
                }
            }
        }
        g2d.drawImage(playerImageCharacter, getCenterX(), getCenterY(), null);
    }




    public void update() {
        if(CenterX <= 6) {
            CenterX = 6;
        }
        if (CenterX >= 756){
            CenterX = 750;
        }
        if (CenterY <= 6)
            CenterY = 6;

        if (CenterY >= 420){
            CenterY = 420;
        }
        Speed = 6;
        moveUP();
        moveDown();
        moveRight();
        moveLeft();

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
                moveUP();
                animationDirectionCounter.set(0,0);
                break;

            case KeyEvent.VK_DOWN:
                moveDown();
                animationDirectionCounter.set(0,1);
                break;

            case KeyEvent.VK_LEFT:
                moveLeft();
                animationDirectionCounter.set(0,2);
                System.out.println(getCenterX());
                break;

            case KeyEvent.VK_RIGHT:
                moveRight();
                animationDirectionCounter.set(0,3);
                System.out.println(getCenterX());
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("Jumping");
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
            case KeyEvent.VK_SPACE:
                break;

        }

    }
}




