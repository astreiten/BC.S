package Tanques;

import Game.Celda;
import Game.Logica;

public class PoderFactory extends TanqueFactory {

	public TanqueEnemigo crearTanque(Celda celdita,Inteligencia IA, Logica lg){
		return new TanquePoder(celdita,IA,lg);
	}
}
