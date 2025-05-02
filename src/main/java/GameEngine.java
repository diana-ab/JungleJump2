import java.util.ArrayList;

public class GameEngine extends Thread {
    public static final int SLEEP = 20;
    private Player player;
    private ArrayList<Platform> platforms;
    private GamePanel gamePanel;
    private boolean running;

    public GameEngine(GamePanel gamePanel, Player player){
        this.gamePanel = gamePanel;
        this.player = player;
        this.platforms = new ArrayList<>();
        this.running = true;
        //need to create generate platforms method to add here...
        this.start();



    }

    public void run(){ // this is the game loop.
        while(this.running){
            try {
                this.player.updateAction();
                this.player.jump();


                this.gamePanel.repaint();


                this.sleep(SLEEP);
            } catch (RuntimeException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    } //1.need to update the player inside the game loop: apply gravity and movement.
    //2.move platforms down as player moves up. 3.check for collisions with platforms and reset jump if needed.
    //4. remove platforms that go off-screen? ---> repaint screen... gamePanel.repaint I think.
    //how to detect platform to player collisions? ... loop through all platforms in list > if players bottom touches
    // platform top AND player is falling, reset ySpeed? and allow jumping again... idk how to do this
    // drawing will be done in Game panel in the paint component -> player.draw , loop through platforms and call draw on each

    private void generatePlatforms(){
        //need to use random object to create platforms at different x-positions and y intervals
        //gotta add them to the platforms list
        //gotta avoid hard-coding... can generate platforms based on the screen height and adjust as the player moves up
    }

    //need platform generator.
    //need to remove platforms from the bottom.
    //player input method to decide how to handle the player movement.
    // ? do we need to add a stop game method : running = false (?)
    //
}