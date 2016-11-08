package Tanques;

import javax.swing.ImageIcon;

public class Nivel1 extends State{
	
	public Nivel1(TanqueJugador tanque){
		tanque.cargarImagen(0,"JugadorAr.gif");
		tanque.cargarImagen(1,"JugadorAb.gif");
		tanque.cargarImagen(2,"JugadorIzq.gif");
		tanque.cargarImagen(3,"JugadorDer.gif");
		velocidad = 5;
		vd = 5;
	}

}
