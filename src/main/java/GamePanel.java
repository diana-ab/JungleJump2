import java.awt.*;

public class GamePanel extends BackgroundPanel{


    private GameEngine gameEngine;
    private Player player;



    public GamePanel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.player = new Player();
        this.gameEngine = new GameEngine(this, this.player);

        PlayerKeyListener keyListener = new PlayerKeyListener(this.player);
        this.addKeyListener(keyListener);
        this.setFocusable(true);

    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.player.draw(graphics);


    }
}
