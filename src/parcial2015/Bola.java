package parcial2015;

import processing.core.PApplet;

public class Bola {

	private PApplet app;
	private int x, y;

	public Bola(PApplet app, int x, int y) {
		this.app = app;
		this.x = x;
		this.y = y;
	}

	public void pintar() {
		app.noStroke();
		app.fill(220,150,0);
		app.ellipse(x, y, 30, 30);
	}
}
