package Game;

import javax.swing.ImageIcon;

import PowerUp.Estrella;
import PowerUp.Granada;
import Tanques.*;

public abstract class Bala extends GameObject {
	
	protected int direccion;
	protected Tanque fuente;

	public Bala(Celda celdita, Tanque f, int dir) {
		super(celdita);
		fuente = f;
		direccion = dir;
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaUp.gif" ));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaDw.gif" ));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaIzq.gif" ));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/BalaDer.gif" ));
		
		
	}
	
	public int getDir(){
		return direccion;
	}


}
