package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Logica;
import Game.Visitante;
import PowerUp.Casco;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.Pala;
import PowerUp.Reloj;
import PowerUp.TanquePw;
import Tanques.TanqueEnemigo;
import Tanques.TanqueJugador;

public class Aguila extends Obstaculo {
	
	private Logica  lg;
	
	public Aguila(Celda celdita, Logica l) {
		super(celdita);
		lg = l;
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Eagle.png"));
		// TODO Auto-generated constructor stub
	}
	
	public boolean colision(GameObject obj){
		return false;
	}

	@Override
	public boolean acept(Visitante v) {
	
		return v.visitarAguila(this);
	}

	@Override
	public boolean visitar(Granada gra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarEst(Estrella est) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public boolean visitarJugador(TanqueJugador t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarCasco(Casco c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarReloj(Reloj r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarPala(Pala p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarTanquePw(TanquePw t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarAguila(Aguila a) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void morir(){
		lg.gameOver();
	}


}
