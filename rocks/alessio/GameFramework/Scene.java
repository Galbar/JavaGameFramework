package rocks.alessio.GameFramework;

/**
 * Created by alessio on 2/10/14.
 */
public class Scene extends GameObject {

    public Scene(Game game, String id) {
        super(game, id);
        game.addScene(this);
    }

    public void close() {}

    public void start() {}
}
