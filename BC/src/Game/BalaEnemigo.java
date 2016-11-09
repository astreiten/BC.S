package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Obstaculo.Arboles;
import Obstaculo.ParedLadrillos;
import PowerUp.Casco;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.Pala;
import PowerUp.Reloj;
import PowerUp.TanquePw;
import Tanques.Tanque;
import Tanques.TanqueEnemigo;
import Tanques.TanqueJugador;

public class BalaEnemigo extends Bala {

	public BalaEnemigo(Celda celdita, Tanque f, int dir, Logica l) {
		super(celdita, f, dir, l);

	}

	@Override
	public boolean acept(Visitante v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitar(Granada gra) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarEst(Estrella est) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarArbol(Arboles arb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitarLadrillo(ParedLadrillos p) {
		boolean destruir = p.decrementarResistencia();
		int aux = p.getResistencia();
		switch (aux) {
		case 3:
			p.setImagen(3);
			break;
		case 2:
			p.setImagen(2);
			break;
		case 1:
			p.setImagen(1);
			break;
		}
		if (destruir) {
			p.setGrafico();
			lg.eliminarBloque(p.getCelda().getFila(), p.getCelda().getCol());
		}
		return false;
	}

	@Override
	public boolean visitarEnemigo(TanqueEnemigo t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean visitarJugador(TanqueJugador t) {
		if (!t.getInvul()) {
			ContadorAnimaciones cont = new ContadorAnimaciones();
			JLabel eti = new JLabel();
			eti.setBounds(t.getCelda().getCol() * 50, t.getCelda().getFila() * 50, 50, 50);
			ImageIcon nueva = new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.gif"));
			eti.setIcon(nueva);
			lg.gui.add(eti);

			cont.setLabel(eti);
			cont.start();

			lg.reespawn();
		}
		return false;
	}

	@Override
	public boolean colision(GameObject obj) {
		// TODO Auto-generated method stub
		return false;
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
		return false;
	}

	@Override
	public boolean visitarTanquePw(TanquePw t) {
		// TODO Auto-generated method stub
		return false;
	}

}
