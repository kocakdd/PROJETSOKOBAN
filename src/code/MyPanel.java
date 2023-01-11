package code;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")

class MyPanel extends JPanel {
	// Réference sur la fenêtre principale
	private Main mainWindow;

	/**
	 * constructeur
	 * 
	 * @param mWindow
	 */
	public MyPanel(Main mWindow) {
		mainWindow = mWindow;
	}

	/**
	 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la méthode dessiner de la fenêtre principale..
	}
}