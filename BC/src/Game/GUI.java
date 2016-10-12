package Game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logica lg;

	private JPanel contentPane;

	private boolean entre = false;
	private Icon[] arreglo2 = new Icon[9];
	private JLabel label = new JLabel("");
	private JLabel label_1 = new JLabel("");
	private JLabel label_2 = new JLabel("");

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
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(null);
		lg = new Logica("Nivel1.txt", this);
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
		panel.setLayout(null);
			
		arreglo2[0]= new ImageIcon(this.getClass().getResource("/Imagenes/0.png"));
		
		arreglo2[2]= new ImageIcon(this.getClass().getResource("/Imagenes/2.png"));
	
		
		
		
		
		
		
		
		
		
		
		label.setBounds(21, 309, 20, 20);
		label.setIcon(arreglo2[0]);
		panel.add(label);
		
		
		label_1.setBounds(51, 309, 20, 20);
		label_1.setIcon(arreglo2[0]);
		panel.add(label_1);
		
		
		label_2.setBounds(83, 309, 20, 20);
		label_2.setIcon(arreglo2[0]);
		panel.add(label_2);
		
		
		
		
		
		
		contentPane.add(lg.insertarPowerUp());
		

	}

	protected void mover(KeyEvent tecla) {
	
		int tec = tecla.getKeyCode();

		System.out.println(tec);
		switch (tec) {
		case KeyEvent.VK_UP: // Arriba
			lg.moverJugador(0);
			break;

		case KeyEvent.VK_DOWN: // Abajo
			lg.moverJugador(1);
			break;

		case KeyEvent.VK_LEFT: // Izquierda
			lg.moverJugador(2);
			break;

		case KeyEvent.VK_RIGHT: // Derecha
			lg.moverJugador(3);
			break;
		case 32:
			lg.disparoJugador();
			break;
		}
	

	}

	public Icon[] armarEtiqueta(int n) {
		Icon [] nuevo = new Icon[3];
		
		for(int i = 0; i < nuevo.length; i++){
			nuevo[i] = arreglo2[n % 10];
			n /= 10;		
		}
		
		label.setIcon(nuevo[2]);
		label_1.setIcon(nuevo[1]);
		label_2.setIcon(nuevo[0]);
		
		return nuevo;
		

	}
}
