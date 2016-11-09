package Tanques;

import Game.Celda;
import Game.Logica;

public class RapidoFactory extends TanqueFactory {

	public TanqueEnemigo crearTanque(Celda celdita,Inteligencia IA, Logica lg){
		return new TanqueRapido(celdita,IA,lg);
	}
}
