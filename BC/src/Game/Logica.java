package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Obstaculo.*;
import PowerUp.Casco;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.Pala;
import PowerUp.PowerUp;
import PowerUp.Reloj;
import PowerUp.TanquePw;
import Tanques.*;
import java.applet.AudioClip;

public class Logica {
	protected GUI gui;
	protected TanqueJugador jugador;
	protected TanqueEnemigo[] enemigos;
	protected int nivelMapa;
	protected Celda[][] Matriz;
	protected ControlEnemigos controlEnemigos;
	protected int puntos;
	protected ContadorAnimaciones animaciones;
	protected Bala[] arregloBalas;
	protected ControlDisparo control;
	protected int contador = 0;
	protected Celda[] apariciones = new Celda[4];
	protected ContadorMovimiento contadorMov;
	protected ContadorMovimiento[] arregloCont;
	protected ContadorDisparo[] contDisp;
	protected int enemigos_kill;
	protected PowerUp[] powers;
	protected TanqueFactory fabrica;
	protected Queue<TanqueFactory> cola;

	public Logica(String a, GUI g) {
		Matriz = new Celda[13][13];
		cargarMapa(a);
		Celda nueva = new Celda(12, 4);
		jugador = new TanqueJugador(nueva, this);

		Matriz[12][4].setTanque(jugador);
		enemigos = new TanqueEnemigo[4];
		puntos = 0;
		gui = g;
		gui.armarEtiqueta(puntos);

		arregloBalas = new Bala[7];

		apariciones[0] = new Celda(0, 0);
		apariciones[1] = new Celda(0, 12);
		apariciones[2] = new Celda(3, 6);
		apariciones[3] = new Celda(0, 6);
		contadorMov = new ContadorMovimiento(jugador);
		contadorMov.start();

		arregloCont = new ContadorMovimiento[4];

		for (int i = 0; i < 4; i++) {
			arregloCont[i] = new ContadorMovimiento(null);
			arregloCont[i].start();
		}

		contDisp = new ContadorDisparo[7];
		for (int i = 0; i < 7; i++) {
			contDisp[i] = new ContadorDisparo(null);
			contDisp[i].start();
		}

		powers = new PowerUp[6];
		Celda nuevac = new Celda(2, 6);
		powers[0] = new Granada(nuevac, this);
		powers[1] = new Pala(nuevac, this);
		powers[2] = new Reloj(nuevac, this);
		powers[3] = new TanquePw(nuevac, this);
		powers[4] = new Estrella(nuevac, this);
		powers[5] = new Casco(nuevac, this);

		cola = new LinkedList<TanqueFactory>();
		cola.add(new RapidoFactory());
		cola.add(new PoderFactory());
		cola.add(new BlindadoFactory());
		fabrica = new BasicoFactory();

	}

	public JLabel cargarTanque() {
		ContadorAnimaciones cont = new ContadorAnimaciones();
		JLabel eti = new JLabel();
		eti.setBounds(jugador.getCelda().getCol() * 50, jugador.getCelda().getFila() * 50, 50, 50);
		ImageIcon nueva = new ImageIcon(this.getClass().getResource("/Imagenes/Aparicion.gif"));
		eti.setIcon(nueva);
		gui.add(eti);

		cont.setLabel(eti);
		cont.start();

		return jugador.getGrafico();
	}

	private PowerUp gimmePw(int t) {
		PowerUp nuevo = null;
		Celda celd = new Celda(2, 6);
		switch (t) {

		case 0:
			nuevo = new Granada(celd, this);
			break;
		case 1:
			nuevo = new Pala(celd, this);
			break;
		case 2:
			nuevo = new Casco(celd, this);
			break;
		case 3:
			nuevo = new Reloj(celd, this);
			break;
		case 4:
			nuevo = new TanquePw(celd, this);
			break;
		case 5:
			nuevo = new Estrella(celd, this);
			break;

		}

		return new Reloj(celd, this);
	}

	public Celda getCelda(int f, int c) {
		return Matriz[f][c];
	}

