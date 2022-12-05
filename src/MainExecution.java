import Entity.Player;
import Entity.Slime;
import GameArea.Background;
import GameArea.GameAreaCell;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainExecution extends JApplet implements Runnable{
    private static Background bg;
    private BufferedImage character, background,enemy1;
    Timer timer;
    private int SpriteScale = 2;
    Player player = new Player();
    Slime slime = new Slime();


    @Override
    public void init() { // init will run like a main method for Applet
        setSize(768, 576);
        setBackground(Color.BLACK);
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();// no idea how this works
        frame.setTitle("2DGame");
        player.loadPlayerImageCharacter();
        addKeyListener(player);
        try {
         //    character = ImageIO.read(getClass().getResource("/resources/images/PlayerSprites/tile000.png"));
            background = ImageIO.read((getClass().getResource("/resources/images/background.png")));
            enemy1 = ImageIO.read(getClass().getResource("/resources/images/SlimeSprites/tile000.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
    @Override
    public void start() {
        Thread thread = new Thread(this);// "this" connects run method to thread
        thread.start();// we need run method from Runnable interface to start thread
    }
    @Override
    public void stop() {}
    @Override
    public void destroy() {}

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
        slime.update();

    }


      @Override
    public void paint(Graphics g) {
       super.paint(g);
       Graphics2D g2d = (Graphics2D) g;
          g2d.scale(SpriteScale,SpriteScale);
        g2d.drawImage(enemy1,slime.getXpos(), slime.getYPos(), null);
              player.paint(g2d);



    }
}
