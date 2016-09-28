package Game;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JLabel;

import Obstaculo.*;
import PowerUp.Estrella;
import PowerUp.Granada;
import PowerUp.PowerUp;
import Tanques.*;

public class Logica {
	protected GUI gui;
	protected TanqueJugador jugador;
	protected TanqueEnemigo[] enemigos;
	protected int nivelMapa;
	protected Celda[][] Matriz;
	protected ContadorTiempo tiempo;
	protected int puntos;
	protected JLabel puntosEtiqueta;
	

	public Logica(String a, GUI g) {
		Matriz = new Celda[13][13];
		cargarMapa(a);
		Celda nueva = new Celda(12, 4);
		jugador = new TanqueJugador(nueva);
		jugador.setImagen(0);
		Matriz[12][4].setTanque(jugador);
		enemigos = new TanqueEnemigo[4];
		puntos = 0;
		puntosEtiqueta = new JLabel();
		gui = g;
		gui.armarEtiqueta(puntos);

		tiempo = new ContadorTiempo(this);
		tiempo.start();
	}

	public JLabel cargarTanque() {
		jugador.setImagen(4);
		return jugador.getGrafico();
	}

	public Celda[][] getMatriz() {
		return Matriz;
	}

	public Celda getCelda(int f, int c) {
		return Matriz[f][c];
	}

	public JLabel[] cargarEnemigos() {

		JLabel[] arreglo = new JLabel[4];

		Celda celdita = new Celda(0, 0);
		Inteligencia intel = new Inteligencia(this);
		enemigos[0] = new TanqueBasico(celdita, intel);
		intel.setTanque(enemigos[0]);
		enemigos[0].setImagen(0);
		Matriz[0][0].setTanque(enemigos[0]);
		arreglo[0] = enemigos[0].getGrafico();

		Celda celd = new Celda(3, 0);
		Inteligencia intel1 = new Inteligencia(this);
		enemigos[1] = new TanqueBasico(celd, intel1);
		intel1.setTanque(enemigos[1]);
		enemigos[1].setImagen(0);
		Matriz[3][0].setTanque(enemigos[1]);
		arreglo[1] = enemigos[1].getGrafico();

		return arreglo;
	}
	
	public void subirNivel(){
		jugador.setNivel(jugador.getNivel()+1);
		jugador.cambiarEstado(jugador.getNivel());
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

						Aguila ag = new Aguila(nueva);
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

	private void mostrarExplosion() {
		for (int i = 0; i < 4; i++) {
			if (enemigos[i] != null) {
				enemigos[i].setImagen(4);
			}

		}
	}

	public int getPuntos() {
		return puntos;
	}

	public JLabel getEtiqueta() {

		return puntosEtiqueta;
	}

	private void sumarPuntos(int n) {
		puntos += n;
		gui.armarEtiqueta(puntos);
	}

	public void destruirEnemigos(int a, int b) {
		eliminarBloque(a, b);	

		for (int i = 0; i < 4; i++) {
			if (enemigos[i] != null) {
				System.out.println("Entre al for");

				int y = enemigos[i].getCelda().getCol();
				int x = enemigos[i].getCelda().getFila();
				this.sumarPuntos(100);

				enemigos[i].setImagen(4);

				enemigos[i].getGrafico().setIcon(null);
				Matriz[x][y].setTanque(null);

				enemigos[i] = null;
			}
		}

		System.out.println(puntos);

	}

	public void eliminarBloque(int a, int b) {
		Matriz[a][b].getObstaculo().getGrafico().setIcon(null);
		Matriz[a][b].setObject(null);
	}

	public JLabel insertarPowerUp() {
		Celda celdita = new Celda(0, 7);
		PowerUp granada = new Granada(celdita, this);
		Matriz[0][7].setObject(granada);
		granada.setImagen(0);
		Celda celdita1 = new Celda(5, 12);
		PowerUp estrella = new Estrella(celdita1, this);
		Matriz[5][12].setObject(estrella);
		estrella.setImagen(0);
		gui.add(estrella.getGrafico());
		
		
		return granada.getGrafico();

	}

	public void concretarMovimiento(Celda salida, Celda destino) {
		salida.getTanque().getCelda().setColumna(destino.getCol());
		salida.getTanque().getCelda().setFila(destino.getFila());
		destino.setTanque(salida.getTanque());
		salida.setTanque(null);

	}

	public void moverJugador(int key) {
		moverTanque(key, jugador);
	}

	public void moverEnemigos() {

		for (int i = 0; i < 4; i++) {

			if (enemigos[i] != null) {
				enemigos[i].getIA().mover();
			}
		}
	}

	public boolean moverTanque(int key, Tanque t) {

		int x = t.getCelda().getFila();

		int y = t.getCelda().getCol();

		boolean movi = false;

		switch (key) {
		case 0: // Arriba

			if ((x > 0) && getCelda(x - 1, y).inspeccionar(t)) {
				concretarMovimiento(getCelda(x, y), getCelda(x - 1, y));
				movi = true;
			}
			t.setImagen(0);
			break;

		case 1: // Abajo

			if (x < 12 && getCelda(x + 1, y).inspeccionar(t)) {
				concretarMovimiento(getCelda(x, y), getCelda(x + 1, y));
				movi = true;
			}
			t.setImagen(1);
			break;

		case 2: // Izquierda

			if (y > 0 && getCelda(x, y - 1).inspeccionar(t)) {
				concretarMovimiento(getCelda(x, y), getCelda(x, y - 1));
				movi = true;
			}
			t.setImagen(2);
			break;

		case 3: // Derecha

			if (y < 12 && getCelda(x, y + 1).inspeccionar(t)) {
				concretarMovimiento(getCelda(x, y), getCelda(x, y + 1));
				movi = true;
			}
			t.setImagen(3);
			break;
		}
		return movi;
	}

	
}
