package Entity;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public abstract class Interaction {
    private  Player player;
    private  Slime slime;
    public Interaction (){
        this.player = new Player(150, 150);
        this.slime = new Slime(100 , 100, 1 );
        addKeyListener(player);
    }
}
