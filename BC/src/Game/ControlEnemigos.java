package Game;

public class ControlEnemigos extends Thread {

	private Logica logica;
	private boolean condicion;

	public ControlEnemigos(Logica l) {
		logica = l;
		condicion = true;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (condicion) {
				logica.moverEnemigos();
			}
			else{
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				condicion = true;
			}
		}

	}

	public void frenar() {
		condicion = false;

	}
}
