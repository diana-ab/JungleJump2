import javax.swing.*;
import java.awt.*;

public class Platform  {
    public static final int PLATFORM_WIDTH = 100;
    public static final int PLATFORM_HEIGHT = 20;

    private int platformX;
    private int platformY;
    private Image platformImage;



    public Platform(int platformX, int platformY) {
        this.platformX = platformX;
        this.platformY = platformY;

        this.platformImage = new ImageIcon(getClass().getResource("images/platform.png")).getImage();

    }

    public void draw(Graphics g) {
        g.drawImage(platformImage, platformX, platformY, PLATFORM_WIDTH, PLATFORM_HEIGHT, null);
    }




    public int getPlatformX() {
        return platformX;
    }

    public int getPlatformY() {
        return platformY;
    }

    public int getWidth() {
        return PLATFORM_WIDTH;
    }

    public int getHeight() {
        return PLATFORM_HEIGHT;
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


