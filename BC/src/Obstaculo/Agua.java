package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;

public class Agua extends Obstaculo {

	public Agua(Celda celdita) {
		super(celdita);
		esAtravesable = false;
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/agua.gif"));
		// TODO Auto-generated constructor stub
	}

}