	public void cargarEnemigos() {

		TanqueFactory fabrica = new BasicoFactory();

		for (int i = 0; i < 4; i++) {
			Celda nueva = new Celda(apariciones[i].getFila(), apariciones[i].getCol());
			Inteligencia intel = new Inteligencia(this);
			enemigos[i] = fabrica.crearTanque(nueva, intel, this);
			intel.setTanque(enemigos[i]);
			enemigos[i].setImagen(0);
			Matriz[nueva.getFila()][nueva.getCol()].setTanque(enemigos[i]);
			ContadorAnimaciones cont = new ContadorAnimaciones();
			JLabel eti = new JLabel();
			eti.setBounds(enemigos[i].getCelda().getCol() * 50, enemigos[i].getCelda().getFila() * 50, 50, 50);
			ImageIcon nuevaIm = new ImageIcon(this.getClass().getResource("/Imagenes/Aparicion.gif"));
			eti.setIcon(nuevaIm);
			gui.add(eti);

			cont.setLabel(eti);
			cont.start();
			gui.add(enemigos[i].getGrafico());

		}
		controlEnemigos = new ControlEnemigos(this);
		controlEnemigos.start();

		control = new ControlDisparo(this);
		control.start();

	}

	public void subirNivel() {
		jugador.setImagen(4);
		jugador.setNivel(jugador.getNivel() + 1);
		jugador.cambiarEstado();

	}

