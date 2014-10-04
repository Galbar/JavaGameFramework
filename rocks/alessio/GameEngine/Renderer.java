package rocks.alessio.GameEngine;

/**
 * Created by alessio on 3/10/14.
 */
public interface Renderer {

    public void setClearColor(Color color);

    public void clear();

    public void drawLine(int x, int y, int x2, int y2, Color color);

    public void drawRect(int x, int y, int width, int height, Color color);

    public void drawImage(Image image, int x, int y, int srcX, int srcY,
                          int srcWidth, int srcHeight);

    public void drawImage(Image image, int x, int y);

    void drawText(String text, int x, int y, Color color);

    public int getWidth();

    public int getHeight();

    public void display();
}
