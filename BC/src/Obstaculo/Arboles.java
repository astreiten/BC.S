package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;

public class Arboles extends Obstaculo {

	public Arboles(Celda celdita) {
		super(celdita);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Tree.png"));
		this.esAtravesable=true;
		// TODO Auto-generated constructor stub
	}

}
