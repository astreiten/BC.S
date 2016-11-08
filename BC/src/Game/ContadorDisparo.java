package Game;

public class ContadorDisparo extends Thread {

		private Bala b;
		private boolean puedo = false;
		

		public ContadorDisparo(Bala b) {
			this.b = b;
		}

		public void run() {
			while (true) {
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				

				if (puedo) {
					try {
						Thread.sleep(100 * b.getFuente().getVd());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					
					int x = b.getCelda().getFila();
					int y = b.getCelda().getCol();

					switch (b.getDir()) {
					case 0: // Arriba

						b.getGrafico().setBounds(y * 50, x * 50 - 4, 50, 50);
						break;

					case 1: // Abajo

						b.getGrafico().setBounds(y * 50, x * 50 + 4, 50, 50);
						break;

					case 2: // Izquierda

						b.getGrafico().setBounds(y * 50 - 4, x * 50, 50, 50);
						break;

					case 3: // Derecha
						b.getGrafico().setBounds(y * 50 + 4, x * 50, 50, 50);
						break;
					}

					b.setMovilidad(true);
					
				}
			}
		}

		public void empezar() {
			puedo = true;
		}

		public void setBala(Bala t) {
			b = t;
		}

	}

