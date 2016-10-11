package Tanques;

import javax.swing.ImageIcon;

import Game.Bala;
import Game.Celda;
import Game.Visitante;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.PowerUp;

public class TanqueJugador extends Tanque implements Visitante{
	
	protected int nivel;
	protected int disparos_simul;
	protected State estado;
	protected int dir;
	
	public TanqueJugador(Celda celdita) {
		super(celdita);
		nivel = 1;
		estado = new Nivel1(this);
		dir = 0;
		
		
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
	
	public int getDir(){
		return dir;
	}
	
	public Bala disparo(){
		Celda celdita = null;
		int x=this.getCelda().getFila();
		int y=this.getCelda().getCol();
	
		switch(dir){
		case 0: celdita = new Celda(x+1,y);
		}
		Bala nueva = new Bala(celdita, this, dir);
		return nueva;
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
