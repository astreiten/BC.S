package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;

public class Arboles extends Obstaculo {

	public Arboles(Celda celdita) {
		super(celdita);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Tree.png"));

	}
	
	public boolean colision(GameObject obj){
		return true;
	}

}
