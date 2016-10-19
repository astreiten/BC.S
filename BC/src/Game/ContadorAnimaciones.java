package Game;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ContadorAnimaciones extends Thread {
	
	private Logica logica;
	private JLabel obj;

	
	public ContadorAnimaciones(Logica l) {
		logica = l;
		obj = null;
	
	}
	
	
	
	public void run() {
		
		while(true) {
				
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			if(obj != null){
			ImageIcon  a = new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.gif"));
			obj.setIcon(a);
			obj = null;
			}
			
		}
	}
	
	public void setObject(JLabel a){
		obj = a;
				
	}

}
