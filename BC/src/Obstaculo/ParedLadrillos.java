package Obstaculo;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Visitante;
import PowerUp.Estrella;
import PowerUp.Granada;

public class ParedLadrillos extends Obstaculo {

	public ParedLadrillos(Celda celdita) {
		super(celdita);

		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Brick.png"));

	}

	public boolean colision(GameObject obj) {
		return false;
	}

	@Override
	public boolean acept(Visitante v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitar(Granada gra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarEst(Estrella est) {
		// TODO Auto-generated method stub
		return false;
	}

}
