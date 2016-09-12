package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;

public abstract class Tanque extends GameObject{
	public Tanque(Celda celdita) {
		super(celdita);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/JugadorArriba.png"));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/JugadorAbajo.png"));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/JugadorIzquierda.png"));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/JugadorDerecha.png"));
	}
	protected int resistencia;
	protected int vel_dispa;
}
