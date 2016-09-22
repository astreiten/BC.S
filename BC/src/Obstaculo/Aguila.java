package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;

public class Aguila extends Obstaculo {

	public Aguila(Celda celdita) {
		super(celdita);
		
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Eagle.png"));
		// TODO Auto-generated constructor stub
	}
	
	public boolean colision(GameObject obj){
		return false;
	}


}
