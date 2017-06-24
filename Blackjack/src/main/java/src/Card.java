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
		
		public void print() { // Wyswietla informacje o karcie w konsoli- pomocne przy debugowaniu 
			System.out.printf("%s of %s, value %d\n", this.rank, this.suit, this.value);
		}
		
		public String getFileName() { //Pobranie nazwy pliku obrazu dla karty
			return String.format("cardImages/%s/%s.png", this.suit,this.rank);
		}

}
