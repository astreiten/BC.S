package Tanques;

import Game.Celda;
import Game.Logica;

public abstract class TanqueEnemigo extends Tanque{
	
	protected Inteligencia IA;
	protected int puntos;
	
	public TanqueEnemigo(Celda celdita,Inteligencia IA, Logica lg) {
		super(celdita,lg);
		this.IA = IA;
		
	}

	public Inteligencia getIA() {
		return IA;
	}
	
}
