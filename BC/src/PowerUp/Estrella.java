package PowerUp;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Logica;

public class Estrella extends PowerUp {

	public Estrella(Celda celdita, Logica l) {
		super(celdita, l);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Estrella.png"));
		
	}

	@Override
	public boolean colision(GameObject obj) {
		lg.subirNivel();
		lg.eliminarBloque(celda.getFila(), celda.getCol());
		return true;
	}
	
	

}
