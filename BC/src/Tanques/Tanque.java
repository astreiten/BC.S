package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;

public abstract class Tanque extends GameObject{
	
	protected int resistencia;
	protected int vel_dispa;
	protected int puntos;
	
	public Tanque(Celda celdita) {
		super(celdita);
		image[4] = new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.gif"));
	}
	
	public void setImagen(int indice){
		grafico.setIcon(image[indice]);
		grafico.setBounds(celda.getCol()*50,celda.getFila()*50,50, 50);
		
	}
	
	public boolean colision(GameObject obj){
		return false;
	}
	
	public int getPuntos(){
		return puntos;
	}
	
}
