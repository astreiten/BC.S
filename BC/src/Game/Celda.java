package Game;
import Tanques.Tanque;
import Obstaculo.ParedLadrillos;

public class Celda {
	protected int fila,columna;
	// protected Tanque tanque;
	protected GameObject objeto;
	
	public Celda(int f,int c){
		fila = f;
		columna = c;
	}
	
	public Celda(int f, int c, GameObject obj){
		fila = f;
		columna = c;
		objeto = obj;
	}
	
	public GameObject getObstaculo(){
		return objeto;
	}
	public int getFila(){
		return fila;
	}
	
	public int getCol(){
		return columna;
	}
	
	public void setObject ( GameObject obj){
		objeto = obj;
		
	}
		
	public String toString()
	{
		if (objeto == null)
		{
			return " piso "  ;
		}
		else
		{
			if (objeto instanceof ParedLadrillos)
			{
				return " ladrillos ";
			}
		}
		return "asd";
		
	}
	
}
