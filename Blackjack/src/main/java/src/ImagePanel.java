
package src;
import java.awt.*;

import javax.swing.*;

//klasa która po nazwie pliku zwraca Jpanel z dopasowanym obrazem

class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Image img;

	public ImagePanel(String imgStr) { //podajemy tytuł obrazku
		this.img = new ImageIcon(imgStr).getImage();
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null)); // Jeżeli nie ustawiamy setBounds to daje obrazu rzeczywisty wymiar obrazu
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) { //rysowanie obiektu do Jpanel
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}