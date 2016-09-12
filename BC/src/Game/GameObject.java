package Game;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public class GameObject {
	protected JLabel grafico;
	protected Icon image[];
	protected final int ANCHO = 32;
	protected final int ALTO = 32;
	protected int velocidad;
	protected Celda celda;
	
	
	public GameObject(){
		image = new Icon[5];
		grafico = new JLabel();				
	}
	
	public JLabel getGrafico(){
		return grafico;
	}
	public void setGrafico(){
		grafico.setIcon(null);
	}
	
}
