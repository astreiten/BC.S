package Obstaculo;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ParedLadrillos extends Obstaculo{

	public ParedLadrillos() {
		super();
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Brick.png"));
		grafico.setIcon(image[0]);
		
		
	}

}
