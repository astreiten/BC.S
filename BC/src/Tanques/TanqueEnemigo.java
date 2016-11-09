package Tanques;

import Game.Bala;
import Game.BalaEnemigo;
import Game.BalaJugador;
import Game.Celda;
import Game.Logica;
import Game.Visitante;

public abstract class TanqueEnemigo extends Tanque{
	
	protected Inteligencia IA;
	protected int puntos;
	
	public TanqueEnemigo(Celda celdita,Inteligencia IA, Logica lg) {
		super(celdita,lg);
		this.IA = IA;
		disparos_simul = 1;
		
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
	
	public Bala crearBala(Celda celdita, Tanque t, int dir, Logica lg){
		return new BalaEnemigo(celdita,t,dir,lg);
	}
	public int getPuntos()
	{
		return puntos;
	}
	
	
}
