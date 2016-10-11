package Game;

public class ContadorAnimaciones extends Thread {
	
	private Logica logica;
	private boolean condicion;
	
	public ContadorAnimaciones(Logica l) {
		logica = l;
		condicion = false;
	}
	
	public void setCond(boolean a){
		condicion =a;
		
		
	}
	
	public void run() {
		System.out.println("Entre run");
		while(condicion) {
			logica.mostrarExplosion();
			System.out.println("Entre");
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			condicion= false;
		}
	}

}
