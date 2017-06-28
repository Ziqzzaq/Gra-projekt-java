package src;

import java.awt.*;

import javax.swing.*;

/**
 * KLASA ImagePanel - Ta klasa dziedziczy po JPanel i tworzy ze zdjecia tlo
 * 
 */

public class ImagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Definicja  Obiektu zdjecia*/
	private Image img;

	/** Metoda  do obrazka by w razie czego dal orginalny rozmiar
	 * 
	 * @param imgStr tytul obrazka
	 * */
	public ImagePanel(String imgStr) { //podajemy tytuł obrazku
		this.img = new ImageIcon(imgStr).getImage();
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null)); // Jeżeli nie ustawiamy setBounds to daje obrazu rzeczywisty wymiar obrazu
		setSize(size);
		setLayout(null);
	}
	
	/** Metoda  do rysowanie obiektu do Jpanela */
	public void paintComponent(Graphics g) { //rysowanie obiektu do Jpanel
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}