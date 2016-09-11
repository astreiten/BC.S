package Game;
import Tanques.Tanque;
import Obstaculo.ParedLadrillos;

public class Celda {
	protected int fila,columna;
	// protected Tanque tanque;
	protected GameObject objeto;
	
	public Celda(int f, int c, GameObject obj){
		fila = f;
		columna = c;
		objeto = obj;
	}
		
	public String toString()
	{
		if (objeto==null)
		{
			return "piso";
		}
		else
		{
			if (objeto instanceof ParedLadrillos)
			{
				return "ladrillos";
			}
		}
		return "asd";
		
	}
	
}
