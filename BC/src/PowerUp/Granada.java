package PowerUp;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Logica;
import Tanques.Tanque;
import Tanques.TanqueJugador;

public class Granada extends PowerUp {

	public Granada(Celda celdita, Logica l) {
		super(celdita, l );

		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Granada.png"));

	}

	@Override
	public boolean colision(GameObject obj) {
		lg.destruirEnemigos(celda.getFila(), celda.getCol());
		
		return true;
	}
	
	
	


}
