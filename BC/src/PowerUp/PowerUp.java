package PowerUp;

import Game.Celda;
import Game.GameObject;
import Game.Logica;
import Tanques.TanqueEnemigo;

public abstract class PowerUp extends GameObject{
	
	protected Logica lg;

	public PowerUp(Celda celdita, Logica l) {
		super(celdita);
		lg = l;
	}
	
}
