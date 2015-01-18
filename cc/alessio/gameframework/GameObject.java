package cc.alessio.gameframework;

import java.util.ArrayDeque;
import java.util.ArrayList;
/**
 * Created by alessio on 2/10/14.
 */
public class GameObject {
    private String id;
    private boolean _isClosed = true;
    protected final Game game;
    protected GameObject parent;
    protected ArrayList<GameObject> children = new ArrayList<GameObject>();

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
                parent.removeChild(this, false);
            parent = newParent;
            parent.children.add(this);
        }
    }

    public void addChild(GameObject newChild) {
        newChild.setParent(this);
    }

    public void removeChild(GameObject child) {
        removeChild(child, true);
    }

    public void removeChild(GameObject child, boolean close) {
        if (!child._isClosed && close)
            child.close();
        children.remove(child);
        child.parent = null;
    }

    public void removeChild(int childId) {
        removeChild(childId, true);
    }

    public void removeChild(int childId, boolean close) {
        GameObject child = children.get(childId);
        if (!child._isClosed && close)
            child.close();
        children.remove(child);
        child.parent = null;
    }

    public int numberOfChildren() {
        return children.size();
    }

    protected void onUpdate() {}

    protected void postUpdate() {}

    protected void onDraw() {}

    protected void postDraw() {}

    protected void onStart() {}

    protected void postStart() {}

    protected void onClose() {}

    protected void postClose() {}

    public void update() {
        onUpdate();
        ArrayDeque<GameObject> toRemove = new ArrayDeque<GameObject>();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i)._isClosed)
                toRemove.add(children.get(i));
            else
                children.get(i).update();
        }
        while (!toRemove.isEmpty()) {
            removeChild(toRemove.poll());
        }
        postUpdate();
    }

    public void draw() {
        onDraw();
        for (int i = 0; i < children.size(); i++) {
            if (!children.get(i)._isClosed)
                children.get(i).draw();
        }
        postDraw();
    }

    public void start() {
        if (!_isClosed)
            close();
        onStart();
        for (GameObject child : children) {
            child.start();
        }
        _isClosed = false;
        postStart();
    }

    public void close() {
        onClose();
        for (GameObject child : children) {
            child.close();
        }
        children.clear();
        game.removeGameObject(this);
        _isClosed = true;
        postClose();
    }

    public String getId() {
        return id;
    }
}
