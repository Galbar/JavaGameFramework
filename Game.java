package rocks.alessio.GameEngine;

/**
 * Created by alessio on 2/10/14.
 */
public class Game {
    public GameObjectPool goPool;
    public ScenePool scenePool;
    private final String initSceneId;
    private Scene currentScene;
    private Renderer renderer;
    //private Audio audio;
    //private Input input;

    private boolean running = false;

    public Game(String id, Scene initScene, Renderer renderer/*, Audio audio, Input input*/) {
        goPool = new GameObjectPool();
        scenePool = new ScenePool();
        currentScene = initScene;
        initSceneId = initScene.getId();
        this.renderer = renderer;
        //this.audio = audio;
        //this.input = input;
        init();
    }

    //public Audio getAudio() {}

    //public Input getInput() {}

    //public FileIO getFileIO(){}?????

    public Renderer getRenderer() {
        return renderer;
    }

    public void setScene(String id) {
        currentScene = scenePool.get(id);
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public Scene getInitScene() {
        return scenePool.get(initSceneId);
    }

    public void addGameObject(GameObject o) {
        goPool.put(o);
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

    private void update(float deltaTime) {
        currentScene.update(deltaTime);
    }

    private void draw() {
        currentScene.draw(renderer);
    }

    public void init() {}

    public void onUpdate(float deltaTime) {}

    public void onDraw(Renderer renderer){}

    public void run() {
        running = true;
        long startTime = System.nanoTime();
        while(running) {
            float deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
            startTime = System.nanoTime();

            onUpdate(deltaTime);
            update(deltaTime);
            onDraw(renderer);
            draw();
        }
    }
}
