package Tanques;

public class Nivel4 extends State{
	public Nivel4(TanqueJugador tanque){
		tanque.cargarImagen(0,"Lvl4Up.gif");
		tanque.cargarImagen(1,"Lvl4Dw.gif");
		tanque.cargarImagen(2,"Lvl4L.gif");
		tanque.cargarImagen(3,"Lvl4R.gif");
		velocidad = 2;
		vd = 1;
		simul = 3;
	}

}
