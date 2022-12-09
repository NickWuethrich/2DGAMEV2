import Entity.Player;
import Entity.Slime;
import GameArea.Background;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainExecution extends JApplet implements Runnable {
    private BufferedImage image, enemy1;
    private final int panelHeight = 1080;
    private final int panelWidth = 1920;
    private int SpriteScale = 3;
    private Graphics second;
    Player player = new Player();
    Slime slime = new Slime();

    @Override
    public void init() { // init will run like a main method for Applet
        setSize(panelWidth, panelHeight);
        // setBackground(Color.BLACK);
        add(new DrawPanel());
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();// no idea how this works
        frame.setTitle("2DGame");
        player.loadPlayerImageCharacter();
        addKeyListener(player);
        try {
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
                Thread.sleep(8);// sleep for 17 1000/60 = 17 approx, game will update every 17 miliseconds
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
        g2d.scale(SpriteScale, SpriteScale);
        g2d.drawImage(enemy1, slime.getXpos(), slime.getYPos(), null);
       //  draw(g2d);
    }

    public void draw(Graphics2D graphics2D) {
        player.paint(graphics2D);

    }
      class DrawPanel extends JPanel{
        public DrawPanel (){
            setBackground(Color.BLACK);
        }

        public  void  paintComponent(Graphics  g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.scale(SpriteScale,SpriteScale);
            player.paint(g2d);
        }


      }

}
