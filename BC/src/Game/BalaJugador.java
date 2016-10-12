package Game;

import Obstaculo.Arboles;
import Obstaculo.ParedLadrillos;
import PowerUp.Estrella;
import PowerUp.Granada;
import Tanques.Tanque;

public class BalaJugador extends Bala{

	public BalaJugador(Celda celdita, Tanque f, int dir, Logica lg) {
		super(celdita, f, dir, lg);
		
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

	@Override
	public boolean visitarLadrillo(ParedLadrillos p) {
		 boolean destruir = p.decrementarResistencia();
		 if(destruir){
			 p.setGrafico();
			 lg.eliminarBloque(p.getCelda().getFila(), p.getCelda().getCol());
		 }
		return false;
	}

}
