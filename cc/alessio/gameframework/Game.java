package cc.alessio.gameframework;

/**
 * Created by alessio on 2/10/14.
 */
public class Game {
    private GameObjectPool goPool;
    private ScenePool scenePool;
    private Scene currentScene;
    private Renderer renderer;
    private Input input;
    private Time time;

    private boolean running = false;
    private boolean paused = false;

    public Game(Renderer renderer, Input input) {
        goPool = new GameObjectPool();
        scenePool = new ScenePool();
        this.renderer = renderer;
        this.input = input;
        time = new Time();
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
        if (paused)
            onPause();
        else
            onResume();
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isPaused() {
        return  paused;
    }

    protected void onPause() {}

    protected void onResume() {}

    public Input getInput() {
        return input;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public Time getTime() {
        return time;
    }

    public void setScene(String id) {
        setRunning(false);
        if (currentScene != null)
            currentScene.close();
        currentScene = scenePool.get(id);
        currentScene.start();
        setRunning(true);
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public double getDeltaTime() {
        return time.getDeltaTime();
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

    public GameObject removeGameObject(GameObject obj) {
        return goPool.remove(obj.getId());
    }

    public Scene getScene(String id) {
        return scenePool.get(id);
    }

    public void update() {
        onUpdate();
        currentScene.update();
        postUpdate();
    }

    public void draw() {
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
        time.init();
        while(running) {
            time.update();
            input.executeEvents();
            time.executeEvents();
            update();
            draw();
        }
    }
}
