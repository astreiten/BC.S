package Tanques;

import Game.Celda;
import Game.Logica;
import Game.Visitante;
import Obstaculo.Aguila;
import Obstaculo.Arboles;
import Obstaculo.ParedLadrillos;
import PowerUp.Casco;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.Pala;
import PowerUp.Reloj;
import PowerUp.TanquePw;

public class TanqueBlindado extends TanqueEnemigo{

	public TanqueBlindado(Celda celdita, Inteligencia IA, Logica lg) {
		super(celdita, IA, lg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean acept(Visitante v) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public int getSleep() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVd() {
		// TODO Auto-generated method stub
		return 0;
	}

}
