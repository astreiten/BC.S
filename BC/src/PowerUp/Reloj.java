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

public class Reloj  extends PowerUp{

	public Reloj(Celda celdita, Logica l) {
		super(celdita, l);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Reloj.png"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean acept(Visitante v) {
		// TODO Auto-generated method stub
		return v.visitarReloj(this);
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
	public boolean colision(GameObject obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarReloj(Reloj r) {
		// TODO Auto-generated method stub
		return false;
	}

	public void afectar() {
		lg.detenerEnemigos();
		lg.eliminarBloque(celda.getFila(), celda.getCol());
		
	}

	@Override
	public boolean visitarPala(Pala p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarTanquePw(TanquePw t) {
		// TODO Auto-generated method stub
		return false;
	}

}
