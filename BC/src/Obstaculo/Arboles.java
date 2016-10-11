package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Visitante;
import PowerUp.Granada;

public class Arboles extends Obstaculo {

	public Arboles(Celda celdita) {
		super(celdita);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Tree.png"));

	}
	
	public boolean colision(GameObject obj){
		return true;
	}

	@Override
	public boolean acept(Visitante v) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitar(Granada gra) {
		// TODO Auto-generated method stub
		return false;
	}

}
