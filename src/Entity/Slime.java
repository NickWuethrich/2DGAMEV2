package Entity;

import static java.lang.Math.abs;

public class Slime extends Enemy {
    public Slime(){
        setXpos(150);
        setYPos(200);
    }
    public Slime(int x,int y){
        this.setXpos(x);
        this.setYPos(y);
    }


    @Override
    public void update() {
        super.update();
    }

    public void paintEntity(){

    }

    @Override
    public void EnemyMovement() {
        super.EnemyMovement();
        setSpeed(2);
        }
    }

















