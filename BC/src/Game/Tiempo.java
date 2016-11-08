package Game;

import PowerUp.PowerUpTemp;

public class Tiempo extends Thread {

	protected PowerUpTemp pw;

	public Tiempo() {

	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			pw.desafectar();
		}
	}

	public void setPw(PowerUpTemp a) {
		pw = a;
	}
}
