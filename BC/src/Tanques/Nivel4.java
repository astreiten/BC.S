package Tanques;

public class Nivel4 extends State{
	public Nivel4(TanqueJugador tanque){
		tanque.cargarImagen(0,"JugadorLvl2Up.gif");
		tanque.cargarImagen(1,"JugadorLvl2Down.gif");
		tanque.cargarImagen(2,"JugadorLvl2Left.gif");
		tanque.cargarImagen(3,"JugadorLvl2Right.gif");
		velocidad = 1;
		vd = 1;
	}

}
