package Tanques;

import Game.Celda;
import Game.Logica;

public class BasicoFactory extends TanqueFactory {

	public TanqueEnemigo crearTanque(Celda celdita,Inteligencia IA, Logica lg){
		return new TanqueBasico(celdita,IA,lg);
	}
}
