package code;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
//import javax.swing.JPanel;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private MyPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(595, 375, 440, 190);
		contentPane = new MyPanel(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Sokoban");
		setContentPane(contentPane);

		JTextPane lblNom = new JTextPane();
		lblNom.setEditable(false);
		lblNom.setText("Entrez votre nom:");
		contentPane.add(lblNom);

		JEditorPane txtNom = new JEditorPane();
		contentPane.add(txtNom);

		JButton btnJouer = new JButton("Jouer");
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Création de la boite en mémoire
				Sokoban JouerFenetre = new Sokoban();

				// Affichage de la boite
				JouerFenetre.setVisible(true);

			}
		});
		btnJouer.setBounds(180, 120, 70, 21);
		contentPane.add(btnJouer);
	}

}
