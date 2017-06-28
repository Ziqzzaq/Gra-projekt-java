package src;
/**
 * @author Rafał Warzyński, Michał Borzędzki
 * @version 1.0
 * @since 1.0
 * 
 * 
 */






import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Klasa Blackjack wywołuje wygląd okna. + zarządza mechaniką gry + zawiera main czyli wywołuje cały program
 * 
 */
public class Blackjack {
	
	
	
	private static JFrame frame = new MainFrame();
	
	
	/** Definicja  Obiektu przycisk nowa gra*/
	private static JButton btnNewGame;
	/** Definicja  Obiektu przycisk Końca gry*/
	private static JButton btnEndGame;	//	przycisk koniec gry
	/** Definicja  Obiektu pola tekstowe do zapisania kasy ktora mamy na poczatkua*/
	private static JTextField tfBalance;	//	pole tekstowe do zapisania kasy ktora mamy na poczatku
	
	/** Definicja  Obiektu teksty do pczatkowej kasy*/
	private static JLabel lblInitialBalance;  // tekst do pczatkowej kasy
	
	/** Definicja  pola zapis ile masz w banku*/
	private static double kieszen = 0.0; // zapis ile masz w banku
	
	/** Definicja  pola do obstawiania i liczaca ilosc rund*/
	private static int betAmount = 0, roundCount = 0;  // zmienne do obstawiania
	
	/** Definicja  obiektu napisy ile ma*/
	private static JLabel lblHowInitial; // napisy ile ma
	
	/** Definicja  obiektu ile masz kasy w kieszeni*/
	private static JLabel lblHowKasaWKieszeni;  // ile masz kasy w kieszeni
	
	/** Definicja  obiektu napis nasz ze projetk*/
	private static JLabel lblPrzedstawienie; // napis nasz ze projetk
	
	/** Definicja  obiektu informacje o błedach itp.*/
	private static JLabel lblInfo; // informacje o błedach itp.
	
	/** Definicja  obiektu napis .*/
	private static JLabel lblEnterBet; // napis
	
	/** Definicja  obiektu do wpisywania ile obstawisz.*/
	private static JTextField tfBetAmount; // pole do wpisywania ile obstawisz
	
	/** Definicja  Obiektu przycisku continure*/
	private static JButton btnContinue;
	
	/** Definicja  Obiektu przycisku Deal*/
	private static JButton btnDeal;  // przycisk do obstawiania
	
	/** Definicja  Obiektu przycisku Hit*/
	private static JButton btnHit;
	
	/** Definicja  Obiektu przycisku Stand*/
	private static JButton btnStand;
	
	/** Definicja  Obiektu napisu ile obstawiasz*/
	private static JLabel lblBetAmount;
	/** Definicja  Obiektu napisu ile obstawiasz*/
	private static JLabel lblBetAmountDesc;
	/** Definicja  Obiektu napisu do informacji*/
	private static JLabel lblShuffleInfo = null;
	
	/** Definicja  Obiektu kart ktore uzyjemy*/
	private static CardGroup deck, dealerCards, playerCards;
	
	/** Definicja  Obiektu panelow dla gracza i dealara*/
	private static CardGroupPanel dealerCardPanel = null, playerCardPanel = null; // talia kart,  dealera i gracza, panele do kart
	/** Definicja  Obiektu kart dla dealara*/
	private static Card dealerHiddenCard; 
	
	/** Definicja  Obiektu napisu Dealer*/
	private static JLabel lblDealer;
	/** Definicja Obiektu napisu Dealer*/
	private static JLabel lblPlayer;
	
	
	/**
     * Metoda ustawienia  głównych przyciskow po lewej stronie
     */
	
