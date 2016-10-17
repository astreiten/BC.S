package Tanques;

import javax.swing.ImageIcon;

import Game.Bala;
import Game.BalaJugador;
import Game.Celda;
import Game.Visitante;
import Obstaculo.Arboles;
import Obstaculo.ParedLadrillos;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.PowerUp;
import Game.*;
public class TanqueJugador extends Tanque implements Visitante{
	
	protected int nivel;
	protected int disparos_simul;
	protected State estado;
	
	

	public TanqueJugador(Celda celdita, Logica lg) {
		super(celdita, lg);
		nivel = 1;
		estado = new Nivel1(this);
		dir = 0;
		disparos_simul = 1;
		realizados = 0;
		
		
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
			disparos_simul = 2;			
			break;
		
		}
	}
	
	public void setNivel(int n){
		nivel = n;
	}
	
	public int getNivel(){
		return nivel;
	}
	
	
	
	public Bala disparo(){
		if(realizados < disparos_simul){
		Celda celdita = null;
		int x=this.getCelda().getFila();
		int y=this.getCelda().getCol();
	
		switch(dir){
		case 0: celdita = new Celda(x-1,y);
		break;
		
		case 1: celdita = new Celda(x+1,y);
		break;
		case 2: celdita = new Celda(x, y-1);
		break;
		case 3: celdita = new Celda(x, y+1);
		break;
		}
		
		Bala nueva = new BalaJugador(celdita, this, dir, lg);
		realizados++;
		return nueva;
		}
		return null;
		
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

	@Override
	public boolean visitarArbol(Arboles arb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarLadrillo(ParedLadrillos p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarEnemigo(TanqueEnemigo t) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}
