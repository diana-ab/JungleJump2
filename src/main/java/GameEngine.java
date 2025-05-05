import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameEngine extends Thread {
    public static final int SLEEP = 80;
    public static final int COLLISION_THRESHOLD = 15;






    private Player player;
    private List<Platform> platforms;
    private GamePanel gamePanel;
    private boolean running;
    private PlatformManager platformManager;
    private int middlePanel;


    public GameEngine(GamePanel gamePanel, Player player) {
        this.gamePanel = gamePanel;
        this.middlePanel =gamePanel.getHeight()/2;
        this.player = player;
        this.platforms = new ArrayList<>();
        this.running = true;
        platformManager=new PlatformManager(gamePanel);
        this.platforms=platformManager.getPlatforms();



    }


    private boolean isPlayerLanding(Player player1, Platform platform1) {
        Rectangle playerLegs = new Rectangle(
                player1.getPlayerX(),
                 player1.getPlayerY()+player1.getPlayerHeight() - COLLISION_THRESHOLD,
                player1.getPlayerWidth(), COLLISION_THRESHOLD);

        Rectangle platformHead = new Rectangle(
                platform1.getPlatformX(),
                platform1.getPlatformY()
                , platform1.getWidth(), COLLISION_THRESHOLD);
        if (playerLegs.intersects(platformHead) && player1.getYSpeed() >= 0) {
            System.out.println("Landed!");

            return true;
        } else {
            return false;
        }

    }

    private void playerJumpIfNeeded(){
        for (Platform platform: this.platforms){
        if (isPlayerLanding(this.player,platform )) {
            System.out.println("CHEK");
            this.player.jump();
        }
    }}

    private void scrollPanel(){// פה יש באג
        int gravity =0;

        if(calculateDistance()){
             gravity = -this.player.getYSpeed();
        }

        platformManager.scrollPlatformsDown(gravity);

    }
    private void scrollPlayer(){
        int yDistance = 0;
        if (calculateDistance()){
            int feetLocation=this.player.getPlayerY()+this.player.getPlayerHeight();
            yDistance= this.middlePanel-feetLocation;
        }
        this.player.setPlayerY(yDistance);

    }

    private boolean calculateDistance(){
        if(this.player.getPlayerY()+this.player.getPlayerHeight()
                <this.middlePanel && this.player.getYSpeed()<0){return true;}
        return false;

    }


    public void run() {
        while (this.running) {
            this.player.updateAction();
            this.scrollPanel();
            this.scrollPlayer();
            this.platformManager.generatePlatformsIfNeeded();
            playerJumpIfNeeded();
            this.gamePanel.repaint();
            try {

                this.sleep(SLEEP);
            } catch (RuntimeException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }





    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}