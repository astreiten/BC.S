package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;

public class ParedAcero extends Obstaculo {

	public ParedAcero(Celda celdita) {
		super(celdita);
	
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Steel.png"));
	}

}
