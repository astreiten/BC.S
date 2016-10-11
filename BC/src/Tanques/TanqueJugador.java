package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.Visitante;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.PowerUp;

public class TanqueJugador extends Tanque implements Visitante{
	
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
	
	public void cambiarEstado(){
		int n = nivel;
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








	@Override
	public boolean visitar(Granada gra) {
		gra.afectar();
		return true;
	}

	@Override
	public boolean acept(Visitante v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarEst(Estrella est) {
		est.afectar();
		return true;
	}

	
	
	
}
