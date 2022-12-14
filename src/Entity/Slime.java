package Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

public class Slime extends Enemy{

    protected int Attack;
    protected int Health = 2;
    private boolean Alive = true;
    private BufferedImage slime,slime1,slime2,slime3,slime4,slime5,slime6,slimeDeath,slimeDeath1,slimeDeath2,slimeDeath3,slimeDeath4,slimeDeath5,slimeDeath6;
    private Random random;
    List<BufferedImage> slimeImages = new ArrayList<BufferedImage>();
    public Slime(int CenterX,int CenterY,int Speed) {
        super(CenterX,CenterY,Speed);
        this.loadSlimeImage();
        this.slimeImageList();
    }
    @Override
    public void attack() {

    }
    @Override
    public void die() {
        if(getHealth() <= 0 ){
            setAlive(false);

        }

    }
    private void loadSlimeImage(){
        try {
            defaultSprite = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile000.png"));
            slime = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile011.png"));
            slime1 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile001.png"));
            slime2 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile002.png"));
            slime3 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile003.png"));
            slime4 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile007.png"));
            slime5 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile008.png"));
            slime6 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile011.png"));

            slimeDeath = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile023.png"));
            slimeDeath1 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile023.png"));
            slimeDeath2= ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile028.png"));
            slimeDeath3= ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile029.png"));
            slimeDeath4 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile030.png"));
            slimeDeath5= ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile031.png"));
            slimeDeath6= ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile032.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void slimeImageList(){
        slimeImages.add(slime1);
        slimeImages.add(slime2);
        slimeImages.add(slime3);
        slimeImages.add(slime4);
        slimeImages.add(slime5);
        slimeImages.add(slime6);

        slimeImages.add(slimeDeath1);
        slimeImages.add(slimeDeath2);
        slimeImages.add(slimeDeath3);
        slimeImages.add(slimeDeath4);
        slimeImages.add(slimeDeath5);
        slimeImages.add(slimeDeath6);
    }
    @Override
    public void update() {
        slimeSpriteInit();
        die();
        EntityAnimation(slime,slimeImages,0,5);
        EntityAnimation(slimeDeath,slimeImages,6,11);
        EnemyMovement();

    }
    public void paintCharacters(Graphics g) {
        g.drawImage(defaultSprite, getCenterX(), getCenterY(), null);
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

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }


    private void slimeSpriteInit(){
        if(isAlive()){
            defaultSprite = slime;
        }else{
            defaultSprite = slimeDeath;
        }

    }
    public void Attack() {

    }
}




















