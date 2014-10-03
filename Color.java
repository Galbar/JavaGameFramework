package rocks.alessio.GameEngine;

/**
 * Created by alessio on 3/10/14.
 */
public class Color {
	private int r;
	private int g;
	private int b;
	private int a;

	public Color(int r, int g, int b) {
		this.r = r & 0xff;
		this.g = g & 0xff;
		this.b = b & 0xff;
		this.a = 255;
	}

	public Color(float r, float g, float b) {
		this.r = (int)(r * 255.0) & 0xff;
		this.g = (int)(g * 255.0) & 0xff;
		this.b = (int)(b * 255.0) & 0xff;
		this.a = 255;
	}

	public Color(int r, int g, int b, int a) {
		this.r = r & 0xff;
		this.g = g & 0xff;
		this.b = b & 0xff;
		this.a = a & 0xff;
	}
	
	public Color(float r, float g, float b, float a) {
		this.r = (int)(r * 255.0) & 0xff;
		this.g = (int)(g * 255.0) & 0xff;
		this.b = (int)(b * 255.0) & 0xff;
		this.a = (int)(a * 255.0) & 0xff;
	}

	public int getRi() {
		return r;
	}

	public int getGi() {
		return g;
	}

	public int getBi() {
		return b;
	}

	public int getAi() {
		return a;
	}

	public int getRf() {
		return (float)r/255.0;
	}

	public int getGf() {
		return (float)g/255.0;
	}

	public int getBf() {
		return (float)b/255.0;
	}

	public int getAf() {
		return (float)a/255.0;
	}
}
