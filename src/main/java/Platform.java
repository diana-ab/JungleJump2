import javax.swing.*;
import java.awt.*;

public class Platform  {
    public static final int PLATFORM_WIDTH = 100;
    public static final int PLATFORM_HEIGHT = 20;

    private int platformX;
    private int platformY;
    private Image platformImage;
    private int platformWidth;
    private int platformHeight;



    public Platform(int platformX, int platformY) {
        this.platformX = platformX;
        this.platformY = platformY;
        this.platformHeight=PLATFORM_HEIGHT;
        this.platformWidth=PLATFORM_WIDTH;

        this.platformImage = new ImageIcon(getClass().getResource("images/platform.png")).getImage();

    }

    public void draw(Graphics g) {
        g.drawImage(platformImage, platformX, platformY, this.platformWidth,
                this.platformHeight, null);
    }




    public int getPlatformX() {
        return platformX;
    }

    public int getPlatformY() {
        return platformY;
    }

    public int getWidth() {
        return this.platformWidth;
    }

    public int getHeight() {
        return this.platformHeight;
    }

    public void setPlatformX(int platformX) {
        this.platformX = platformX;
    }

    public void setPlatformY(int platformY) {
        this.platformY = platformY;
    }
     public void moveDown(int gravity){
        this.platformY += gravity;

     }
}


