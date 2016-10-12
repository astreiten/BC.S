package Game;

public class ControlDisparo extends Thread{
	
	protected Logica lg;
	
	public ControlDisparo(Logica l){
		lg = l;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(400);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Estoy tratando de mover");
			lg.moverBalas();
		}
	}

}
