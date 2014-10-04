package rocks.alessio.GameFramework;

/**
 * Created by alessio on 2/10/14.
 */
public class Game {
    private GameObjectPool goPool;
    private ScenePool scenePool;
    private Scene currentScene;
    private Renderer renderer;
    private Input input;

    private boolean running = false;
    private float deltaTime = 0;

    public Game(Renderer renderer, Input input) {
        goPool = new GameObjectPool();
        scenePool = new ScenePool();
        this.renderer = renderer;
        this.input = input;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Input getInput() {
        return input;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setScene(String id) {
        currentScene.close();
        currentScene = scenePool.get(id);
        currentScene.start();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public float getDeltaTime() {
        return deltaTime;
    }

    public void addGameObject(GameObject obj) {
        goPool.put(obj);
    }

    public void addScene(Scene scene) {
        scenePool.put(scene);
    }

    public GameObject getGameObject(String id) {
        return goPool.get(id);
    }

    public Scene getScene(String id) {
        return scenePool.get(id);
    }

    private void update() {
        input.executeEvents();
        onUpdate();
        currentScene.update();
        postUpdate();
    }

    private void draw() {
        renderer.clear();
        onDraw();
        currentScene.draw();
        postDraw();
        renderer.display();
    }

    protected void onUpdate() {}

    protected void postUpdate() {}

    protected void onDraw() {}

    protected void postDraw(){}

    public void run() {
        running = true;
        long startTime = System.nanoTime();
        while(running) {
            deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
            startTime = System.nanoTime();

            update();
            draw();
        }
    }
}
