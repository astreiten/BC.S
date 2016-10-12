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
		resistencia = 4;
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Brick.png"));

	}

	public boolean colision(GameObject obj) {
		return false;
	}
	
	public boolean decrementarResistencia(){
		resistencia--;
		boolean destruime = resistencia < 1;
		return destruime;
	}

	@Override
	public boolean acept(Visitante v) {
		v.visitarLadrillo(this);
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

	@Override
	public boolean visitarArbol(Arboles arb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarLadrillo(ParedLadrillos p) {
		// TODO Auto-generated method stub
		return false;
	}

}
