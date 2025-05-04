import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 800;
    public static final int WINDOW_X = 0;
    public static final int WINDOW_Y = 0;


    private CardLayout cardLayout;
    private Container container;

    public MainFrame() {
        this.setTitle("JUNGLE JUMP");
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.container = getContentPane();
        this.container.setLayout(this.cardLayout);

        Menu menu = new Menu(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.container.add(menu, ScreenNames.MENU);
        this.cardLayout.show(this.container, ScreenNames.MENU);

        GamePanel gamePanel = new GamePanel(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.container.add(gamePanel, ScreenNames.GAME);

        menu.setStartButtonAction(e -> {
            this.cardLayout.show(this.container,ScreenNames.GAME);
            gamePanel.requestFocusInWindow();// זה גורם לכך שהפאנל ידרוש פוקוס בתוך החלון שלו ללא זה המקשים לא יעבדו
        });
    }
}
