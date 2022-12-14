import Entity.Player;
import GameArea.Background;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainExecution extends JApplet implements Runnable {
    private BufferedImage image, enemy1;
    private final int panelHeight = 1200;
    private final int panelWidth = 1600;
    private int SpriteScale = 2;
    private Graphics second;
   Player player = new Player(150 , 150);
   Background background = new Background();
   //Slime slime = new Slime(150, 150,1,player);

    // testCommit

    @Override
    public void init() { // init will run like a main method for Applet
        setSize(panelWidth, panelHeight);
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();// no idea how this works
        frame.setTitle("2DGame");
        addKeyListener(player);
        add(new DrawPanel());
    }
    @Override
    public void start() {
        Thread thread = new Thread(this);// "this" connects run method to thread
        thread.start();// we need run method from Runnable interface to start thread
    }
    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }

    // updates Characters
    // updated Environment
    // repaint the scene
    // Sleep for 17 miliseconds
    @Override
    public void run() {
        while (true) {
            repaint();
            update();
            try {
                Thread.sleep(17);// sleep for 17 1000/60 = 17 approx, game will update every 17 miliseconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }



    public void update() {
         player.update();
       // slime.update();
    }

      class DrawPanel extends JPanel{
        JPanel panel = new JPanel();
        public DrawPanel (){
            setBackground(Color.BLACK);
        }

        public  void  paintComponent(Graphics  g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.scale(SpriteScale,SpriteScale);
           background.paintBackround(g2d);
            //slime.paintCharacters(g2d);
            player.paintCharacters(g2d);
            g.dispose();
            g2d.dispose();

        }


      }
}
