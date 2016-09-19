package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;

public class TanqueBasico extends TanqueEnemigo{

	
	public TanqueBasico(Celda celdita,Inteligencia IA) {
		super(celdita,IA);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/up2.png"));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/down2.png"));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/left2.png"));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/right2.png"));
	}
}
