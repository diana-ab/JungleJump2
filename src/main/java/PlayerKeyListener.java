import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyListener implements KeyListener {
    private Player player;
    private GamePanel gamePanel;

    public PlayerKeyListener(Player player, GamePanel gamePanel) {
        this.player = player;
        this.gamePanel=gamePanel;

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.setMovingLeft(true); //need to change it from being hard coded later
            this.gamePanel.repaint();
            System.out.println("presd");
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.setMovingRight(true);
            this.gamePanel.repaint();
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

