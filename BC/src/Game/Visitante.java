package Game;

import PowerUp.Estrella;
import PowerUp.Granada;

public interface Visitante {
	public boolean visitar(Granada gra);
	public boolean visitarEst(Estrella est);

}
