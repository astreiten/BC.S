package Game;

public class ContadorAnimaciones extends Thread {
	
	private Logica logica;

	
	public ContadorAnimaciones(Logica l) {
		logica = l;
	
	}
	
	
	
	public void run() {
		
		while(true) {
				System.out.println("entre run");
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			logica.mostrarExplosion();
			
		}
	}

}
