package Game;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ContadorAnimaciones extends Thread {
	
	
	private JLabel eti;

	
	public ContadorAnimaciones() {
		eti = null;
	
	}
	
	
	
	public void run() {
		
		while(true) {
				
			try {
				Thread.sleep(800);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			eti.setIcon(null);
			
			
		}
	}
	
	public void setLabel(JLabel a){
		eti = a;
				
	}

}
