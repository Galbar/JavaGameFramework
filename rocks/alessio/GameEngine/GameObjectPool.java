package rocks.alessio.GameEngine;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by alessio on 2/10/14.
 */
public class GameObjectPool extends ConcurrentSkipListMap<String, GameObject> {
    public GameObject put(GameObject obj) {
        return super.put(obj.getId(), obj);
    }
    // public GameObject get(String id) {}
    // public GameObject remove(String id) {}
}

