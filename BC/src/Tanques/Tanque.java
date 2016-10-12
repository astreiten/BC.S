package Tanques;

import javax.swing.ImageIcon;
import Game.*;

import Game.Celda;
import Game.GameObject;

public abstract class Tanque extends GameObject{
	
	protected int resistencia;
	protected int vel_dispa;
	protected int puntos;
	protected int dir;
	protected Logica lg;
	
	
	public Tanque(Celda celdita, Logica l) {
		super(celdita);
		lg = l;
		image[4] = new ImageIcon(this.getClass().getResource("/Imagenes/Aparicion.gif"));
		
	}
	
	public void setImagen(int indice){
		grafico.setIcon(image[indice]);
		grafico.setBounds(celda.getCol()*50,celda.getFila()*50,50, 50);
		
	}
	
	public void setDir(int n){
		dir = n;
	}
	
	public int getDir(){
		return dir;
	}
	
	public int getRes(){
		return resistencia;
	}
	
	public boolean colision(GameObject obj){
		return false;
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	
}
