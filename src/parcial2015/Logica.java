package parcial2015;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Logica implements Observer {

	private PApplet app;
	private Comunicacion c;
	private final String GROUP_ADDRESS = "226.24.6.7";

	private int id;
	private boolean start;

	private ArrayList<Bola> bolas;
	private ArrayList<Cuadrado> quads;

	public Logica(PApplet app) {
		this.app = app;

		c = new Comunicacion();
		Thread nt = new Thread(c);
		nt.start();

		c.addObserver(this);

		if (c.getId() != 0) {
			id = c.getId();
		}

		bolas = new ArrayList<Bola>();
		quads = new ArrayList<Cuadrado>();
	}

	public void pintar() {

		if (app.frameCount % 12 == 0) {
			start = true;
		}

		app.fill(255);
		app.stroke(1);
		app.rectMode(PApplet.CENTER);
		app.rect(app.width / 2, 50, 30, 30);
		app.fill(0);
		app.textAlign(PApplet.CENTER);
		app.text(id, app.width / 2, 55);

		for (int i = 0; i < bolas.size(); i++) {
			bolas.get(i).pintar();
		}

		for (int i = 0; i < quads.size(); i++) {
			quads.get(i).pintar();
		}

		if (app.mousePressed) {
			if (id == 1) {
				try {
					c.enviar(new Movement(id, app.mouseX + ":" + app.mouseY), GROUP_ADDRESS);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (id == 2) {
				try {
					c.enviar(new Movement(id, "eliminar"), GROUP_ADDRESS);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (id == 3) {
				try {
					c.enviar(new Movement(id, app.mouseX + ":" + app.mouseY), GROUP_ADDRESS);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			start = false;
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Movement) {
			Movement mov = (Movement) arg;

			if (mov.getEmisor() == 1) {
				String[] pos = mov.getContenido().split(":");
				int xE = Integer.parseInt(pos[0]);
				int yE = Integer.parseInt(pos[1]);
				bolas.add(new Bola(app, xE, yE));
			}

			if (mov.getEmisor() == 2) {
				bolas.clear();
				quads.clear();
			}

			if (mov.getEmisor() == 3) {
				String[] pos = mov.getContenido().split(":");
				int xE = Integer.parseInt(pos[0]);
				int yE = Integer.parseInt(pos[1]);
				quads.add(new Cuadrado(app, xE, yE));
			}

		}
	}
}
