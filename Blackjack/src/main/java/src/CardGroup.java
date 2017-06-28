package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * KLASA CardGroup - Ta klasa jest tworzona dla nadania wartosci kart i modernizacji jej w liscie
 * 
 */


public class CardGroup {
	
	/** Definicja  Listy obiektow cards ktora bedzie posiadac nasze karty */
	public ArrayList<Card> cards = new ArrayList<Card>(); // wstępna lista kart

	/** 
	 * Metoda do nadanie wartości kart
	 */
	
	public void initFullDeck() { 
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

	/** 
	 * Metoda ktora Usuwa kartę z góry ArrayList i zwraca ją
	 * @return Card zwraca nastepna karte i usuwa ja z listy card w decu
	 */
	public Card takeCard() { 
		if (this.cards.size() < 1) {
			System.out.println("Error: Nie ma wiecej kart!");
			System.exit(0);
		}
		Card tempCard = this.cards.get(this.cards.size() - 1);
		this.cards.remove(this.cards.size() - 1);
		return tempCard;	
	
	}


	/** 
	 * Metoda ktora tasuje karty
	 */
	
	public void shuffle() {
		long seed = System.nanoTime(); // Ustalenie wartości random by przybliżyć jak najbardziej do rzeczywistego tasowania
		Collections.shuffle(this.cards, new Random(seed)); // tasowanie Decku
	}
	
	/** 
	 * metoda licząca sume wartosci kart
	 * @return zwraca sume wartosi kart
	 */
	public int getTotalValue() { 
		int totalValue = 0;
		for (int i = 0; i < this.cards.size(); i++)
			totalValue += this.cards.get(i).value;
		return totalValue;
		
	}

	/** 
	 * metoda  ze jezeli jest As zwiększ NumAces bo As może przyjąc wartość 1 lub 11 w zależności od kart
	 *  @return zwarca odpowiednia wartosc dla asa
	 */
	
	public int getNumAces() { 
		int numAces = 0;
		for (int i = 0; i < this.cards.size(); i++)
			if (this.cards.get(i).rank == "As")
				numAces++;
		return numAces;
	
		
	}
	
	/** 
	 * metoda   zwraca ilosć kart w liscie
	 * @return zwraca ilosc kart w liscie
	 */
	public int getCount() {
		return this.cards.size();
	
	}
	
	
	/** 
	 * metoda  wyswietla karty w liscie 
	 */
	public void print() { 
		for (int i = 0; i < this.cards.size(); i++) {
			this.cards.get(i).print();
		}
	}

}
