package Game;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;

import Obstaculo.*;
import Tanques.*;

public class Logica {
	// protected GUI gui;
	protected TanqueJugador jugador;
	protected TanqueEnemigo[] enemigos;
	protected int nivelMapa;
	protected Celda[][] Matriz;
	protected ContadorTiempo tiempo;

	public Logica(String a) {
		Matriz = new Celda[13][13];
		cargarMapa(a);
		Celda nueva = new Celda(12, 4);
		jugador = new TanqueJugador(nueva);
		jugador.setImagen(0);
		Matriz[12][4].setTanque(jugador);
		enemigos = new TanqueEnemigo[4];
		tiempo=new ContadorTiempo(this);
		tiempo.start();
	}

	public JLabel cargarTanque() {
		return jugador.getGrafico();
	}

	public Celda[][] getMatriz() {
		return Matriz;
	}

	public Celda getCelda(int f, int c) {
		return Matriz[f][c];
	}
	
	public JLabel cargarEnemigos(){
		Celda celdita = new Celda(0,0);
		Inteligencia intel = new Inteligencia(this);
		enemigos[0] = new TanqueBasico(celdita, intel);
		intel.setTanque(enemigos[0]);
		return enemigos[0].getGrafico();
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

	public void concretarMovimiento(Celda salida, Celda destino) {
		salida.getTanque().getCelda().setColumna(destino.getCol());
		salida.getTanque().getCelda().setFila(destino.getFila());
		;
		destino.setTanque(salida.getTanque());
		salida.setTanque(null);

	}

	public void moverJugador(int key) {
		moverTanque(key, jugador);
	}
	
	public void moverEnemigos(){
		
		for(int i = 0; i < 4; i++){
			
			if(enemigos[i] != null){
				enemigos[i].getIA().mover();
			}
		}
	}

	public boolean moverTanque(int key, Tanque t) {

		int x = t.getCelda().getFila();
		System.out.println("La Fila es " + x);
		int y = t.getCelda().getCol();
		System.out.println("La Columna es " + y);
		boolean movi = false;

		switch (key) {
		case KeyEvent.VK_UP: // Arriba

			if ((x > 0) && getCelda(x - 1, y).atravesable()) {
				concretarMovimiento(getCelda(x, y), getCelda(x - 1, y));
				movi = true;
			}
			jugador.setImagen(0);
			break;

		case KeyEvent.VK_DOWN: // Abajo

			if (x < 12 && getCelda(x + 1, y).atravesable()) {
				concretarMovimiento(getCelda(x, y), getCelda(x + 1, y));
			movi = true;
			}
			jugador.setImagen(1);
			break;

		case KeyEvent.VK_LEFT: // Izquierda

			if (y > 0 && getCelda(x, y - 1).atravesable()) {
				concretarMovimiento(getCelda(x, y), getCelda(x, y - 1));
				movi = true;
			}
			jugador.setImagen(2);
			break;

		case KeyEvent.VK_RIGHT: // Derecha

			if (y < 12 && getCelda(x, y + 1).atravesable()) {
				concretarMovimiento(getCelda(x, y), getCelda(x, y + 1));
				movi = true;
			}
			jugador.setImagen(3);
			break;
		}
		return movi;
	}
}
