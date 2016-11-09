package Game;

public class ControlDisparo extends Thread{
	
	protected Logica lg;
	
	public ControlDisparo(Logica l){
		lg = l;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			lg.moverBalas();
		}
	}

}

