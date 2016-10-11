package Game;

public class ControlEnemigos extends Thread {
	
	private Logica logica;
	
	public ControlEnemigos(Logica l) {
		logica = l;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			logica.moverEnemigos();
		}
	}
	

}
