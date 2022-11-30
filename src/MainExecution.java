import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainExecution extends JApplet implements Runnable , KeyListener {

    // private Player player;
    private static Background bg;
    private Image image, character, background,verybadenemy;
    private URL url;
    private Graphics second;
    Player player = new Player();

    VeryBadEnemy veryBadEnemy1 = new VeryBadEnemy(150, 150);

    //framework from Applet supperclass
    @Override
    public void init() { // init will run like a main method for Applet
        setSize(800, 480);
        setBackground(Color.WHITE);
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();// no idea how this works
        frame.setTitle("2DGame");
        addKeyListener(this);

        try {
            url = getCodeBase();
        } catch (Exception e) {
            System.out.println("no image");


        }
        try {
            character = ImageIO.read(getClass().getResource("/resources/images/NinjaWalk3.png"));
            //background = ImageIO.read((getClass().getResource("/resources/images/background.png")));
            verybadenemy = ImageIO.read(getClass().getResource("/resources/images/tile004.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void start() {
        Thread thread = new Thread(this);// "this" connects run method to thread
        thread.start();// we need run method from Runnable interface to start thread
        //player = new Player();
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

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                player.moveUP();
                veryBadEnemy1.EnemyMovement();

                System.out.println(veryBadEnemy1.getXpos());
                System.out.println("---------------------------------");
                System.out.println(player.getCenterY());
                break;

            case KeyEvent.VK_DOWN:
                player.moveDown();
                System.out.println("Moving Down");
                System.out.println(player.getCenterY());
                break;

            case KeyEvent.VK_LEFT:
                player.moveLeft();
                System.out.println(player.getCenterX());
                break;

            case KeyEvent.VK_RIGHT:
                player.moveRight();
                System.out.println(player.getCenterX());
                break;

            case KeyEvent.VK_SPACE:
                player.jump();
                System.out.println("Jumping");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                player.stop();
                break;

            case KeyEvent.VK_DOWN:
                player.stop();
                break;

            case KeyEvent.VK_LEFT:
                player.stop();
                break;

            case KeyEvent.VK_RIGHT:
                player.stop();
                break;
            case KeyEvent.VK_SPACE:
                break;

        }
    }

    public void update() {
        player.update();
        veryBadEnemy1.update();



    }


    //  @Override
    public void paint(Graphics g) {
        super.paint(g);
        //g2.drawRect(player.getCenterX(), player.getCenterY(), 40,40);

        //.clearRect(player.getCenterX(), player.getCenterY(), 40,40);
        g.drawImage(verybadenemy,veryBadEnemy1.getXpos(), veryBadEnemy1.getYPos(), null);
        g.drawImage(character, player.getCenterX(), player.getCenterY(), null);
        //g.drawImage(background, 150, 150, this);
        g.dispose();


    }
}
