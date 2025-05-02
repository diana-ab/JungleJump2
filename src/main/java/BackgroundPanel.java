import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image background;

    public BackgroundPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.background =
                new ImageIcon(getClass().getResource("images/background.png")).getImage();

    }

    public void setBackground(Image background) {
        this.background = background;
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (background != null) {
            graphics.drawImage(this.background, this.getX(), this.getY(),
                    this.getWidth(), this.getHeight(), this);
        }
    }

}
