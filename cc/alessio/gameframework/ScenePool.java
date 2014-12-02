package cc.alessio.gameframework;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by alessio on 2/10/14.
 */
public class ScenePool extends ConcurrentSkipListMap<String, Scene> {
    public Scene put(Scene scene) {
        return super.put(scene.getId(), scene);
    }
    // public GameObject get(String id) {}
    // public GameObject remove(String id) {}
}
