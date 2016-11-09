package Tanques;

public class Nivel3 extends State {
	public Nivel3(TanqueJugador tanque){
		tanque.cargarImagen(0,"Lvl3Up.gif");
		tanque.cargarImagen(1,"Lvl3Dw.gif");
		tanque.cargarImagen(2,"Lvl3L.gif");
		tanque.cargarImagen(3,"Lvl3R.gif");
		velocidad = 1;
		vd = 3;
		simul = 2;
	}

}
