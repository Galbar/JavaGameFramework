package rocks.alessio.GameEngine;

import java.util.concurrent.ConcurrentSkipListMap;

public class ScenePool extends ConcurrentSkipListMap<String, Scene> {
    public Scene put(Scene scene) {
        return super.put(scene.getId(), scene);
    }
    // public GameObject put(String id, GameObject o) {}
    // public GameObject get(String id) {}
    // public GameObject remove(String id) {}
}
