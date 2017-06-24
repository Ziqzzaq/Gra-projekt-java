package src;

public class Card { // Ta klasa jest tworzona dla każdej karty i przechowuje informacje o niej
	// Zmienne do przechowywania rangi, koloru i wartości karty 
		public String rank = "", suit = "";
		public int value = 0;
		
		Card(String r, String s, int v) { // Konstruktor - inicjalizacja wartości
			this.rank = r;
			this.suit = s;
			this.value = v;
		}
}
