package Tanques;
import Game.*;
import java.util.Random;

public class Inteligencia {
	protected int dir;
	protected Logica lg;
	protected TanqueEnemigo esteTanque;
	
	public Inteligencia(Logica log,TanqueEnemigo tanque)
	{
		dir=1;
		lg=log;
		esteTanque=tanque;
	}
	public void mover()
	{
		if (lg.moverTanque(dir,esteTanque)==true){}
		else
		{
			Random r = new Random();
			dir =  1 + (int)(Math.random() * 4); 
		}
	}

}
