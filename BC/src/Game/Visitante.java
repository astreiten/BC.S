package Game;

import PowerUp.Casco;
import PowerUp.Estrella;
import Obstaculo.*;
import PowerUp.Granada;
import PowerUp.Pala;
import PowerUp.Reloj;
import Tanques.*;


public interface Visitante {
	
	public boolean visitar(Granada gra);
	public boolean visitarEst(Estrella est);
	public boolean visitarArbol(Arboles arb);
	public boolean visitarLadrillo(ParedLadrillos p);
	public boolean visitarEnemigo(TanqueEnemigo t);
	public boolean visitarJugador(TanqueJugador t);
	public boolean visitarCasco(Casco c);
	public boolean visitarReloj(Reloj r);
	public boolean visitarPala(Pala p);
	


}
