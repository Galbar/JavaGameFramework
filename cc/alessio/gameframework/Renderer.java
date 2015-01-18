package cc.alessio.gameframework;

/**
 * Created by alessio on 3/10/14.
 */
public interface Renderer {

    public void setClearColor(Color color);

    public void clear();

    public void drawLine(int x, int y, int x2, int y2, Color color);

    public void drawRect(int x, int y, int width, int height, Color color);

    public void drawImage(int image, int x, int y, double width, double height, double degrees);

    public void drawImage(int image, int x, int y, double degrees);

    public void drawImage(int image, int x, int y, double scale, double degrees);

    void drawText(String text, int x, int y, int size,  Color color);

    public int getWidth();

    public int getHeight();

    public void display();
}
