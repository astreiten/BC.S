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

	public Logica(String a) {
		Matriz = new Celda[13][13];
		cargarMapa(a);
		Celda nueva = new Celda(12, 5);
		jugador = new TanqueJugador(nueva);
		jugador.setImagen(0);
		Matriz[12][5].setTanque(jugador);
		Matriz[12][5].setObject(null);
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

					switch (letra) {
					case 'F': // Si aparece una F
						Matriz[j][i] = new Celda(j, i, null); // Coloco un piso
						break;
					case 'B':
						Celda nueva = new Celda(j, i);
						ParedLadrillos pared = new ParedLadrillos(nueva);
						pared.setImagen(0);
						nueva.setObject(pared);
						Matriz[j][i] = nueva;
						break;

					}
				}
				j++;
			}
		} catch (IOException e) { // Esto es por si ocurre un error
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
		salida.getTanque().setCelda(destino);
		destino.setTanque(salida.getTanque());
		salida.setTanque(null);

	}

	public JLabel moverJugador(int key) {
		return moverTanque(key, jugador);
	}

	public JLabel moverTanque(int key, Tanque t) {
		JLabel toReturn = null;
		int x = t.getCelda().getFila();
		System.out.println("La fila es " + x);
		int y = t.getCelda().getCol();

		switch (key) {
		case KeyEvent.VK_UP: // Arriba
			System.out.println("Entre");
			jugador.setImagen(0);
			toReturn = jugador.getGrafico();
			if (x > 0) {
				System.out.println("Entre if");
				concretarMovimiento(getCelda(x, y), getCelda(x - 1, y));

			}
			break;
		case KeyEvent.VK_DOWN: // Abajo
			jugador.setImagen(1);
			if (x <12) {
				concretarMovimiento(getCelda(x, y), getCelda(x + 1, y));
				
			}
			break;
		case KeyEvent.VK_LEFT: // Izquierda
			jugador.setImagen(2);
			if (y>0) {
				concretarMovimiento(getCelda(x, y), getCelda(x, y - 1));
				
			}
			break;
		case KeyEvent.VK_RIGHT: // Derecha
			jugador.setImagen(3);
			if (y<12) {
				concretarMovimiento(getCelda(x, y), getCelda(x, y + 1));
				
			}
			break;
		}

		return toReturn;

	}
}
