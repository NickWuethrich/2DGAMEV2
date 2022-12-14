package Entity;

import java.awt.*;
import java.util.Random;

public abstract class Enemy extends Entity {
    protected int CenterX;
    protected  int CenterY;
    protected  Player player;
    private int Speed;
    private Random random;

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
    public Enemy(int CenterX, int CenterY, int Speed){
        this.CenterX = CenterX;
        this.CenterY = CenterY;
        this.Speed = Speed;
        //this.player = player;
        random = new Random();
    }
    public abstract  void attack();

    public abstract  void die();


    public void EnemyMovement() {
        int rand = random.nextInt(100);
        if (rand == 1|| rand == 2)
            CenterX += Speed;
        if (rand == 6)
            CenterY-= Speed;
        if (rand == 3 || rand == 4)
            CenterY += Speed;
        if (rand == 5 )
            CenterX -= Speed;
    }
    public void EnemyFollow(){
        int playerX = player.getCenterX();
        int playerY = player.getCenterY();

        double distance = Math.sqrt(Math.pow(playerX - getCenterX(), 2) + Math.pow(playerY - getCenterY(), 2));

        if (distance < 55) {
            double angle = Math.atan2(playerY - getCenterY(), playerX - getCenterX());
            CenterX += Math.cos(angle) * getSpeed();
            CenterY += Math.sin(angle) * getSpeed();
        }
    }
    public abstract void paintCharacters(Graphics g);


}
