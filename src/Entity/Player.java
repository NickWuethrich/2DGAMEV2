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

public class Player extends Entity  implements KeyListener {
    private BufferedImage playerImage, playerDown, playerDown1, playerDown2, playerDown3, playerDown4, playerDown5, playerDown6, playerDownAttack, playerDownAttack1, playerDownAttack2, playerDownAttack3, playerDownAttack4;
    private BufferedImage playerLeft, playerLeft1, playerLeft2, playerLeft3, playerLeft4, playerLeft5, playerLeft6, playerAttackLeft, playerAttackLeft1, playerAttackLeft2, playerAttackLeft3, playerAttackLeft4;
    private BufferedImage playerUpDefault, playerUp, playerUp1, playerUp2, playerUp3, playerUp4, playerUpAttack, playerUpAttack1, playerUpAttack2, playerUpAttack3, playerUpAttack4;
    private BufferedImage playerRight, playerRight1, playerRight2, playerRight3, playerRight4, playerRight5, playerRight6, playerAttackRight1, playerAttackRight2, playerAttackRight3, playerAttackRight4, playerAttackRight, playerRightDefault;
    List<BufferedImage> playerImages = new ArrayList<BufferedImage>();
    ArrayList<Integer> spriteAnimationInit = new ArrayList<Integer>();
    private BufferedImage playerLeftDefault;
    private BufferedImage playerDownDefault;
    private int CenterX = 1;
    private int CenterY = 1;
    private int Speed;
    private int Attack;
    private int Health;

    private Slime slime ;

    public Player(int x, int y) {
        x = this.CenterX;
        y = this.CenterY;
        this.slime = new Slime(150, 150,1);
        this.loadCharacterImage();
        this.playerImageList();
        this.setSpeed(6);
    }

