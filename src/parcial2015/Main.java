package parcial2015;

import processing.core.PApplet;

public class Main extends PApplet{
	
	private Logica app;
	
	public static void main(String[] args){
		PApplet.main("parcial2015.Main");
	}
	
	@Override
	public void settings(){
		size(400,400);
	}
	
	@Override
	public void setup(){
		app = new Logica(this);
	}
	
	@Override
	public void draw(){
		background(255);
		app.pintar();
	}

}
