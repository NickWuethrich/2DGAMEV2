import java.awt.*;

public class Enemy {

    private Image character;
    private int Health;
    private int NewHealth;
    private int Strength;
    protected int Speed;
    private int SpeStrength;
    protected int Xpos;
    protected int YPos;

    public void update(){


    }

    public void attack(){

    }

    public void die(){

    }

    public void EnemyMovement(){

    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getNewHealth() {
        return NewHealth;
    }

    public void setNewHealth(int newHealth) {
        NewHealth = newHealth;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getSpeStrength() {
        return SpeStrength;
    }

    public void setSpeStrength(int speStrength) {
        SpeStrength = speStrength;
    }

    public int getXpos() {
        return Xpos;
    }

    public void setXpos(int xpos) {
        Xpos = xpos;
    }

    public int getYPos() {
        return YPos;
    }

    public void setYPos(int YPos) {
        this.YPos = YPos;
    }
}
