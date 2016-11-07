package Tanques;

import javax.swing.ImageIcon;

import Obstaculo.Arboles;
import Obstaculo.ParedLadrillos;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.PowerUp;
import Game.*;

public class TanqueJugador extends Tanque implements Visitante {

	protected int nivel;

	protected State estado;
	protected int vidas;

	public TanqueJugador(Celda celdita, Logica lg) {
		super(celdita, lg);
		nivel = 1;
		estado = new Nivel1(this);
		dir = 0;
		disparos_simul = 1;
		realizados = 0;
		vidas = 3;

	}

	public void cargarImagen(int n, String s) {

		image[n] = new ImageIcon(this.getClass().getResource("/Imagenes/" + s));

	}

	public void setVidas(int n) {
		vidas = n;
	}

	public void decrementarVidas() {
		vidas -= 1;
	}

	public void cambiarEstado() {
		int n = nivel;
		switch (n) {

		case 1:
			estado = new Nivel1(this);
			nivel = 1;
			break;
		case 2:
			estado = new Nivel2(this);
			nivel = 2;
			disparos_simul = 2;
			break;

		}
	}

	public void setNivel(int n) {
		nivel = n;
	}

	public int getNivel() {
		return nivel;
	}
	
	public int getSleep(){
		return estado.getSleep();
	}
	
	

	@Override
	public boolean visitar(Granada gra) {
		gra.afectar();
		return true;
	}

	@Override
	public boolean acept(Visitante v) {

		return v.visitarJugador(this);
	}

	@Override
	public boolean visitarEst(Estrella est) {
		est.afectar();
		return true;
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
	public Bala crearBala(Celda celdita, Tanque t, int dir, Logica lg) {

		return new BalaJugador(celdita, t, dir, lg);
	}

	@Override
	public boolean visitarJugador(TanqueJugador t) {
		// TODO Auto-generated method stub
		return false;
	}

}
