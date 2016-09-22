package PowerUp;

import javax.swing.ImageIcon;

import Game.Celda;
import Tanques.TanqueJugador;

public class Granada extends PowerUp {

	public Granada(Celda celdita) {
		super(celdita);

		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Granada.png"));

	}
	
	public boolean colision(TanqueJugador tanque){
		return true;
		
	}


}
