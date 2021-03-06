package Tanques;

import javax.swing.ImageIcon;

import Game.Celda;
import Game.Logica;
import Game.Visitante;
import Obstaculo.Aguila;
import Obstaculo.Arboles;
import Obstaculo.ParedLadrillos;
import PowerUp.Casco;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.Pala;
import PowerUp.Reloj;
import PowerUp.TanquePw;

public class TanqueRapido extends TanqueEnemigo{

	public TanqueRapido(Celda celdita, Inteligencia IA, Logica lg) {
		super(celdita, IA, lg);
		// TODO Auto-generated constructor stub
		puntos = 200;
		resistencia = 1;
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/RapidoUp.gif"));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/RapidoDw.gif"));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/RapidoL.gif"));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/RapidoR.gif"));
		image[4] = new ImageIcon(this.getClass().getResource("/Imagenes/ExplosionEnemigo.gif"));
	}

	@Override
	public boolean visitar(Granada gra) {

		return true;
	}

	@Override
	public boolean visitarEst(Estrella est) {

		return true;
	}

	public int getSleep() {
		
		return 4;

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
	public int getVd() {
		
		return 5;
	}

	@Override
	public boolean visitarCasco(Casco c) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarReloj(Reloj r) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarPala(Pala p) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarTanquePw(TanquePw t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarAguila(Aguila a) {
		// TODO Auto-generated method stub
		return false;
	}

}
