package PowerUp;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Logica;
import Game.Visitante;
import Obstaculo.Arboles;
import Obstaculo.ParedLadrillos;
import Tanques.TanqueEnemigo;
import Tanques.TanqueJugador;

public class TanquePw extends PowerUp {

	public TanquePw(Celda celdita, Logica l) {
		super(celdita, l);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Tanque.png"));	}

	@Override
	public boolean acept(Visitante v) {
		v.visitarTanquePw(this);
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

	@Override
	public boolean visitarEnemigo(TanqueEnemigo t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarJugador(TanqueJugador t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarCasco(Casco c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarReloj(Reloj r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarPala(Pala p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean colision(GameObject obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public void afectar() {
		
		lg.aumentarVida();
		lg.eliminarBloque(celda.getFila(), celda.getCol());
	}

	@Override
	public boolean visitarTanquePw(TanquePw t) {
		// TODO Auto-generated method stub
		return false;
	}

}
