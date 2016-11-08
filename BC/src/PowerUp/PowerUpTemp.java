package PowerUp;

import Game.Celda;
import Game.Logica;

public abstract class PowerUpTemp extends PowerUp{

	public PowerUpTemp(Celda celdita, Logica l) {
		super(celdita, l);
	
	}
	
	public abstract void desafectar();

}
