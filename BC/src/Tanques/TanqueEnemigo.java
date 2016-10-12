package Tanques;

import Game.Celda;
import Game.Logica;
import Game.Visitante;

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
	
	@Override
	public boolean acept(Visitante v) {
		v.visitarEnemigo(this);
		System.out.println("Quiero aceptar");
		return false;
	}
	
	public boolean decrementarResistencia(){
		resistencia--;
		System.out.println("Res "+ resistencia);
	
		return resistencia == 0;
	}
	
}
