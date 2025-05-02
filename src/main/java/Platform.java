import javax.swing.*;
import java.awt.*;

public class Platform {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 20;

    private int platformX;
    private int platformY;
    private Image platformImage;

    public Platform(int platformX, int platformY) {
        this.platformX = platformX;
        this.platformY = platformY;
        this.platformImage = new ImageIcon(getClass().getResource("images/platform.png")).getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(platformImage, platformX, platformY, WIDTH, HEIGHT, null);
    }

    public int getPlatformX() {
        return platformX;
    }

    public int getPlatformY() {
        return platformY;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}


