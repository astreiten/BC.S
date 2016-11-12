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
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logica lg;

	private JPanel contentPane;

	private Icon[] arreglo2 = new Icon[11];
	private JLabel label = new JLabel("");
	private JLabel label_1 = new JLabel("");
	private JLabel label_2 = new JLabel("");
	private final JLabel lblNewLabel = new JLabel();
	private JPanel panel_1;
	private JPanel panel;
	private final JLabel label_4 = new JLabel("");
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel label_5 = new JLabel("");
	private JLabel label_3 = new JLabel("");
	private final JLabel label_6 = new JLabel("");
	private final JLabel lblNewLabel_2 = new JLabel("");
	private int vidas = 3;

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

	private class OyenteTeclado extends KeyAdapter {
		protected GUI gui;

		public OyenteTeclado(GUI gui) {
			this.gui = gui;
		}

		public void keyPressed(KeyEvent arg0) {
			gui.mover(arg0);
		}
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		super("Super Battle City Reborned");

		addKeyListener(new OyenteTeclado(this));
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);

		arreglo2[0] = new ImageIcon(this.getClass().getResource("/Imagenes/0.png"));
		arreglo2[1] = new ImageIcon(this.getClass().getResource("/Imagenes/1.png"));
		arreglo2[2] = new ImageIcon(this.getClass().getResource("/Imagenes/2.png"));
		arreglo2[3] = new ImageIcon(this.getClass().getResource("/Imagenes/3.png"));
		arreglo2[4] = new ImageIcon(this.getClass().getResource("/Imagenes/4.png"));
		arreglo2[5] = new ImageIcon(this.getClass().getResource("/Imagenes/5.png"));
		arreglo2[6] = new ImageIcon(this.getClass().getResource("/Imagenes/6.png"));
		arreglo2[7] = new ImageIcon(this.getClass().getResource("/Imagenes/7.png"));
		arreglo2[8] = new ImageIcon(this.getClass().getResource("/Imagenes/8.png"));
		arreglo2[9] = new ImageIcon(this.getClass().getResource("/Imagenes/9.png"));
		arreglo2[10] = new ImageIcon(this.getClass().getResource("/Imagenes/Vidas.png"));
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 777, 657);
		contentPane.add(panel_1);
		panel_1.setVisible(false);
		panel_1.setBackground(Color.BLACK);
		panel_1.setLayout(null);
		lblNewLabel.setBounds(0, 0, 777, 646);

		panel_1.add(lblNewLabel);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(0, 0, 777, 657);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/InicioJuego.png")));

		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Boton.png")));
		btnNewButton.setSelectedIcon(null);
		btnNewButton.addMouseListener(new OyenteComenzar());

		btnNewButton.setBounds(201, 473, 394, 58);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBounds(652, 0, 125, 657);
		contentPane.add(panel);
		
		panel.setVisible(false);
		
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);

		label.setBounds(60, 309, 20, 20);
		label.setIcon(arreglo2[0]);
		panel.add(label);

		label_1.setBounds(80, 309, 20, 20);
		label_1.setIcon(arreglo2[0]);
		panel.add(label_1);

		label_2.setBounds(100, 309, 20, 20);
		label_2.setIcon(arreglo2[0]);
		panel.add(label_2);
		
		

		
		label_5.setBounds(21, 487, 25, 46);
		label_5.setIcon(arreglo2[10]);
		label_5.setVisible(true);
		panel.add(label_5);
		
		
		label_3.setBounds(40, 309, 20, 20);
		label_3.setIcon(arreglo2[0]);
		panel.add(label_3);
		label_6.setBounds(20, 309, 20, 20);
		label_6.setIcon(arreglo2[10]);
		panel.add(label_6);
		lblNewLabel_2.setIcon(arreglo2[3]);
		lblNewLabel_2.setBounds(50, 487, 20, 20);
		
		panel.add(lblNewLabel_2);

	}

	private class OyenteComenzar extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			btnNewButton.setVisible(false);
			lblNewLabel_1.setVisible(false);
			comenzarJuego();

		}
	}

	protected void mover(KeyEvent tecla) {

		int tec = tecla.getKeyCode();

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
			lg.disparoTanque(null);
			break;
		}

	}

	public Icon[] armarEtiqueta(int n) {
		Icon[] nuevo = new Icon[5];

		for (int i = 0; i < nuevo.length; i++) {
			nuevo[i] = arreglo2[n % 10];
			n /= 10;
		}
		
		label_6.setIcon(nuevo[4]);
		label_3.setIcon(nuevo[3]);
		label.setIcon(nuevo[2]);
		label_1.setIcon(nuevo[1]);
		label_2.setIcon(nuevo[0]);
		
		

	

		return nuevo;

	}

	public void gameOver() {
		contentPane.removeAll();
		contentPane.repaint();
		lg.destruirHilos();
		contentPane.add(panel_1);
		panel_1.setVisible(true);
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/GameOver.png")));

	}

	public void ganar() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.add(panel_1);
		panel_1.setVisible(true);
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/Ganar.png")));
		lg.destruirHilos();

	}

	public void comenzarJuego() {
		
		panel.setVisible(true);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(36, 74, 20, 20);
		panel.add(label_3);

		lg = new Logica("Nivel1.txt", this);
		int i;
		for (i = 0; i < 13; i++) {
			int j = 0;
			for (j = 0; j < 13; j++) {
				if (lg.getCelda(i, j).getObstaculo() != null) {
					getContentPane().add(lg.getCelda(i, j).getObstaculo().getGrafico());
				}

			}
		}

		contentPane.add(lg.cargarTanque());
		lg.jugador.setImagen(0);
		lg.cargarEnemigos();
	}
	
	public void incrementarVidas(){
		lblNewLabel_2.setIcon(arreglo2[vidas++]);
	}
	
	public void decrementarVidas(){
		lblNewLabel_2.setIcon(arreglo2[vidas--]);
	}
}
