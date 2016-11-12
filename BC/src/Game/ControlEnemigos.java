package Game;

public class ControlEnemigos extends Thread {

	private Logica logica;
	private boolean condicion;
	public boolean start;

	public ControlEnemigos(Logica l) {
		logica = l;
		condicion = true;
		start = true;
	}

	public void run() {
		while (start) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			logica.moverEnemigos(condicion);

			if (!condicion) {
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
	
	public void destruir(){
		start = false;
	}
}
