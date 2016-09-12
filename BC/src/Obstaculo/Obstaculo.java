package Obstaculo;

import javax.swing.Icon;

import Game.*;

public abstract class Obstaculo extends GameObject {
	public Obstaculo(Celda celdita) {
		super(celdita);
		
	}
	
	protected boolean esDestructible;
	protected int resistencia;

}
