package PowerUp;

import Game.Celda;
import Game.GameObject;
import Tanques.TanqueEnemigo;

public abstract class PowerUp extends GameObject{

	public PowerUp(Celda celdita) {
		super(celdita);
		// TODO Auto-generated constructor stub
	}
	
	public boolean colision(TanqueEnemigo tan){
		return true;
	}
}
