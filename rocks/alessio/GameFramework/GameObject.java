package rocks.alessio.GameFramework;

import java.util.ArrayList;
/**
 * Created by alessio on 2/10/14.
 */
public class GameObject {
    private String id;
    protected final Game game;
    protected GameObject parent;
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
        parent.addChild(this);
        this.game.addGameObject(this);
    }

    public void setParent(GameObject newParent) {
        if (newParent.children.indexOf(this) == -1) {
            if (parent != null)
                parent.removeChild(this);
            parent = newParent;
            parent.children.add(this);
        }
    }

    public void addChild(GameObject newChild) {
        newChild.setParent(this);
    }

    public void removeChild(GameObject child) {
        children.remove(child);
        child.parent = null;
    }

    protected void onUpdate() {}

    protected void postUpdate() {}

    protected void onDraw() {}

    protected void postDraw() {}

    public void update() {
        onUpdate();
        for (int i = 0; i < children.size(); i++) {
            children.get(i).update();
        }
        postUpdate();
    }

    public void draw() {
        onDraw();
        for (int i = 0; i < children.size(); i++) {
            children.get(i).draw();
        }
        postDraw();
    }

    public String getId() {
        return id;
    }
}
