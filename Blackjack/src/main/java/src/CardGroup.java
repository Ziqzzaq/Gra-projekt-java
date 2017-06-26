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
	
	
	
	
	
	
	public int getTotalValue() {  //metoda licząca sume wartosci kart 
		int totalValue = 0;
		for (int i = 0; i < this.cards.size(); i++)
			totalValue += this.cards.get(i).value;
		return totalValue;
	}
	
	
	
	public int getNumAces() {  // jezeli jest as zwiększ zwroc 1 bo as robi coś specjalnego w blackjacku
		int numAces = 0;
		for (int i = 0; i < this.cards.size(); i++)
			if (this.cards.get(i).rank == "As")
				numAces++;
		return numAces;
	}

	public int getCount() {  // zwraca ilosć kart w liscie
		return this.cards.size();
	}

	public void print() {  // wyswietla karty w liscie
		for (int i = 0; i < this.cards.size(); i++) {
			this.cards.get(i).print();
		}
	}
	
	


}
