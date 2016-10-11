package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.Visitante;
import PowerUp.Estrella;
import PowerUp.Granada;

public class TanqueBasico extends TanqueEnemigo{
	
	

	
	public TanqueBasico(Celda celdita,Inteligencia IA) {
		super(celdita,IA);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/BasicU.gif"));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/BasicD.gif"));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/BasicL.gif"));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/BasicR.gif"));
		image[4] = new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.gif"));
		puntos = 100;
	}

	@Override
	public boolean acept(Visitante v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitar(Granada gra) {
		
		return true;
	}

	@Override
	public boolean visitarEst(Estrella est) {
		
		return true;
	}
	
	
}
