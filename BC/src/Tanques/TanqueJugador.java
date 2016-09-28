package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;

public class TanqueJugador extends Tanque{
	
	protected int nivel;
	protected int disparos_simul;
	protected State estado;
	
	public TanqueJugador(Celda celdita) {
		super(celdita);
		nivel = 1;
		estado = new Nivel1(this);
		
		
	}
	
	public void cargarImagen(int n, String s){
		String a = "/Imagenes/" + s;
		image[n] = new ImageIcon(this.getClass().getResource("/Imagenes/" + s));
		
	}
	
	public void cambiarEstado(int n){
		switch(n){
		
		case 1:
			estado = new Nivel1(this);
			nivel = 1;
			break;
		case 2:
			estado = new Nivel2(this);
			nivel = 2;
			break;
		
		}
	}
	
	public void setNivel(int n){
		nivel = n;
	}
	
	public int getNivel(){
		return nivel;
	}
	
	
	
}
