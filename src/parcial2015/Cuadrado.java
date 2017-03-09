package parcial2015;

import processing.core.PApplet;

public class Cuadrado {
	private PApplet app;
	private int x, y;

	public Cuadrado(PApplet app, int x, int y) {
		this.app = app;
		this.x = x;
		this.y = y;
	}

	public void pintar() {
		app.noFill();
		app.stroke(30, 50, 180);
		app.rectMode(PApplet.CENTER);
		app.rect(x, y, 30, 30);
	}
}
