package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Obstaculo.*;
import Tanques.*;

public class Logica {
	protected GUI gui;
	protected TanqueJugador jugador;
	protected TanqueEnemigo[] enemigos;
	protected int nivelMapa;
	protected Celda[][] Matriz;

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
						Matriz[j][i] = new Celda(j, i, new ParedLadrillos());
						break;

					}
				}
				System.out.println("");
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
}
