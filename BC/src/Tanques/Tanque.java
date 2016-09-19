package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;

public abstract class Tanque extends GameObject{
	
	protected int resistencia;
	protected int vel_dispa;
	
	public Tanque(Celda celdita) {
		super(celdita);
	}
	
	public void setImagen(int indice){
		grafico.setIcon(image[indice]);
		grafico.setBounds(celda.getCol()*50,celda.getFila()*50,50, 50);
	}
	
}
