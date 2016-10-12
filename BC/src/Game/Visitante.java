package Game;

import PowerUp.Estrella;
import Obstaculo.*;
import PowerUp.Granada;

public interface Visitante {
	
	public boolean visitar(Granada gra);
	public boolean visitarEst(Estrella est);
	public boolean visitarArbol(Arboles arb);

}
