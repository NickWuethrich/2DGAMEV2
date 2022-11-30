import java.awt.*;

public class Player {
    private Image playerCharacter;
    private int defaultXPosition = 100;
    private int DefaultYPosition = 380;
    private int WindowEnd;
    private int CenterX = 100;
    private int CenterY = 380;
    private boolean jump = false;

    private int speedX = 0;
    private int speedY = 0;

    public int getDefaultXPosition() {
        return defaultXPosition;
    }

    public void setDefaultXPosition(int defaultXPosition) {
        this.defaultXPosition = defaultXPosition;
    }

    public int getDefaultYPosition() {
        return DefaultYPosition;
    }

    public void setDefaultYPosition(int defaultYPosition) {
        DefaultYPosition = defaultYPosition;
    }

    public int getWindowEnd() {
        return WindowEnd;
    }

    public void setWindowEnd(int windowEnd) {
        WindowEnd = windowEnd;
    }

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

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }



    public void update() {

        if(CenterX <= 6) {
            CenterX = 6;
        }
        if (CenterX >= 756){
            CenterX = 750;
        }
        if (CenterY <= 6)
            CenterY = 6;

        if (CenterY >= 420){
            CenterY = 420;
        }
        speedX = 6;
        speedY = 6;
        moveUP();
        moveDown();
        moveRight();
        moveLeft();




    }






    public void moveUP(){
        CenterY -= speedY;

    }

    public void moveDown(){
        CenterY += speedY;


    }

    public void moveRight() {
        CenterX += speedX;
    }

    public void moveLeft() {
        CenterX -= speedX;
    }

    public void stop() {
        speedX = 0;
    }

    public void jump() {
        if (jump == false) {
            speedY = -15;
            jump = true;
        }

    }

    public void paintPlayer(){

    }
}




