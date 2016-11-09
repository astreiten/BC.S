package PowerUp;

import Game.Celda;
import Game.GameObject;
import Game.Logica;
import Tanques.TanqueEnemigo;

public abstract class PowerUp extends GameObject {

	protected Logica lg;
	protected boolean agarrado;
	protected int puntaje;

	public PowerUp(Celda celdita, Logica l) {
		super(celdita);
		lg = l;
		agarrado = false;
		puntaje=500;
	}

	public void setAgarrado(boolean a) {
		agarrado = a;
	}
	public boolean getAgarrado() {
		return agarrado;
	}
	public int getPuntaje()
	{
		return puntaje;
	}

}
