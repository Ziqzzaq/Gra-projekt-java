package src;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CardGroupPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Ta klasa dziedziczy po JPanel i utworzy panel, która wyswietli obrazy kart
	
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
