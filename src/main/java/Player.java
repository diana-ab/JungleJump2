import javax.swing.*;
import java.awt.*;

public class Player {
    public static final int PLAYER_SIZE = 80;
    public static final int JUMP_FORCE = -6;
    public static final double GRAVITY = 0.5;
    public static final int START_X = MainFrame.WINDOW_WIDTH / 2 - PLAYER_SIZE / 2;
    public static final int START_Y = MainFrame.WINDOW_HEIGHT - (PLAYER_SIZE * 2);
    public static final int MOVE_SPEED = 10;

    private int playerX;
    private int playerY;
    private int ySpeed;
    private boolean isJumping;
    private boolean movingLeft;
    private boolean movingRight;

    private Image monkeyStandingImage;
    private Image monkeyJumpingImage;

    public Player() {
        this.playerX = START_X;
        this.playerY = START_Y;
        this.ySpeed = 0; //speed will help us determine if the player is jumping or falling.
        // in other words the velocity or speed at which the player's Y is growing or decreasing.
        // the player's speed starts from 0 because he's standing still at the start.
        //by adding speed to Y we will know the location of the player:
        // adding to it gravity which is 0<g means the Y grows and the player is falling.
        //adding to it jump force which is 0>jf means that the Y shrinks and the player is jumping.
        this.movingLeft = false;
        this.movingRight = false;
        this.isJumping = true;

        monkeyStandingImage = new ImageIcon(getClass().getResource("images/monkey_standing.jpg")).getImage();
        monkeyJumpingImage = new ImageIcon(getClass().getResource("images/monkey_jumping.jpg")).getImage();
    }

    public void setMovingLeft(boolean moving) {
        this.movingLeft = moving;
    }
    // למה ב- ?SET למה לא להגדיר מהירות קבועה בתוך המשתנה
    public void setMovingRight(boolean moving) {
        this.movingRight = moving;
    } // I wanted to make a key listener that changes these variables to true

    public void updateAction() {
        this.ySpeed += GRAVITY;
        this.playerY += this.ySpeed;

        if (movingRight) {
            this.playerX += MOVE_SPEED; //because of this update action method I wanted to add a key listener.... somewhere that sends true
        }
        if (movingLeft) {
            this.playerX -= MOVE_SPEED; //needs to receive true to work form some listener
        }

        if (this.ySpeed < 0) {

            this.isJumping = true;// Determine if currently jumping or falling

        } else {
            this.isJumping = false; //יש פה בעיה נראלי עם הלוגיקה איםושהו בשחקן
            
        }// זה מוזר אני לא מבין את הבעיה
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
        graphics.drawImage(currentImage, playerX, playerY, PLAYER_SIZE, PLAYER_SIZE, null);
    }
}
