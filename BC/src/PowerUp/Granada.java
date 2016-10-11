package PowerUp;


import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.type.TypeMirror;
import javax.swing.ImageIcon;

import Game.Celda;
import Game.GameObject;
import Game.Logica;
import Game.Visitante;
import Tanques.Tanque;
import Tanques.TanqueJugador;


public class Granada extends PowerUp {

	public Granada(Celda celdita, Logica l) {
		super(celdita, l );

		image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Granada.png"));

	}

	@Override
	public boolean colision(GameObject obj) {
		lg.destruirEnemigos(celda.getFila(), celda.getCol());
		
		return true;
	}
	
	public void afectar(){
		lg.destruirEnemigos(celda.getFila(), celda.getCol());
	}

	@Override
	public boolean  acept(Visitante v) {
		return v.visitar(this);
		
	}

	@Override
	public boolean visitar(Granada gra) {
		// TODO Auto-generated method stub
		return false;
	}






	
	
	


}
