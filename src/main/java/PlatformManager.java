import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PlatformManager {
    public static final int PLATFORM_VERTICAL_SPACING = 100;

    private List<Platform> platforms;
    private GamePanel gamePanel;

    public PlatformManager(GamePanel gamePanel) {
        this.platforms = new ArrayList<>();
        this.gamePanel = gamePanel;
    }

    public void generatePlatformsIfNeeded() {
        Random random = new Random();
        int highestY = this.gamePanel.getHeight();
        if (!this.platforms.isEmpty()) {
            for (Platform platform : this.platforms) {
                if (platform.getPlatformY() < highestY) {
                    highestY = platform.getPlatformY();
                }
            }
        }

        while (highestY >= this.gamePanel.getY() - Platform.PLATFORM_HEIGHT) {
            int highestX = random.nextInt(this.gamePanel.getWidth() - Platform.PLATFORM_WIDTH);

            if (!isOverlappingPlatform(highestX, highestY)) {

                this.platforms.add(new Platform(highestX, highestY));

            }
            highestY -= random.nextInt(PLATFORM_VERTICAL_SPACING / 10) + PLATFORM_VERTICAL_SPACING;
        }
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    private boolean isOverlappingPlatform(int x, int y) {
        Rectangle newPlatformRect = new Rectangle(x, y, this.gamePanel.getWidth(), Platform.PLATFORM_HEIGHT);
        for (Platform platform : this.platforms) {
            Rectangle existingPlatform = new Rectangle(platform.getPlatformX()
                    , platform.getPlatformY(), this.gamePanel.getWidth(), Platform.PLATFORM_HEIGHT);
            if (newPlatformRect.intersects(existingPlatform)) {
                return true;
            }
        }
        return false;
    }

    public void scrollPlatformsDown(int gravity) {
        ArrayList<Platform> toRemove = new ArrayList<>();
        for (Platform platform : this.platforms) {
            platform.moveDown(gravity);
            if (platform.getPlatformY() > this.gamePanel.getHeight()) {
                toRemove.add(platform);
            }
        }


        this.platforms.removeAll(toRemove);
        this.generatePlatformsIfNeeded();

    }

}
