package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;

public class TanqueJugador extends Tanque{
	
	protected int nivel;
	protected int disparos_simul;
	
	public TanqueJugador(Celda celdita) {
		super(celdita);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Tanque.gif"));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/JugadorAb.gif"));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/JugadorIzq.gif"));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/JugadorDer.gif"));
		
	}
	
}