    private void spriteListInit() {
        for (int i = 30; i <= 100; i++) {
            spriteAnimationInit.add(i);
        }
    }
    protected void loadCharacterImage() {
        try {
            defaultSprite = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile000.png"));

            playerUpDefault = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile012.png"));
            playerUp = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile012.png"));
            playerUp1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile013.png"));
            playerUp2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile014.png"));
            playerUp3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile015.png"));
            playerUp4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile016.png"));

            playerUpAttack = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile048.png"));
            playerUpAttack1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile048.png"));
            playerUpAttack2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile049.png"));
            playerUpAttack3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile050.png"));
            playerUpAttack4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile051.png"));

            playerRightDefault = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));
            playerRight = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));
            playerRight1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile025.png"));
            playerRight2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile026.png"));
            playerRight3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile027.png"));
            playerRight4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile028.png"));
            playerRight5 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile029.png"));
            playerRight6 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006.png"));

            playerLeftDefault = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006left.png"));
            playerLeft = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006left.png"));
            playerLeft1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile025left.png"));
            playerLeft2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile026left.png"));
            playerLeft3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile027left.png"));
            playerLeft4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile028left.png"));
            playerLeft5 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile029left.png"));
            playerLeft6 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile006left.png"));


            playerDownDefault = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile001.png"));
            playerDown = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile001.png"));
            playerDown1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile018.png"));
            playerDown2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile019.png"));
            playerDown3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile020.png"));
            playerDown4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile021.png"));
            playerDown5 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile022.png"));
            playerDown6 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile023.png"));

            playerAttackRight = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile042.png"));
            playerAttackRight1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile042.png"));
            playerAttackRight2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile043.png"));
            playerAttackRight3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile044.png"));
            playerAttackRight4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile045.png"));

            playerAttackRight = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile042.png"));
            playerAttackRight1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile042.png"));
            playerAttackRight2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile043.png"));
            playerAttackRight3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile044.png"));
            playerAttackRight4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile045.png"));

            playerAttackLeft = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile042left.png"));
            playerAttackLeft1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile042left.png"));
            playerAttackLeft2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile043left.png"));
            playerAttackLeft3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile044left.png"));
            playerAttackLeft4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile045.png"));

            playerDownAttack = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile036.png"));
            playerDownAttack1 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile036.png"));
            playerDownAttack2 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile037.png"));
            playerDownAttack3 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile038.png"));
            playerDownAttack4 = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile039.png"));
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
        playerImages.add(playerAttackRight2);
        playerImages.add(playerAttackRight2);
        playerImages.add(playerAttackRight3);
        playerImages.add(playerAttackRight3);
        playerImages.add(playerAttackRight4);

        playerImages.add(playerUpAttack1);
        playerImages.add(playerUpAttack1);
        playerImages.add(playerUpAttack2);
        playerImages.add(playerUpAttack2);
        playerImages.add(playerUpAttack3);
        playerImages.add(playerUpAttack4);

        playerImages.add(playerLeft1);
        playerImages.add(playerLeft2);
        playerImages.add(playerLeft3);
        playerImages.add(playerLeft4);
        playerImages.add(playerLeft5);
        playerImages.add(playerLeft6);

        playerImages.add(playerAttackLeft1);
        playerImages.add(playerAttackLeft2);
        playerImages.add(playerAttackLeft2);
        playerImages.add(playerAttackLeft3);
        playerImages.add(playerAttackLeft3);
        playerImages.add(playerAttackLeft4);

        playerImages.add(playerDownAttack1);
        playerImages.add(playerDownAttack1);
        playerImages.add(playerDownAttack2);
        playerImages.add(playerDownAttack2);
        playerImages.add(playerDownAttack3);
        playerImages.add(playerDownAttack4);
    }

    public void paintCharacters(Graphics g) {
        slime.paintCharacters(g);
        g.drawImage(defaultSprite, getCenterX(), getCenterY(), null);
    }
    public void update() {
        spriteDirectionAnimation();
        EntityAnimation(playerDown, playerImages, 0, 5);
        EntityAnimation(playerUp, playerImages, 6, 11);
        EntityAnimation(playerRight, playerImages, 12, 17);
        EntityAnimation(playerAttackRight, playerImages, 18, 23);
        EntityAnimation(playerUpAttack, playerImages, 24, 29);
        EntityAnimation(playerLeft, playerImages, 30, 35);
        EntityAnimation(playerAttackLeft, playerImages, 36, 40);
        EntityAnimation(playerDownAttack, playerImages, 41, 45);
        slime.update();
        EnemyFollow();
    }

    private void spriteDirectionAnimation() {
        spriteListInit();
        if (spriteAnimationInit.get(0) == 1) {
            defaultSprite = playerUp;
        }
        if (spriteAnimationInit.get(0) == 2) {
            defaultSprite = playerDown;
        }
        if (spriteAnimationInit.get(0) == 3) {
            defaultSprite = playerLeft;
        }
        if (spriteAnimationInit.get(0) == 4) {
            defaultSprite = playerRight;
        }
        if (spriteAnimationInit.get(1) == 0 && (spriteAnimationInit.get(2) == 1)) {
            defaultSprite = playerUpAttack;
        }
        if (spriteAnimationInit.get(1) == 1 && (spriteAnimationInit.get(3) == 1)) {
            defaultSprite = playerDownAttack;
        }
        if (spriteAnimationInit.get(1) == 2 && (spriteAnimationInit.get(4) == 1)) {
            defaultSprite = playerAttackLeft;
        }
        if (spriteAnimationInit.get(1) == 3 && (spriteAnimationInit.get(5) == 1)) {
            defaultSprite = playerAttackRight;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                spriteAnimationInit.set(0, 1);
                spriteAnimationInit.set(1, 0);
                moveUP();
                break;

            case KeyEvent.VK_DOWN:
                spriteAnimationInit.set(0, 2);
                spriteAnimationInit.set(1, 1);
                moveDown();
                break;

            case KeyEvent.VK_LEFT:
                spriteAnimationInit.set(0, 3);
                spriteAnimationInit.set(1, 2);
                moveLeft();
                break;

            case KeyEvent.VK_RIGHT:
                spriteAnimationInit.set(0, 4);
                spriteAnimationInit.set(1, 3);
                moveRight();
                break;

            case KeyEvent.VK_E:
                spriteAnimationInit.set(2, 1);
                spriteAnimationInit.set(3, 1);
                spriteAnimationInit.set(4, 1);
                spriteAnimationInit.set(5, 1);
                Attack();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                spriteAnimationInit.set(0, 6);
                defaultSprite = playerUpDefault;
                stop();
                break;
            case KeyEvent.VK_DOWN:
                spriteAnimationInit.set(0, 6);
                defaultSprite = playerDownDefault;
                stop();
                break;

            case KeyEvent.VK_LEFT:
                spriteAnimationInit.set(0, 6);
                defaultSprite = playerLeftDefault;
                stop();
                break;

            case KeyEvent.VK_RIGHT:
                spriteAnimationInit.set(0, 6);
                defaultSprite = playerRightDefault;
                stop();
                break;
            case KeyEvent.VK_E:
                spriteAnimationInit.set(0, 6);
                spriteAnimationInit.set(2, 2);
                spriteAnimationInit.set(3, 2);
                spriteAnimationInit.set(4, 2);
                spriteAnimationInit.set(5, 2);

                if (spriteAnimationInit.get(1) == 0 && (spriteAnimationInit.get(2) == 2)) {
                    defaultSprite = playerUpDefault;
                }
                if (spriteAnimationInit.get(1) == 1 && (spriteAnimationInit.get(3) == 2)) {
                    defaultSprite = playerDownDefault;
                }
                if (spriteAnimationInit.get(1) == 2 && (spriteAnimationInit.get(4) == 2)) {
                    defaultSprite = playerLeftDefault;
                }
                if (spriteAnimationInit.get(1) == 3 && (spriteAnimationInit.get(5) == 2)) {
                    defaultSprite = playerRightDefault;
                }
                setAttack(0);
                break;

        }
    }
    private void moveUP() {
        CenterY -= Speed;
    }

    private void moveDown() {
        CenterY += Speed;
    }

    private void moveRight() {
        CenterX += Speed;
    }

    private void moveLeft() {
        CenterX -= Speed;
    }

    private void stop() {
    }

    public BufferedImage getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(BufferedImage playerImage) {
        this.playerImage = playerImage;
    }

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

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    private  void Attack() {
        int playerX = getCenterX();
        int playerY = getCenterY();
        double distance = Math.sqrt(Math.pow(playerX - slime.getCenterX(), 2) + Math.pow(playerY - slime.getCenterY(), 2));
        if(distance < 10){
            setAttack(1);
           slime.Health = slime.Health - getAttack();
        }
    }
    public void EnemyFollow(){
        int playerX = getCenterX();
        int playerY = getCenterY();

        double distance = Math.sqrt(Math.pow(playerX - slime.getCenterX(), 2) + Math.pow(playerY - slime.getCenterY(), 2));
        System.out.println(distance);

        if (distance < 55) {
            double angle = Math.atan2(playerY - slime.getCenterY(), playerX - slime.getCenterX());
            slime.CenterX += Math.cos(angle) * slime.getSpeed();
            slime.CenterY += Math.sin(angle) * slime.getSpeed();
        }
    }
}








