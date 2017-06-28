package src;





/**
 * KLASA Card - Ta klasa jest tworzona dla każdej karty i przechowuje informacje o niej
 * 
 */

public class Card { 
	/** Definicja  pola dla nazwy i rankingu*/
		public String rank = "", suit = "";
		public int value = 0;
		
		/** 
		 * Konstruktor - inicjalizacja wartości
		 * @param r wartosc karty slownie uzyta by wskazac odpowiedni nr pliku zdjecia
		 * @param s odpowiednia kategoria kart np trefl pik itp
		 * @param v wartosc kart w intach
		 */
		Card(String r, String s, int v) { 
			this.rank = r;
			this.suit = s;
			this.value = v;
		}
		/** 
		 * Metoda Wyswietla informacje o karcie w konsoli- pomocne przy debugowaniu 
		 */
		public void print() { 
			System.out.printf("%s of %s, value %d\n", this.rank, this.suit, this.value);
		}
		
		/** 
		 * Metoda  Pobranie nazwy pliku obrazu dla karty
		 * Jeżeli wartość karty wynosi 0 tzn, że jest odwrócona i należy przypisać jej odpowiedni obrazek
		 * @return zwraca odpowiednie zdjecie
		 */
		public String getFileName() { 
			if (value == 0) 
				return "src/main/resources/cardImages/backCover.png";
			return String.format("src/main/resources/cardImages/%s/%s.png", this.suit,this.rank);
		
		}

}
