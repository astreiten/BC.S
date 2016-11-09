package Tanques;

public class Nivel3 extends State {
	public Nivel3(TanqueJugador tanque){
		tanque.cargarImagen(0,"JugadorLvl2Up.gif");
		tanque.cargarImagen(1,"JugadorLvl2Down.gif");
		tanque.cargarImagen(2,"JugadorLvl2Left.gif");
		tanque.cargarImagen(3,"JugadorLvl2Right.gif");
		velocidad = 1;
		vd = 1;
	}

}
