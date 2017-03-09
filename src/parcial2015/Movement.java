package parcial2015;

import java.io.Serializable;

public class Movement implements Serializable {
	public int emisor;
	public String data;

	public Movement(int emisor,String data) {
		this.emisor=emisor;
		this.data = data;
	}
	
	public int getEmisor() {
		return emisor;
	}

	public void setEmisor(int emisor) {
		this.emisor = emisor;
	}

	public String getContenido() {
		return data;
	}

	public void setContenido(String data) {
		this.data = data;
	}
}

