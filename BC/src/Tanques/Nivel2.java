package Tanques;

import javax.swing.ImageIcon;

public class Nivel2 extends State{
	
	public Nivel2(TanqueJugador tanque){
		tanque.cargarImagen(0,"JugadorLvl2Up.gif");
		tanque.cargarImagen(1,"JugadorLvl2Down.gif");
		tanque.cargarImagen(2,"JugadorLvl2Left.gif");
		tanque.cargarImagen(3,"JugadorLvl2Right.gif");
		velocidad = 2;
		vd = 1;
	}

}
