package Tanques;
import Game.*;
import java.util.Random;

public class Inteligencia {
	protected int dir;
	protected Logica lg;
	protected TanqueEnemigo esteTanque;
	
	public Inteligencia(Logica log)
	{
		dir=1;
		lg=log;
	}
	public void mover()
	{
		if (lg.moverTanque(dir,esteTanque)==true){
			System.out.println("MOVI EN LA MISMA");
		}
		else
		{
			Random r = new Random();
			dir =  0 + (int)(Math.random() * 4);
			System.out.println("CAMBIE LA DIRECCION.AHORA ES"+dir);
		}
	}

	public void setTanque(TanqueEnemigo tanq){
		esteTanque = tanq;
	}
}
