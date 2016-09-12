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
		setBounds(100, 100, 650, 675 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(null);
		lg = new Logica("prueba.txt.txt");

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				if (lg.getCelda(i, j).getObstaculo()!= null) {
					add(lg.getCelda(i, j).getObstaculo().getGrafico());
				} 
				
			}
		}
		contentPane.add(lg.cargarTanque());
		
		
	}
	
	protected void mover(KeyEvent tecla){
		JLabel nueva = lg.moverJugador(tecla.getKeyCode());
		if( nueva != null){
			add(nueva);
		}
		
	}

}
