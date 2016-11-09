package Game;

import PowerUp.PowerUpTemp;

public class Tiempo extends Thread {

	protected PowerUpTemp pw;
	protected boolean cond = false;

	public Tiempo() {

	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (cond) {
				pw.desafectar();
				cond = false;
			}
		}
	}

	public void setPw(PowerUpTemp a) {
		pw = a;
		cond = true;
	}
}
