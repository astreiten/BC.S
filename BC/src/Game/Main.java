package Game;

public class Main {
	public static void main(String args[]){
		Logica lg = new Logica("prueba.txt.txt");
		Celda[][] mt = lg.getMatriz();
		for(int i = 0; i < 13; i++){
			for(int j = 0; j < 13; j++){
				System.out.print(mt[i][j].toString());
			}
			System.out.println();
		}
		
	}

}
