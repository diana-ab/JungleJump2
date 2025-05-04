import java.awt.*;

public class GamePanel extends BackgroundPanel{


    private GameEngine gameEngine;
    private Player player;
    private Platform platformCHEK;



    public GamePanel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.player = new Player();
        this.platformCHEK =new Platform(200,400,1);
        this.gameEngine = new GameEngine(this, this.player, platformCHEK);
        this.gameEngine.start();

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new PlayerKeyListener(this.player, this));


    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.player.draw(graphics);
        this.platformCHEK.draw(graphics);

        if (this.player.getPlayerX() > this.getWidth()) {
            this.player.setPlayerX(this.getX() - this.player.PLAYER_SIZE);
        }
        else if (this.player.getPlayerX() + this.player.PLAYER_SIZE < this.getX()) {
            this.player.setPlayerX(this.getWidth());
        }


    }
}
