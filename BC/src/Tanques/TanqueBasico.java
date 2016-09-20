package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;

public class TanqueBasico extends TanqueEnemigo{

	
	public TanqueBasico(Celda celdita,Inteligencia IA) {
		super(celdita,IA);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/BasicU.gif"));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/BasicD.gif"));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/BasicL.gif"));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/BasicR.gif"));
	}
}
