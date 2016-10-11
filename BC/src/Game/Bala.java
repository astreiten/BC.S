package Game;

import javax.swing.ImageIcon;

import PowerUp.Estrella;
import PowerUp.Granada;
import Tanques.*;

public class Bala extends GameObject {
	
	protected int direccion;
	protected Tanque fuente;

	public Bala(Celda celdita, Tanque f, int dir) {
		super(celdita);
		fuente = f;
		direccion = dir;
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaUp.gif" ));
		
	}
	
	public int getDir(){
		return direccion;
	}

	@Override
	public boolean acept(Visitante v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitar(Granada gra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarEst(Estrella est) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean colision(GameObject obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
