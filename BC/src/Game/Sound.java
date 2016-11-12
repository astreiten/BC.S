package Game;

import java.applet.AudioClip;

public class Sound extends Thread {
	private AudioClip sonido;
	private boolean cond;
	
	public Sound(){
		cond = false;
	}

	public void run() {

		while (cond) {
			
			sonido.play();

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			cond = false;

			
		}
	}

	public void setSound(AudioClip s){
		sonido = s;
	}
	
	public void empezar(){
		cond = true;
	}
}
