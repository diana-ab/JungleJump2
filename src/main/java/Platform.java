import javax.swing.*;
import java.awt.*;

public class Platform  {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 20;

    private int platformX;
    private int platformY;
    private Image platformImage;
    private int gravity;


    public Platform(int platformX, int platformY,int gravity) {
        this.platformX = platformX;
        this.platformY = platformY;
        this.gravity=gravity;
        this.platformImage = new ImageIcon(getClass().getResource("images/platform.png")).getImage();

    }
    // צריך לבצע פו מתודה שכול הזמן תגרום לפלטפורמות לזוז כלפי מטה אולי כמו שעשינו בפרויקט השני המטרה היא שזה כול הזמן זה יעשה זאת
    // וברגע שהשחקן קופץ צריך לעדכן איך שהוא בחוץ את הSET שיצרתי פו וככה הוא יגרום לזה לזוז בהתאם

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

    public void setPlatformX(int gravity) {
        this.platformX +=gravity;
    }
}


