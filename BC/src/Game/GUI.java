package Game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logica lg;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		super("Super Battle City Reborned");
		addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(null);
		lg = new Logica("Nivel1.txt");
		int i;
		for ( i = 0 ; i < 13; i++) {
			int j = 0;
			for ( j =0 ; j < 13; j++) {
				if (lg.getCelda(i, j).getObstaculo() != null) {
					getContentPane().add(lg.getCelda(i, j).getObstaculo().getGrafico());
				}

			}
		}
		JLabel [] arreglo = lg.cargarEnemigos();
		
		contentPane.add(arreglo[0]);
		contentPane.add(arreglo[1]);
		contentPane.add(lg.cargarTanque());
		
		JPanel panel = new JPanel();
		panel.setBounds(652, 0, 125, 657);
		contentPane.add(panel);
		panel.setBackground(Color.GRAY);
		

	}

	
		protected void mover(KeyEvent tecla) {
			int dir = 0;
			int tec=tecla.getKeyCode();
			switch (tec) {
			case KeyEvent.VK_UP: // Arriba
	            dir=0;
				break;

			case KeyEvent.VK_DOWN: // Abajo
	            dir=1;
				break;

			case KeyEvent.VK_LEFT: // Izquierda
				dir=2;
				break;

			case KeyEvent.VK_RIGHT: // Derecha
	            dir=3;
				break;
			}
			lg.moverJugador(dir);
			

		}
	}


