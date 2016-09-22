package Game;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

import Tanques.Tanque;

public abstract class GameObject {
	protected JLabel grafico;
	protected Icon image[];
	protected final int ANCHO = 32;
	protected final int ALTO = 32;
	protected int velocidad;
	protected Celda celda;
	//protected boolean esAtravesable;
	
	
	public GameObject(Celda celdita){
		image = new Icon[5];
		celda = celdita;
		grafico = new JLabel();
		grafico.setBounds(celda.getCol(),celda.getFila(),50, 50);
		
	}
	
	public Celda getCelda(){
		return celda;
	}
	
	public void setCelda(Celda celdita){
		celda = celdita;
	}
	
	public JLabel getGrafico(){
		return grafico;
	}
	public void setGrafico(){
		grafico.setIcon(null);
	}
	
	public abstract boolean colision(GameObject obj);
	
	
	
	public void setImagen(int indice){
		grafico.setIcon(image[indice]);
		grafico.setBounds(celda.getCol()*50,celda.getFila()*50,50, 50);
	}
	
}
