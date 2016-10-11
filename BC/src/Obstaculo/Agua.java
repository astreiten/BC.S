package Obstaculo;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Visitante;
import PowerUp.Granada;

public class Agua extends Obstaculo {

	public Agua(Celda celdita) {
		super(celdita);
		
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/agua.gif"));
		// TODO Auto-generated constructor stub
	}
	
	public boolean colision(GameObject obj){
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

}
