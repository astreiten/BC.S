package Game;

import javax.swing.ImageIcon;


import Tanques.*;

public abstract class Bala extends GameObject {

	protected int direccion;
	protected Tanque fuente;
	protected Logica lg;
	protected boolean movilidad;

	public Bala(Celda celdita, Tanque f, int dir, Logica l) {
		super(celdita);
		fuente = f;
		direccion = dir;
		lg = l;
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaUp.png"));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaDw.png"));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaIzq.png"));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaDer.png"));
		image[4] = new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.gif"));
		movilidad = true;

	}

	public int getDir() {
		return direccion;
	}

	public Tanque getFuente() {
		return fuente;
	}

	public void setMovilidad(boolean a) {
		movilidad = a;
	}

	public boolean getMovilidad() {
		return movilidad;
	}

}
