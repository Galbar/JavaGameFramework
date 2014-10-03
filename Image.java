package rocks.alessio.GameEngine;

import rocks.alessio.GameEngine.Renderer.ImageFormat;

/**
 * Created by alessio on 3/10/14.
 */

public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}