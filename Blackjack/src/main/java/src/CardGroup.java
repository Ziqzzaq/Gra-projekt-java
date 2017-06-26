package src;

import java.util.ArrayList;

public class CardGroup {
	
	public ArrayList<Card> cards = new ArrayList<Card>(); // wstępna lista kart
	
	public void initFullDeck() {   // nadanie wartości kart
		this.cards.clear();
		String[] ranks = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Walet", "Dama", "Król" };
		int[] rankValues = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

		String[] suits = { "Trefl", "Kier", "Karo", "Pik" };

		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				this.cards.add(new Card(ranks[i], suits[j], rankValues[i]));
			}
		}
	}


}
