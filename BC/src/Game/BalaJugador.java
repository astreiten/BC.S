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
		 int aux = p.getResistencia();
		 switch(aux){
		 case 3: p.setImagen(3);
		 break;
		 case 2: p.setImagen(2);
		 break;
		 case 1: p.setImagen(1);
		 break;
		 }
		 if(destruir){
			 p.setGrafico();
			 lg.eliminarBloque(p.getCelda().getFila(), p.getCelda().getCol());
		 }
		return false;
	}

}
