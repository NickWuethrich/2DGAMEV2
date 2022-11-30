import static java.lang.Math.abs;

public class VeryBadEnemy extends Enemy{
    Player player = new Player();

    private int speed1;


    public VeryBadEnemy(int x ,int y){
        setXpos(x);
        setYPos(y);


    }

    @Override
    public void update() {
        if(Xpos<= 6) {
            Xpos = 6;
        }
        if (Xpos>= 756){
            Xpos = 750;
        }
        if (YPos<= 6)
            YPos = 6;

        if (YPos >= 420){
            YPos = 420;
        }
        EnemyMovement();

    }

    public void paintEntity(){


    }

    @Override
    public void EnemyMovement() {

        if  (Math.abs(player.getCenterX() - Xpos) > 1) {
            Xpos += speed1;


        }else if (Math.abs(player.getCenterY() - YPos) > 1) {
            YPos += speed1;
        }


    }


       // while  (player.getCenterY()-getYPos()> 2)
              //YPos -= getSpeed();













}

