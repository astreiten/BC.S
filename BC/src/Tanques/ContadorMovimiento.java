package Tanques;

import Game.Logica;

public class ContadorMovimiento extends Thread {

	private Tanque tan;
	private boolean puedo = false;
	private int contador = 0;

	public ContadorMovimiento(Tanque tanq) {
		tan = tanq;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (puedo) {
				try {
					Thread.sleep(100 * tan.getSleep());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				contador++;
				int x = tan.getCelda().getFila();
				int y = tan.getCelda().getCol();

				switch (tan.getDir()) {
				case 0: // Arriba

					tan.getGrafico().setBounds(y * 50, x * 50 - 6, 50, 50);
					break;

				case 1: // Abajo

					tan.getGrafico().setBounds(y * 50, x * 50 + 6, 50, 50);
					break;

				case 2: // Izquierda

					tan.getGrafico().setBounds(y * 50 - 6, x * 50, 50, 50);
					break;

				case 3: // Derecha
					tan.getGrafico().setBounds(y * 50 + 6, x * 50, 50, 50);
					break;
				}

				tan.setMovilidad(true);
				
			}
		}
	}

	public void empezar() {
		puedo = true;
	}

	public void setTanque(Tanque t) {
		tan = t;
	}

}