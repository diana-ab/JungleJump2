import java.awt.*;

public class GamePanel extends BackgroundPanel{


    private GameEngine gameEngine;
    private Player player;




    public GamePanel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.player = new Player();

        this.gameEngine = new GameEngine(this, this.player);
        this.gameEngine.start();

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new PlayerKeyListener(this.player, this));


    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.player.draw(graphics);

        for (Platform platform : this.gameEngine.getPlatforms()){
            platform.draw(graphics);
        }


        if (this.player.getPlayerX() > this.getWidth()) {
            this.player.setPlayerX(this.getX() - this.player.getPlayerWidth());
        }
        else if (this.player.getPlayerX() + this.player.getPlayerWidth() < this.getX()) {
            this.player.setPlayerX(this.getWidth());
        }


    }
}
