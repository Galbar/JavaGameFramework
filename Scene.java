package rocks.alessio.GameEngine;

/**
 * Created by alessio on 2/10/14.
 */
public class Scene extends GameObject {

    public Scene(Game game, String id) {
        super(game, id);
        game.addScene(this);
    }

    public Scene(Game game, String id, GameObject parent) {
        super(game, id, parent);
        game.addScene(this);
    }
}