	public static void initGuiObjects() { // ustawienie  głównych przyciskow po lewej stronie
		btnNewGame = new JButton("New Game"); // przycisk nowa gra
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // co się dzieje po wcisnieciu nowa gra
				newGame(); 
			}
		});
		
		btnNewGame.setBounds(20, 610, 120, 50);
		frame.getContentPane().add(btnNewGame);
		
		btnEndGame = new JButton("End Game"); // przycisk konca gry i resetuje program.
		btnEndGame.setEnabled(false);  // na razie go wylacze
		btnEndGame.setBounds(150, 610, 120, 50);
		btnEndGame.addActionListener(new ActionListener() {  // co sie dzieje po nacisnieciu end game
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll(); // usuwanie wszystkich elementow z ekranu
				frame.repaint(); // powtarzanie aby wyswietlic to co sie zmienilo
				initGuiObjects(); // restart mechaniki gry..
			}
		});
		frame.getContentPane().add(btnEndGame);
		
		tfBalance = new JTextField(); //pole tekstowe do zapisania początkowej kasy
		tfBalance.setText("100");
		tfBalance.setBounds(180, 580, 89, 28);
		frame.getContentPane().add(tfBalance);
		tfBalance.setColumns(10);
		
		lblInitialBalance = new JLabel("Ile masz w portfelu?"); // napiss przy belce kasy
		lblInitialBalance.setFont(new Font("Arial", Font.BOLD, 13));
		lblInitialBalance.setForeground(Color.WHITE);
		lblInitialBalance.setBounds(20, 585, 250, 16);
		frame.getContentPane().add(lblInitialBalance);
		
		
		lblPrzedstawienie = new JLabel("Projekt z Java."); // takie se wstawilem napisy u gory
		lblPrzedstawienie.setBackground(Color.ORANGE);
		lblPrzedstawienie.setOpaque(false);
		lblPrzedstawienie.setForeground(Color.ORANGE);
		lblPrzedstawienie.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrzedstawienie.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrzedstawienie.setBounds(290, 5, 320, 28);
		frame.getContentPane().add(lblPrzedstawienie);
		
		
		
		
	}
	
	/**
     * Metoda ustawienia  przycisków obstawiania  po prawej stronie
     */
	
	public static void showBetGui() {  
		
		btnEndGame.setEnabled(true);  // gdy new game to wączymy end game
		
		//juz dziala brakowalo na koncu funkcji frame.repaint();
		
		lblEnterBet = new JLabel("Stawka:"); // napis przy belce do obstawiania
		lblEnterBet.setFont(new Font("Arial", Font.BOLD, 14));
		lblEnterBet.setForeground(Color.WHITE);
		lblEnterBet.setBounds(700, 585, 250, 16);
		frame.getContentPane().add(lblEnterBet);
		
		
		

		lblHowInitial = new JLabel("Pozostało środków:"); // napis
		lblHowInitial.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowInitial.setFont(new Font("Arial", Font.BOLD, 16));
		lblHowInitial.setForeground(Color.WHITE);
		lblHowInitial.setBounds(315, 578, 272, 22);
		frame.getContentPane().add(lblHowInitial);
		
		
		lblHowKasaWKieszeni = new JLabel(); // pokazuje ile masz kasy w kieszeni
		lblHowKasaWKieszeni.setText(String.format("$%.2f", kieszen));
		lblHowKasaWKieszeni.setForeground(Color.ORANGE);
		lblHowKasaWKieszeni.setFont(new Font("Arial", Font.BOLD, 40));
		lblHowKasaWKieszeni.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowKasaWKieszeni.setBounds(315, 600, 272, 50);
		frame.getContentPane().add(lblHowKasaWKieszeni);
		
		
		
		lblInfo = new JLabel("By grać dalej naciśnij Deal "); // napis do zmiany jeżeli będzie jakiś błąd
		lblInfo.setBackground(Color.ORANGE);
		lblInfo.setOpaque(false);
		lblInfo.setForeground(Color.ORANGE);
		lblInfo.setFont(new Font("Arial", Font.BOLD, 16));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(290, 482, 320, 28);
		frame.getContentPane().add(lblInfo);

		
		
		
		
		tfBetAmount = new JTextField(); // ile obstawisz 
		tfBetAmount.setText("10");
		tfBetAmount.setBounds(790, 580, 89, 28);
		frame.getContentPane().add(tfBetAmount);
		
		
		btnDeal = new JButton("Deal"); // Deal button :D
		btnDeal.setBounds(679, 610, 200, 50);
		btnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deal();
			}
		});
		frame.getContentPane().add(btnDeal);
		btnDeal.requestFocus();
		
		
		frame.repaint();
	}
	
	/**
     * Metoda zmiana ze stringa na inta w polu tekstowym tfBalance musi byc liczba calkowita
     */
	public static boolean convertStringtoInt(String s) { 
		try {
			if (Integer.parseInt(s) > 0) // Ensure amount entered is > 0
				return true;
			else
				return false;
		} catch (NumberFormatException e) { // If not valid integer
			return false;
		}
	}
	
	
	/**
     * Metoda po nacisnieciu przycisku New game tu jest metoda showBetGui by pokazywaly sie przyciski po prawej no i 
     * 
     */
	
	public static void newGame(){ // nowa funkcja zapisze bo ci nie chce psuc Michal
		
		if (convertStringtoInt(tfBalance.getText()) == true) { // sprawdzanie czy kasa sie zgadza
			kieszen = Integer.parseInt(tfBalance.getText());
		} else {
			JOptionPane.showMessageDialog(frame, "Liczba nie poprawna!!!", "Nie oszukuj", JOptionPane.ERROR_MESSAGE);
			tfBalance.requestFocus();
			return;
		}

		btnNewGame.setEnabled(false);
		tfBalance.setEnabled(false);
		
		showBetGui();  // i dopiero odpalimy Gui po prawej
		
		roundCount = 0;

		deck = new CardGroup(); // inicjalizacja kart przeciwnika
		deck.initFullDeck(); // dodawanie wszystkich kart (52)
		deck.shuffle(); // tasowanie kart
		
	}
	
	/**
     * Metoda po nacisnieciu przycisku deal tu jest metoda do pokazania przyciskow hit stand i ma metody by pokazac karty
     * 
     */
		public static void deal() { // Działa po naciśnięciu przycisku Deal. Przycisk Deal wstępnie ma wyswtietlic aktualna gre ale to sie zobaczy..
			
			if (lblShuffleInfo != null) // Co 5 rund deck jest przetasowywany
				frame.getContentPane().remove(lblShuffleInfo);

			// Inicjalizacja kart
			dealerCards = new CardGroup();
			playerCards = new CardGroup();
			
			if (convertStringtoInt(tfBetAmount.getText()) == true) { // podanie wartosci do obstawianie z kieszerni w polu tekstowym zamieniamy ja na inty
				betAmount = Integer.parseInt(tfBetAmount.getText());
			} else {
				lblInfo.setText("Podaj liczbe naturalną"); // jezeli to nie bedzie liczba lub cos wyswietl blad
				tfBetAmount.requestFocus();
				return;
			}
			
			
			if (betAmount > kieszen) { // jezeli chcemy obstawic wiecej niz mamy w kieszeni to error
				lblInfo.setText("Nie masz tylu pieniędzy"); // nie masz tyle w kieszeni
				tfBetAmount.requestFocus();
				return;
			}
			kieszen -= betAmount; // usuwanie z kieszeni tyle ile obstawiamy
			
			lblHowKasaWKieszeni.setText(String.format("$%.2f", kieszen));  // wyswietlenie zmieniamy wartosc w naszej kieszeni po odjeciu tego co podstawiasz
		
			tfBetAmount.setEnabled(false);  // wylaczamy przyciski podczas gry
			btnDeal.setEnabled(false);  

			lblInfo.setText("Prosze wybrać HIT lub STAND"); // instrukcja do wyboru przycisku
			
			
			lblDealer = new JLabel("Dealer"); // Etykieta Dealer 
			lblDealer.setForeground(Color.WHITE);
			lblDealer.setFont(new Font("Arial Black", Font.BOLD, 20));
			lblDealer.setBounds(415, 158, 82, 28);
			frame.getContentPane().add(lblDealer);

			lblPlayer = new JLabel("Player"); // Etykieta gracza 
			lblPlayer.setForeground(Color.WHITE);
			lblPlayer.setFont(new Font("Arial Black", Font.BOLD, 20));
			lblPlayer.setBounds(415, 266, 82, 28);
			frame.getContentPane().add(lblPlayer);
			
			
			lblBetAmount = new JLabel(); //Pokaż kwotę zakładu
			lblBetAmount.setText("$" + betAmount);
			lblBetAmount.setHorizontalAlignment(SwingConstants.CENTER);
			lblBetAmount.setForeground(Color.ORANGE);
			lblBetAmount.setFont(new Font("Arial", Font.BOLD, 40));
			lblBetAmount.setBounds(679, 488, 200, 50);
			frame.getContentPane().add(lblBetAmount);

			lblBetAmountDesc = new JLabel("Grasz Za:"); // etykieta informacji dotyczących kwoty zakładu
			lblBetAmountDesc.setHorizontalAlignment(SwingConstants.CENTER);
			lblBetAmountDesc.setForeground(Color.WHITE);
			lblBetAmountDesc.setFont(new Font("Arial", Font.BOLD, 16));
			lblBetAmountDesc.setBounds(689, 465, 190, 22);
			frame.getContentPane().add(lblBetAmountDesc);
			
			
			
			
			
			
			btnContinue = new JButton("Continue"); // Po osiągnięciu ostatecznego wyniku naciśnij przycisk, aby zaakceptować i kontynuować grę
			btnContinue.setEnabled(false); // na razie wylaczony
			btnContinue.setVisible(false);
			btnContinue.setBounds(290, 444, 320, 35);
			btnContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					continPoWyniku();
				}
			});
			frame.getContentPane().add(btnContinue);
			
			
			btnHit = new JButton("Hit"); // Hit button
			btnHit.setBounds(290, 515, 140, 35);
			btnHit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					hit();
				}
			});
			frame.getContentPane().add(btnHit);
			btnHit.requestFocus();

			btnStand = new JButton("Stand"); // Stand button
			btnStand.setBounds(470, 515, 140, 35);
			btnStand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stand();
				}
			});
			frame.getContentPane().add(btnStand);
			btnStand.requestFocus();
			
			frame.repaint();
			
			
			dealerHiddenCard = deck.takeCard(); // Weź kartę z talii  dealera, ale ukrywaj ją
			dealerCards.cards.add(new Card("", "", 0)); // Dodaj odwróconą kartę do kart dealera
			dealerCards.cards.add(deck.takeCard()); // dodaj karte

			
			// dodanie 2 kart z góry talii gracza
			playerCards.cards.add(deck.takeCard());
			playerCards.cards.add(deck.takeCard());
			
			
			updateCardPanels(); 
			
			
		}
		
		
		/**
	     * Metoda do mechaniki gry automatycznie sie wlacza jezeli gracz ma powyzej 21 lub rowna 21 wwartosc kart
	     * 
	     */
		public static boolean simpleOutcomes() { 
			
			boolean outcomeHasHappened = false;
			int playerScore = playerCards.getTotalValue(); // pobranie calej wartosci kart gracza
			
			if (playerScore > 21 && playerCards.getNumAces() > 0)
				playerScore -= 10;									//jezeli gracz ma wynik powyzej 21 i jednoczesnie wartosc asa jest powyzej 0 dodaj do wyniku gracza 10

			if (playerScore == 21) { // jezeli ma 21 to koniec bo wygral

				dealerCards.cards.set(0, dealerHiddenCard); // Zamiana schowanej karty dealera z aktualna karta
				updateCardPanels(); // wyswietlenie nowej karty
				if (dealerCards.getTotalValue() == 21) { // jezeli dealer ma black jacka to koniec
					lblInfo.setText("Remis"); // jezeli 2 osoby maja blackjack
					kieszen += betAmount; // Give bet back to player
				} else {
					// Jezeli tylko gracz ma blackjack
					lblInfo.setText(String.format("Masz Blackjack!! ZYSK - $%.2f", 1.5f * betAmount));
					kieszen += 2.5f * betAmount; // dodanie zysku do portfela
				}
				lblHowKasaWKieszeni.setText(String.format("$%.2f", kieszen)); // Wyswietl nowa kieszen

				outcomeHasHappened = true;
				outcomeHappened();//na koniec rundy wyswietl rezultat i przycisk continue
				
			} else if (playerScore > 21) { // jezeli gracz przekroczyl 21 to
				lblInfo.setText("Przekroczyles 21! Strata: $" + betAmount);
				dealerCards.cards.set(0, dealerHiddenCard); // zamiana karty schowanej z aktualna kartą
				updateCardPanels();
				outcomeHasHappened = true;
				outcomeHappened(); //na koniec rundy wyswietl rezultat i przycisk continue
			}
			return outcomeHasHappened;

		}
		
		
		/**
	     * Metoda ktora po zakonczeniu rundy wyswietla przycisk continue
	     */
		
		public static void outcomeHappened() { //Wyswietla przycisk continue i rezultat
			btnHit.setEnabled(false);
			btnStand.setEnabled(false);

			// Efekty ramki
			lblInfo.setOpaque(true);
			lblInfo.setForeground(Color.RED);
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					btnContinue.setEnabled(true);
					btnContinue.setVisible(true);
					btnContinue.requestFocus();
				}
			}, 500);

		}
		
		/**
	     * Metoda ktora sie uruchamia po nacisnieciu przycisku Hit jest w niej czyli dodaje karte nowa i pobiera dla niej obraz
	     * no i sprawdza mechanike >21 lub ==21
	     */
		
		public static void hit() { // dodaje nowa karte do kart gracza i sprawdza wynik.

			playerCards.cards.add(deck.takeCard());
			updateCardPanels();

			simpleOutcomes();

		}
		/**
	     * Metoda ktora sie uruchamia po nacisnieciu przycisku stand zostawia karty i wlacza mechanike gry
	     * 
	     */
		public static void stand() { // Kiedy przyciśniety standButton
			if (simpleOutcomes()) // Sprawdza wyniki 
				return;

			int playerScore = playerCards.getTotalValue(); // Wynik jaki uzyskał gracz
			if (playerScore > 21 && playerCards.getNumAces() > 0) // //jezeli gracz ma wynik powyzej 21 i jednoczesnie wartosc asa jest powyzej 0 dodaj do wyniku gracza 10
				playerScore -= 10;

			dealerCards.cards.set(0, dealerHiddenCard); // zamiana karty schowanej z aktualna kartą

			int dealerScore = dealerCards.getTotalValue(); // Wynik jaki uzyskał dealer

			while (dealerScore < 16) { // Jeżeli dealer na ręce ma karty o wartości poniżej 16, musi wziąć więcej kard aż nie osiągnie wyniku powyżej 16 
				dealerCards.cards.add(deck.takeCard()); // Weż kartę z góry decku i dodaj 
				dealerScore = dealerCards.getTotalValue();
				if (dealerScore > 21 && dealerCards.getNumAces() > 0) // Jeżeli jest As i wartość kart wynosi ponieżej 21 to odejmij 10
					dealerScore -= 10;
			}
			updateCardPanels(); // Wyswietl nowe karty dealera

			// Określ ostateczne rezultaty, dodaj zysk i jeśli jest pokaż wynik
			if (playerScore > dealerScore) { // Gracz wygrał
				lblInfo.setText("Wygrałeś! Zysk: $" + betAmount);
				kieszen += betAmount * 2;
				lblHowKasaWKieszeni.setText(String.format("$%.2f", kieszen));
			} else if (dealerScore == 21) { // Dealer blackjack
				lblInfo.setText("Dealer ma BlackJack! Strata: $" + betAmount);
			} else if (dealerScore > 21) { // Dealer bust
				lblInfo.setText("Dealer przekroczył 21! Zysk: $" + betAmount);
				kieszen += betAmount * 2;
				lblHowKasaWKieszeni.setText(String.format("$%.2f", kieszen));
			} else if (playerScore == dealerScore) { // Remis
				lblInfo.setText("Push!");
				kieszen += betAmount;
				lblHowKasaWKieszeni.setText(String.format("$%.2f", kieszen));
			} else { // Dealer wygrał
				lblInfo.setText("Dealer wygrał! Strata: $" + betAmount);
			}
			outcomeHappened(); // Ina koniec rundy wyswietl rezultat i przycisk continue

		}
		
		/**
	     * Metoda ktora wyswietla karty przeciwnika i odtwarza obraz
	     * 
	     */
		
		public static void updateCardPanels() { // wyswietla karty przeciwnika i odtwarza obraz
			if (dealerCardPanel != null) { // jezeli już jest dodane usuwa je
				frame.getContentPane().remove(dealerCardPanel);
				frame.getContentPane().remove(playerCardPanel);
			}
			// tworzymy 2 panele
			dealerCardPanel = new CardGroupPanel(dealerCards, 420 - (dealerCards.getCount() * 40), 50, 70, 104, 10);
			frame.getContentPane().add(dealerCardPanel);
			playerCardPanel = new CardGroupPanel(playerCards, 420 - (playerCards.getCount() * 40), 300, 70, 104, 10);
			frame.getContentPane().add(playerCardPanel);
			frame.repaint();
		}

		
		/**
	     * Metoda ktora wywoluje sie po nacisieciu continue czyli kasuje karty na stole i restartuje wynik
	     * 
	     */
		
		public static void continPoWyniku() { // Po osiagnieciu wyniku

			lblInfo.setOpaque(false);
			lblInfo.setForeground(Color.ORANGE);
			
			// usuniecie aktualnej rundy

			frame.getContentPane().remove(lblDealer);
			frame.getContentPane().remove(lblPlayer);
			frame.getContentPane().remove(btnHit);
			frame.getContentPane().remove(btnStand);
			frame.getContentPane().remove(lblBetAmount);
			frame.getContentPane().remove(lblBetAmountDesc);
			frame.getContentPane().remove(btnContinue);
			frame.getContentPane().remove(dealerCardPanel);
			frame.getContentPane().remove(playerCardPanel);
			lblInfo.setText("By grać dalej naciśnij Deal ");
			tfBetAmount.setEnabled(true);
			btnDeal.setEnabled(true);
			btnDeal.requestFocus();
			frame.repaint();

			if (kieszen <= 0) { // jezeli nie masz kasy by grac dalej
				int choice = JOptionPane.showOptionDialog(null, "Nie masz już pieniedzy dodać 100$ do twojej kasy ?.", "Z funduszy", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (choice == JOptionPane.YES_OPTION) {
					kieszen += 100;
					lblHowKasaWKieszeni.setText(String.format("$%.2f", kieszen));
				} else {
					frame.getContentPane().removeAll();
					frame.repaint();
					initGuiObjects();
					return;
				}
			}

			roundCount++; // jezeli runda 5 bedzie to ponownie przetasuje karty
			if (roundCount >= 5) {
				deck.initFullDeck();
				deck.shuffle();

				lblShuffleInfo = new JLabel("Deck zostal uzupelniony i przetasowany!");
				//lblShuffleInfo.setBackground(new Color(0, 128, 0));
				lblShuffleInfo.setForeground(Color.ORANGE);
				//lblShuffleInfo.setOpaque(true);
				lblShuffleInfo.setFont(new Font("Arial", Font.BOLD, 20));
				lblShuffleInfo.setHorizontalAlignment(SwingConstants.CENTER);
				lblShuffleInfo.setBounds(235, 307, 430, 42);
				frame.getContentPane().add(lblShuffleInfo);

				roundCount = 0;
			}
		}
		
		/**
	     * Metoda uruchamiajaca
	     * @param args - domyślna tablica Stringów w celu poprawnego wywołania metody statycznej main(). 
	     */
	public static void main(String[] args){

		
		initGuiObjects();
		frame.setVisible(true);
		
	}
}
