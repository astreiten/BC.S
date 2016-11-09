package PowerUp;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Logica;
import Game.Tiempo;
import Game.Visitante;
import Obstaculo.Arboles;
import Obstaculo.ParedLadrillos;
import Tanques.TanqueEnemigo;
import Tanques.TanqueJugador;

public class Pala extends PowerUpTemp {

	public Pala(Celda celdita, Logica l) {
		super(celdita, l);
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Pala.png"));

	}

	@Override
	public boolean acept(Visitante v) {
		v.visitarPala(this);
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
	public void desafectar() {
		lg.ponerLadrillos();

	}
	
	public void afectar(){
		lg.ponerAcero();
		lg.eliminarBloque(getCelda().getFila(), getCelda().getCol());
		Tiempo t = new Tiempo();
		t.setPw(this);
		t.start();
	}

	@Override
	public boolean colision(GameObject obj) {
		// TODO Auto-generated method stub
		return false;
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
