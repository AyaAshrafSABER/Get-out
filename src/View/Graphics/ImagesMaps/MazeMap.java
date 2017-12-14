package View.Graphics.ImagesMaps;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class MazeMap {

    private static volatile MazeMap instance;
    private static Object mutex = new Object();

    private Map<String, Image> images;

    private MazeMap() {
        images = new HashMap<>();
        constructLayer();
    }

    public static MazeMap getInstance() {
        MazeMap result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new MazeMap();
            }
        }
        return result;
    }

    public void constructLayer() {

        images.put("Bricks", new Image("Bricks.png"));
        images.put("TreeWall",new Image("TreeWall.png"));
        images.put("WoodWall",new Image("WoodWall1.png"));
        images.put("SteelWall", new Image("SteelWall.jpg"));
        images.put("GrassRoad", new Image("GrassRoad.png"));
        images.put("GreyRoad", new Image("GreyRoad.png"));
//        images.put("WoodWall2", new Image("WoodWall2.png"));
    }

    public Image getBufferedImage(String key) {
        return images.get(key);
    }

}
