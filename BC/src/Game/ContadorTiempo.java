package Game;

public class ContadorTiempo extends Thread {
	
	private Logica logica;
	
	public ContadorTiempo(Logica l) {
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
