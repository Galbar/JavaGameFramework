package rocks.alessio.GameEngine;

/**
 * Created by alessio on 3/10/14.
 */
public interface Renderer {

    public Image newImage(String fileName);

    public void clearScreen(int color);

    public void drawLine(int x, int y, int x2, int y2, int color);

    public void drawRect(int x, int y, int width, int height, int color);

    public void drawImage(Image image, int x, int y, int srcX, int srcY,
                          int srcWidth, int srcHeight);

    public void drawImage(Image Image, int x, int y);

    void drawText(String text, int x, int y);

    public int getWidth();

    public int getHeight();

    public void drawARGB(int i, int j, int k, int l);

}
