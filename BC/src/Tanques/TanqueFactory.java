package Tanques;

import Game.Celda;
import Game.Logica;

public abstract class TanqueFactory {

	public abstract TanqueEnemigo crearTanque(Celda celdita,Inteligencia IA, Logica lg);
	
}