	private void cargarMapa(String nombre) {

		BufferedReader br = null;

		String fileName = nombre;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));
			int j = 0;
			// Para cada linea del archivo
			while ((sCurrentLine = br.readLine()) != null) {
				// Para cada letra de la linea
				for (int i = 0; i < sCurrentLine.length(); i++) {
					char letra = sCurrentLine.charAt(i);
					Celda nueva = new Celda(j, i);

					switch (letra) {
					case 'F': // Si aparece una F
						Matriz[j][i] = new Celda(j, i, null); // Coloco un piso
						break;
					case 'B':

						ParedLadrillos pared = new ParedLadrillos(nueva);
						pared.setImagen(0);
						nueva.setObject(pared);
						Matriz[j][i] = nueva;
						break;
					case 'S':

						ParedAcero acero = new ParedAcero(nueva);
						acero.setImagen(0);
						nueva.setObject(acero);
						Matriz[j][i] = nueva;
						break;

					case 'E':

						Aguila ag = new Aguila(nueva, this);
						ag.setImagen(0);
						nueva.setObject(ag);
						Matriz[j][i] = nueva;
						break;

					case 'T':

						Arboles ar = new Arboles(nueva);
						ar.setImagen(0);
						nueva.setObject(ar);
						Matriz[j][i] = nueva;
						break;
					case 'W':

						Agua agua = new Agua(nueva);
						agua.setImagen(0);
						nueva.setObject(agua);
						Matriz[j][i] = nueva;
						break;

					}
				}
				j++;
			}
		} catch (

		IOException e) { // Esto es por si ocurre un error
			e.printStackTrace();
		} finally { // Esto es para que, haya ocurrido error o no
			try {
				if (br != null)
					br.close(); // Cierre el archivo
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public int getPuntos() {
		return puntos;
	}

	public void sumarPuntos(int n) {
		puntos += n;
		gui.armarEtiqueta(puntos);
	}

	public void destruirEnemigos(int a, int b) {
		eliminarBloque(a, b);

		for (int i1 = 0; i1 < 4; i1++) {
			if (enemigos[i1] != null) {

				enemigos_kill++;

				int y = enemigos[i1].getCelda().getCol();
				int x = enemigos[i1].getCelda().getFila();
				this.sumarPuntos(100);
				enemigos[i1].setImagen(4);

				enemigos[i1].setGrafico();
				Matriz[x][y].setTanque(null);

				enemigos[i1] = null;
				reponerTanque(i1);
			}
		}
	}

	public void eliminarBloque(int a, int b) {
		Matriz[a][b].getObstaculo().getGrafico().setIcon(null);
		Matriz[a][b].setObject(null);
	}

	public void eliminarTanque(int a, int b) {
		AudioClip sonido;
		sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Imagenes/boom.wav"));
		Sound s = new Sound();
		s.setSound(sonido);
		s.start();
		s.empezar();

		Matriz[a][b].getTanque().getGrafico().setIcon(null);
		Matriz[a][b].setTanque(null);
	}

	public void insertarPowerUp() {

		Random rnd = new Random();
		int i = (int) (rnd.nextDouble() * 6 + 0);
		PowerUp pp = gimmePw(i);
		Matriz[2][6].setObject(pp);
		pp.setImagen(0);
		gui.add(pp.getGrafico());

		Timer time = new Timer(this);
		time.setPw(pp);
		time.start();

	}

	public void concretarMovimiento(Celda salida, Celda destino) {
		if (salida.getTanque() != null) {
			salida.getTanque().getCelda().setColumna(destino.getCol());
			salida.getTanque().getCelda().setFila(destino.getFila());
			destino.setTanque(salida.getTanque());
			salida.setTanque(null);
		}

	}

	public void concretarMovimientoBala(Celda salida, Celda destino) {
		if (salida.getTanque() != null) {
			salida.getTanque().getCelda().setColumna(destino.getCol());
			salida.getTanque().getCelda().setFila(destino.getFila());
			destino.setTanque(salida.getTanque());
			salida.setTanque(null);
		}

	}

	public void moverJugador(int key) {

		if (jugador.getMovilidad()) {
			moverTanque(key, jugador);
			contadorMov.empezar();

		}
	}

	public void moverEnemigos(boolean a) {

		for (int i = 0; i < 4; i++) {
			if (a) {

				if (enemigos[i] != null) {
					arregloCont[i].setTanque(enemigos[i]);

					if (enemigos[i].getMovilidad()) {
						enemigos[i].getIA().mover();
						arregloCont[i].empezar();

					}
					disparoTanque(enemigos[i]);
				}
				if (enemigos[i].getRes() == 0) {
					enemigos[i].setImagen(4);

					eliminarTanque(enemigos[i].getCelda().getFila(), enemigos[i].getCelda().getCol());
					sumarPuntos(enemigos[i].getPuntos());
					enemigos[i] = null;
					enemigos_kill++;
					System.out.println("El punataje es " + puntos);
					if (enemigos_kill == 16) {
						cargarMapa("prueba.txt.txt");
					}

					if (enemigos_kill % 4 == 0) {
						insertarPowerUp();
					}
					reponerTanque(i);
					System.out.println("Repuse");
				}
			}

		}

	}

	public void reponerTanque(int i) {
		if (enemigos_kill % 9 == 0) {
			fabrica = cola.remove();
		}
		int aux = i;
		Celda nueva = new Celda(apariciones[aux].getFila(), apariciones[aux].getFila());
		boolean meti = false;
		while (!meti) {
			System.out.println("AUX INICIAL " + aux);

			if (Matriz[nueva.getFila()][nueva.getCol()].getTanque() == null) {
				Inteligencia intel = new Inteligencia(this);
				enemigos[i] = fabrica.crearTanque(nueva, intel, this);
				intel.setTanque(enemigos[i]);
				ContadorAnimaciones cont = new ContadorAnimaciones();
				JLabel eti = new JLabel();
				eti.setBounds(enemigos[i].getCelda().getCol() * 50, enemigos[i].getCelda().getFila() * 50, 50, 50);
				ImageIcon nuevaIm = new ImageIcon(this.getClass().getResource("/Imagenes/Aparicion.gif"));
				eti.setIcon(nuevaIm);
				gui.add(eti);
				cont.setLabel(eti);
				cont.start();

				Matriz[nueva.getFila()][nueva.getCol()].setTanque(enemigos[i]);
				gui.add(enemigos[i].getGrafico());
				meti = true;
			} else {
				aux = aux + 1;
				if (aux > 3) {
					aux = 0;
				}

				nueva = new Celda(apariciones[(aux) % 4].getFila(), apariciones[(aux) % 4].getCol());

			}
		}

	}

	public void reespawn() {
		int x = jugador.getCelda().getFila();
		int y = jugador.getCelda().getCol();

		if (jugador.getVidas() > 0) {

			Matriz[x][y].setTanque(null);
			jugador.setGrafico();
			boolean meti = false;
			while (!meti) {
				if (Matriz[12][4].getTanque() == null) {
					jugador.getCelda().setFila(12);
					jugador.getCelda().setColumna(4);

					Matriz[12][4].setTanque(jugador);
					jugador.setImagen(1);
					meti = true;
				}
			}
		} else {

			gui.gameOver();

			System.out.println("Game Over");
		}

	}

	public void disparoTanque(Tanque t) {
		if (t == null) {
			t = jugador;
		}
		Bala nueva = t.disparo();
		if (nueva != null) {

			if (getCelda(nueva.getCelda().getFila(), nueva.getCelda().getCol()).getObstaculo() != null) {
				getCelda(nueva.getCelda().getFila(), nueva.getCelda().getCol()).getObstaculo().acept(nueva);
				nueva.getFuente().decrementarRealizados();
			} else {
				if (getCelda(nueva.getCelda().getFila(), nueva.getCelda().getCol()).getTanque() != null) {
					getCelda(nueva.getCelda().getFila(), nueva.getCelda().getCol()).getTanque().acept(nueva);
					nueva.getFuente().decrementarRealizados();
				} else {
					nueva.setImagen(nueva.getDir());
					gui.add(nueva.getGrafico());
					Matriz[nueva.getCelda().getFila()][nueva.getCelda().getCol()] = new Celda(
							nueva.getCelda().getFila(), nueva.getCelda().getCol());
					Matriz[nueva.getCelda().getFila()][nueva.getCelda().getCol()].setTanque(nueva);
					// t.setImagen(5);
					// long millis = System.currentTimeMillis() + 500;
					// while(System.currentTimeMillis() <= millis){
					// }
					// t.setImagen(0);
					instPrimerLibre(nueva);
				}
			}
		}
	}

	public void moverBalas() {
		for (int i = 0; i < 7; i++) {
			if (arregloBalas[i] != null) {
				boolean destroy = true;
				contDisp[i].setBala(arregloBalas[i]);
				if (arregloBalas[i].getMovilidad()) {
					destroy = moverBala(arregloBalas[i].getDir(), arregloBalas[i]);
					contDisp[i].empezar();
				}
				if (!destroy) {
					arregloBalas[i].setImagen(4);
					arregloBalas[i].getFuente().decrementarRealizados();
					Matriz[arregloBalas[i].getCelda().getFila()][arregloBalas[i].getCelda().getCol()].setTanque(null);

					arregloBalas[i].setGrafico();
					arregloBalas[i] = null;

				}

			}

		}

	}

	public boolean moverBala(int dir, Bala t) {
		int x = t.getCelda().getFila();
		int y = t.getCelda().getCol();

		boolean movi = false;

		switch (dir) {
		case 0: // Arriba

			if ((x > 0) && getCelda(x - 1, y).inspeccionar(t)) {
				concretarMovimientoBala(getCelda(x, y), getCelda(x - 1, y));

				movi = true;
				t.setMovilidad(false);
			}
			t.setImagen(0);
			break;

		case 1: // Abajo

			if (x < 12 && getCelda(x + 1, y).inspeccionar(t)) {
				concretarMovimiento(getCelda(x, y), getCelda(x + 1, y));
				movi = true;
				t.setMovilidad(false);
			}
			t.setImagen(1);
			break;

		case 2: // Izquierda

			if (y > 0 && getCelda(x, y - 1).inspeccionar(t)) {
				concretarMovimiento(getCelda(x, y), getCelda(x, y - 1));
				movi = true;
				t.setMovilidad(false);
			}
			t.setImagen(2);
			break;

		case 3: // Derecha

			if (y < 12 && getCelda(x, y + 1).inspeccionar(t)) {
				concretarMovimiento(getCelda(x, y), getCelda(x, y + 1));
				movi = true;
				t.setMovilidad(false);
			}
			t.setImagen(3);
			break;
		}
		return movi;

	}

	public boolean moverTanque(int key, Tanque t) {

		int x = t.getCelda().getFila();

		int y = t.getCelda().getCol();

		boolean movi = false;

		switch (key) {
		case 0: // Arriba

			if ((x > 0) && getCelda(x - 1, y).inspeccionar(t)) {

				concretarMovimiento(getCelda(x, y), getCelda(x - 1, y));
				t.setMovilidad(false);
				movi = true;
			}
			t.setDir(0);
			t.setImagen(0);
			break;

		case 1: // Abajo

			if (x < 12 && getCelda(x + 1, y).inspeccionar(t)) {

				concretarMovimiento(getCelda(x, y), getCelda(x + 1, y));
				t.setMovilidad(false);
				movi = true;
			}
			t.setDir(1);
			t.setImagen(1);
			break;

		case 2: // Izquierda

			if (y > 0 && getCelda(x, y - 1).inspeccionar(t)) {

				concretarMovimiento(getCelda(x, y), getCelda(x, y - 1));
				t.setMovilidad(false);
				movi = true;
			}
			t.setDir(2);
			t.setImagen(2);
			break;

		case 3: // Derecha

			if (y < 12 && getCelda(x, y + 1).inspeccionar(t)) {

				concretarMovimiento(getCelda(x, y), getCelda(x, y + 1));
				t.setMovilidad(false);
				movi = true;
			}
			t.setDir(3);
			t.setImagen(3);
			break;
		}
		return movi;
	}

	private void instPrimerLibre(Bala b) {
		boolean ins = false;
		for (int i = 0; i < arregloBalas.length && !ins; i++) {
			if (arregloBalas[i] == null) {
				arregloBalas[i] = b;
				ins = true;
			}
		}

	}

	public void setInvul(boolean a) {
		jugador.setInvul(a);
	}

	public void detenerEnemigos() {

		controlEnemigos.frenar();

	}

	public void ponerAcero() {
		if (Matriz[12][5].getObstaculo() != null) {
			eliminarBloque(12, 5);
		}
		ParedAcero p1 = new ParedAcero(Matriz[12][5]);
		Matriz[12][5].setObject(p1);
		p1.setImagen(0);
		gui.add(p1.getGrafico());

		if (Matriz[11][5].getObstaculo() != null) {
			eliminarBloque(11, 5);
		}
		ParedAcero p2 = new ParedAcero(Matriz[11][5]);
		Matriz[11][5].setObject(p2);
		p2.setImagen(0);
		gui.add(p2.getGrafico());

		if (Matriz[11][6].getObstaculo() != null) {
			eliminarBloque(11, 6);
		}
		ParedAcero p3 = new ParedAcero(Matriz[11][6]);
		Matriz[11][6].setObject(p3);
		p3.setImagen(0);
		gui.add(p3.getGrafico());

		if (Matriz[11][7].getObstaculo() != null) {
			eliminarBloque(11, 7);
		}
		ParedAcero p4 = new ParedAcero(Matriz[11][7]);
		Matriz[11][7].setObject(p4);
		p4.setImagen(0);
		gui.add(p4.getGrafico());

		if (Matriz[12][7].getObstaculo() != null) {
			eliminarBloque(12, 7);
		}
		ParedAcero p5 = new ParedAcero(Matriz[12][7]);
		Matriz[12][7].setObject(p5);
		p5.setImagen(0);
		gui.add(p5.getGrafico());

	}

	public void ponerLadrillos() {

		eliminarBloque(12, 5);
		ParedLadrillos p1 = new ParedLadrillos(Matriz[12][5]);
		Matriz[12][5].setObject(p1);
		p1.setImagen(0);
		gui.add(p1.getGrafico());

		eliminarBloque(11, 5);
		ParedLadrillos p2 = new ParedLadrillos(Matriz[11][5]);
		Matriz[11][5].setObject(p2);
		p2.setImagen(0);
		gui.add(p2.getGrafico());

		eliminarBloque(11, 6);
		ParedLadrillos p3 = new ParedLadrillos(Matriz[11][6]);
		Matriz[11][6].setObject(p3);
		p3.setImagen(0);
		gui.add(p3.getGrafico());

		eliminarBloque(11, 7);
		ParedLadrillos p4 = new ParedLadrillos(Matriz[11][7]);
		Matriz[11][7].setObject(p4);
		p4.setImagen(0);
		gui.add(p4.getGrafico());

		eliminarBloque(12, 7);
		ParedLadrillos p5 = new ParedLadrillos(Matriz[12][7]);
		Matriz[12][7].setObject(p5);
		p5.setImagen(0);
		gui.add(p5.getGrafico());

	}

	public void aumentarVida() {
		System.out.println("La vida es " + jugador.getVidas());
		jugador.aumentarVida();
		System.out.println("La vida es " + jugador.getVidas());
	}

	public void gameOver() {
		gui.gameOver();
	}

	public void destruirHilos() {
		controlEnemigos.destruir();
	}

}
