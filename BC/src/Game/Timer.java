package Game;

import PowerUp.PowerUp;
import PowerUp.PowerUpTemp;

public class Timer extends Thread {

	protected PowerUp pw;
	protected Logica lg;
	

	public Timer(Logica l) {
		lg = l;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!pw.getAgarrado()){
				lg.eliminarBloque(2, 6);
				pw.setAgarrado(true);
			}
		}
	}

	public void setPw(PowerUp a) {
		pw = a;		
	}
}
