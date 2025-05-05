import javax.swing.*;
import java.awt.*;

public class Player  {
    public static final int PLAYER_HEIGHT = 80;
    public static final int PLAYER_WIDTH = 80;

    public static final int JUMP_FORCE = -16;
    public static final int GRAVITY = 1;
    public static final int MOVE_SPEED = 20;

    private int playerX;
    private int playerY;
    private int playerHeight;
    private int playerWidth;
    private int ySpeed;
    private boolean isJumping;
    private boolean movingLeft;
    private boolean movingRight;



    private Image monkeyStandingImage;
    private Image monkeyJumpingImage;

    public Player(int startX,int startY) {
        this.playerX = startX;
        this.playerY = startY;
        this.playerHeight= PLAYER_HEIGHT;
        this.playerWidth= PLAYER_WIDTH;
//        this.playerFeet=this.playerY+this.playerHeight;
        this.ySpeed = 0;
        this.movingLeft = false;
        this.movingRight = false;
        this.isJumping = true;

        monkeyStandingImage = new ImageIcon(getClass().getResource("images/monkey_standing.jpg")).getImage();
        monkeyJumpingImage = new ImageIcon(getClass().getResource("images/monkey_jumping.jpg")).getImage();
    }

    public void setMovingLeft(boolean moving) {
        this.movingLeft = moving;
    }
    public void setMovingRight(boolean moving) {
        this.movingRight = moving;
    }

    public void updateAction() {
        this.ySpeed += GRAVITY;
        this.playerY += this.ySpeed;

        if (this.movingRight) {
            this.playerX += MOVE_SPEED; //because of this update action method I wanted to add a key listener.... somewhere that sends true
        }
        if (this.movingLeft) {
            this.playerX -= MOVE_SPEED; //needs to receive true to work form some listener
        }

        if (this.ySpeed < 0) {

            this.isJumping = true;
        } else {
            this.isJumping = false;

        }
    }

    public void jump() {
        ySpeed = JUMP_FORCE;
    }

    public void draw(Graphics graphics) {
        Image currentImage;
        if (this.isJumping) {
            currentImage = monkeyJumpingImage;
        } else {
            currentImage = monkeyStandingImage;
        }
        graphics.drawImage(currentImage, this.playerX, this.playerY, this.playerWidth, this.playerHeight, null);
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getYSpeed() {
        return ySpeed;
    }



    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerY(int playerY) {
        this.playerY  +=playerY;
    }
}
