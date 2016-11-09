package Obstaculo;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Visitante;
import PowerUp.Casco;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.Pala;
import PowerUp.Reloj;
import PowerUp.TanquePw;
import Tanques.TanqueEnemigo;
import Tanques.TanqueJugador;

public class ParedLadrillos extends Obstaculo {
	

	public ParedLadrillos(Celda celdita) {
		super(celdita);
		resistencia = 4;
		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Brick.png"));
		image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/Brick3.png"));
		image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/Brick2.png"));
		image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/Brick1.png"));

	}

	public boolean colision(GameObject obj) {
		return false;
	}
	
	public boolean decrementarResistencia(){
		resistencia--;
		boolean destruime = resistencia < 1;
		return destruime;
	}
	
	public int getResistencia(){
		return resistencia;
	}

	@Override
	public boolean acept(Visitante v) {
		return v.visitarLadrillo(this);
		
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
	public boolean visitarTanquePw(TanquePw t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarAguila(Aguila a) {
		// TODO Auto-generated method stub
		return false;
	}

}
