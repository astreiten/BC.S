package Tanques;

import javax.swing.ImageIcon;

public class Nivel2 extends State{
	
	public Nivel2(TanqueJugador tanque){
		tanque.cargarImagen(0,"Nivel_2_Arriba.png");
		tanque.cargarImagen(1,"Nivel_2_Abajo.png");
		tanque.cargarImagen(2,"Nivel_2_Izq.png");
		tanque.cargarImagen(3,"Nivel_2_Der.png");
	}

}
