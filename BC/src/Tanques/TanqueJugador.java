package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;

public class TanqueJugador extends Tanque{
	
	protected int nivel;
	protected int disparos_simul;
	protected State estado;
	
	public TanqueJugador(Celda celdita) {
		super(celdita);
		estado = new Nivel1(this);
		
		
	}
	
	public void cargarImagen(int n, String s){
		String a = "/Imagenes/" + s;
		image[n] = new ImageIcon(this.getClass().getResource("/Imagenes/" + s));
		
	}
	
	
	
}
