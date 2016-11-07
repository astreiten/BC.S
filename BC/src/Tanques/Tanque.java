package Tanques;

import javax.swing.ImageIcon;
import Game.*;

public abstract class Tanque extends GameObject {

	protected int resistencia;
	protected int vel_dispa;
	protected int puntos;
	protected int dir;
	protected Logica lg;
	protected int realizados;
	protected int disparos_simul;
	protected boolean movilidad;

	public Tanque(Celda celdita, Logica l) {
		super(celdita);
		lg = l;
		image[4] = new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.gif"));
		image[5] = new ImageIcon(
				this.getClass().getResource("/Imagenes/picasion.com_33e3de578cf843c270f5c3d7c53c79a1.gif"));

		movilidad = true;
	}

	public void setImagen(int indice) {
		grafico.setIcon(image[indice]);
		grafico.setBounds(celda.getCol() * 50, celda.getFila() * 50, 50, 50);

	}

	public void setDir(int n) {
		dir = n;
	}

	public int getDir() {
		return dir;
	}

	public int getRes() {
		return resistencia;
	}

	public boolean colision(GameObject obj) {
		return false;
	}

	public int getPuntos() {
		return puntos;
	}

	public void decrementarRealizados() {
		realizados--;
	}

	public Bala disparo() {
		// Poner condiciones para no disparar en bordes
		if (realizados < disparos_simul) {
			Celda celdita = null;
			int x = this.getCelda().getFila();
			int y = this.getCelda().getCol();

			switch (dir) {
			case 0:
				if (x == 0) {
					return null;
				}
				celdita = new Celda(x - 1, y);
				break;

			case 1:
				if (x == 12) {
					return null;
				}
				celdita = new Celda(x + 1, y);
				break;
			case 2:
				if (y == 0) {
					return null;
				}
				celdita = new Celda(x, y - 1);
				break;
			case 3:
				if (y == 12) {
					return null;
				}
				celdita = new Celda(x, y + 1);
				break;
			}

			Bala nueva = crearBala(celdita, this, dir, lg);
			realizados++;
			return nueva;
		}
		return null;

	}

	public boolean getMovilidad() {
		return movilidad;
	}

	public abstract int getSleep();

	public abstract Bala crearBala(Celda celdita, Tanque t, int dir, Logica lg);

	public void setMovilidad(boolean a) {
		movilidad = a;
	}

}
