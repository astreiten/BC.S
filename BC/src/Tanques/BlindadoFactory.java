package Tanques;

import Game.Celda;
import Game.Logica;

public class BlindadoFactory  extends TanqueFactory {

	public TanqueEnemigo crearTanque(Celda celdita,Inteligencia IA, Logica lg){
		return new TanqueBlindado(celdita,IA,lg);
	}
}
