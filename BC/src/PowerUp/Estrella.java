package PowerUp;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Logica;
import Game.Visitante;

public class Estrella extends PowerUp {

	public Estrella(Celda celdita, Logica l) {
		super(celdita, l);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Estrella.png"));
		
	}

	@Override
	public boolean colision(GameObject obj) {
		lg.subirNivel();
		lg.eliminarBloque(celda.getFila(), celda.getCol());
		return true;
	}

	@Override
	public boolean acept(Visitante v) {
		
		return v.visitarEst(this);
	}
	
	public boolean afectar(){
		lg.subirNivel();
		lg.eliminarBloque(celda.getFila(), celda.getCol());
		return true;
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
