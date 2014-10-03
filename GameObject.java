package rocks.alessio.GameEngine;

import java.util.ArrayList;
/**
 * Created by alessio on 2/10/14.
 */
public class GameObject {
    private String id;
    private final Game game;
    private GameObject parent;
    private ArrayList<GameObject> children = new ArrayList<GameObject>();

    public GameObject(Game game, String id) {
        this.game = game;
        this.id = id;
        this.parent = null;
        this.game.addGameObject(this);
    }

    public GameObject(Game game, String id, GameObject parent) {
        this.game = game;
        this.id = id;
        this.parent = parent;
        this.game.addGameObject(this);
    }

    protected void onUpdate(float deltaTime) {}

    protected void onDraw(Renderer renderer) {}

    public void update(float deltaTime) {
        onUpdate(deltaTime);
        for (int i = 0; i < children.size(); i++) {
            children.get(i).update(deltaTime);
        }
    }

    public void draw(Renderer renderer) {
        onDraw(renderer);
        for (int i = 0; i < children.size(); i++) {
            children.get(i).draw(renderer);
        }
    }

    public String getId() {
        return id;
    }
}
