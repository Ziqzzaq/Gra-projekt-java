package src;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * KLASA CardGroupPanel - Ta klasa dziedziczy po JPanel i utworzy panel, która wyswietli obrazy kart jej wielkosc szerokosc itp
 * 
 */

public class CardGroupPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	
	/** 
	 * Konstruktor - do tworzenia kary pobierania obrazu i wyswietlania jej w swoim panelu o odpowiedniej wielkosci
	 * @param left 
	 * @param top
	 * @param width
	 * @param height
	 * @param gap do szerokosci jak cos
	 */

		CardGroupPanel(CardGroup cardGroup, int left, int top, int width, int height, int gap) {

			int numCards = cardGroup.cards.size();

			setBounds(left, top, 35 + numCards * (width + gap), height);
			setLayout(null);
			setOpaque(false);

			int total = cardGroup.getTotalValue();
			if (total > 21 && cardGroup.getNumAces() > 0)
				total -= 10;

			JLabel playerScoreLbl = new JLabel((total == 21 ? "BJ" : total) + "");
			playerScoreLbl.setForeground(Color.GRAY);
			playerScoreLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			playerScoreLbl.setVerticalAlignment(SwingConstants.CENTER);
			playerScoreLbl.setHorizontalAlignment(SwingConstants.RIGHT);
			playerScoreLbl.setBounds(0, 0, 30, height);
			add(playerScoreLbl);

			for (int i = 0; i < numCards; i++) {
				ImagePanel cardImagePanel = new ImagePanel(cardGroup.cards.get(i).getFileName());
				cardImagePanel.setBounds(35 + i * (width + gap), 0, width, height);
				add(cardImagePanel);
			}
		}
		
	

}
