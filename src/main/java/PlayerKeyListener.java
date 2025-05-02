import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyListener implements KeyListener {
    private Player player;

    public PlayerKeyListener(Player player) {
        this.player = player;

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.setMovingLeft(true); //need to change it from being hard coded later

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.setMovingRight(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.setMovingLeft(false); //need to change it from being hard coded later

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.setMovingRight(false);
        }
    }

}

