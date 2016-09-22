package Tanques;

import Game.Celda;

public abstract class TanqueEnemigo extends Tanque{
	
	protected Inteligencia IA;
	protected int puntos;
	
	public TanqueEnemigo(Celda celdita,Inteligencia IA) {
		super(celdita);
		this.IA = IA;
		
	}

	public Inteligencia getIA() {
		return IA;
	}
	
}
