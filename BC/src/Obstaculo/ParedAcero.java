package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;

public class ParedAcero extends Obstaculo {

	public ParedAcero(Celda celdita) {
		super(celdita);
	
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Steel.png"));
	}
	
	public boolean colision(GameObject obj){
		return false;
	}


}
