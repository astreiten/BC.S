package Obstaculo;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Game.Celda;

public class ParedLadrillos extends Obstaculo{

	public ParedLadrillos(Celda celdita) {
		super(celdita);
		
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Brick.png"));
	
	}
	


}
