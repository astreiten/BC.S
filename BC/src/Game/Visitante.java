package Game;

import PowerUp.Estrella;
import Obstaculo.*;
import PowerUp.Granada;
import Tanques.*;


public interface Visitante {
	
	public boolean visitar(Granada gra);
	public boolean visitarEst(Estrella est);
	public boolean visitarArbol(Arboles arb);
	public boolean visitarLadrillo(ParedLadrillos p);
	public boolean visitarEnemigo(TanqueEnemigo t);

}
