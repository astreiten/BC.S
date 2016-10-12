package Game;

import Obstaculo.Arboles;
import PowerUp.Estrella;
import PowerUp.Granada;
import Tanques.Tanque;

public class BalaJugador extends Bala{

	public BalaJugador(Celda celdita, Tanque f, int dir) {
		super(celdita, f, dir);
		
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
	public boolean colision(GameObject obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarArbol(Arboles arb) {
		// TODO Auto-generated method stub
		return false;
	}

}
