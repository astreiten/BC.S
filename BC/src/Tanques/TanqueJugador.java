package Tanques;

import Game.Celda;

public class TanqueJugador extends Tanque{
	public TanqueJugador(Celda celdita) {
		super(celdita);
		
	}
	protected int nivel;
	protected int disparos_simul;
	
	public void setImagen(int indice){
		grafico.setIcon(image[indice]);
		grafico.setBounds(celda.getCol()*50,celda.getFila()*50,50, 50);
	}
}
