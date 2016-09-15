package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;

public abstract class Tanque extends GameObject{
	public Tanque(Celda celdita) {
		super(celdita);
		
	}
	protected int resistencia;
	protected int vel_dispa;
}
