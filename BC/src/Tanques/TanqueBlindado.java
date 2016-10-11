package Tanques;

import Game.Celda;
import Game.Visitante;
import PowerUp.Estrella;
import PowerUp.Granada;

public class TanqueBlindado extends TanqueEnemigo{

	public TanqueBlindado(Celda celdita, Inteligencia IA) {
		super(celdita, IA);
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

}
