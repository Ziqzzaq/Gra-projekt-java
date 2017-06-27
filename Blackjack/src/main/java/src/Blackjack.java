package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Blackjack {
	
	
	
	private static JFrame frame = new MainFrame();
	
	
	
	private static JButton btnNewGame;	//	przycisk nowa gra
	private static JButton btnEndGame;	//	przycisk koniec gry
	private static JTextField tfBalance;	//	pole tekstowe do zapisania kasy ktora mamy na poczatku
	private static JLabel lblInitialBalance;  // tekst do pczatkowej kasy
	
	private static double kieszen = 0.0; // zapis ile masz w banku
	
	private static int betAmount = 0, roundCount = 0;  // zmienne do obstawiania
	
	private static JLabel lblHowInitial; // napisy ile ma
	private static JLabel lblHowKasaWKieszeni;  // ile masz kasy w kieszeni
	
	private static JLabel lblPrzedstawienie; // napis nasz ze projetk
	
	private static JLabel lblInfo; // informacje o błedach itp.

	
	private static JLabel lblEnterBet; // napis
	private static JTextField tfBetAmount; // pole do wpisywania ile obstawisz
	private static JButton btnDeal;  // przycisk do obstawiania
	private static JButton btnHit;
	private static JButton btnStand;
	
	private static JLabel lblBetAmount;
	private static JLabel lblBetAmountDesc;
	private static JLabel lblShuffleInfo = null;
	
	private static CardGroup deck, dealerCards, playerCards;
	
	private static JLabel lblDealer;
	private static JLabel lblPlayer;
	
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
	
	public static void showBetGui() {  // funkcja do przycisków obstawiania  po prawej stronie
		
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
	
	
	public static boolean convertStringtoInt(String s) { // zmiana ze stringa na inta w polu tekstowym tfBalance musi byc liczba calkowita
		try {
			if (Integer.parseInt(s) > 0) // Ensure amount entered is > 0
				return true;
			else
				return false;
		} catch (NumberFormatException e) { // If not valid integer
			return false;
		}
	}
	
	
	
	
	public static void newGame(){ // nowa funkcja zapisze bo ci nie chce psuc Michal
		
		if (convertStringtoInt(tfBalance.getText()) == true) { // sprawdzanie czy kasa sie zgadza
			kieszen = Integer.parseInt(tfBalance.getText());
		} else {
			JOptionPane.showMessageDialog(frame, "Nie prawidlowa waga... czy jest to liczba całkowita??.", "Error", JOptionPane.ERROR_MESSAGE);
			tfBalance.requestFocus();
			return;
		}

		btnNewGame.setEnabled(false);
		tfBalance.setEnabled(false);
		
		showBetGui();  // i dopiero odpalimy Gui po prawej
		
	}
		public static void deal() { // Działa po naciśnięciu przycisku Deal. Przycisk Deal wstępnie ma wyswtietlic aktualna gre ale to sie zobaczy..
			
			if (lblShuffleInfo != null) // (Every 5 rounds the deck is reshuffled and this label is displayed. Hide it when a new round is started
				frame.getContentPane().remove(lblShuffleInfo);

			// Initialise dealer/player card arrays
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
			
			
			lblDealer = new JLabel("Dealer"); // Dealer label
			lblDealer.setForeground(Color.WHITE);
			lblDealer.setFont(new Font("Arial Black", Font.BOLD, 20));
			lblDealer.setBounds(415, 158, 82, 28);
			frame.getContentPane().add(lblDealer);

			lblPlayer = new JLabel("Player"); // Player label
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
			
			
			
			
			
			
			
			
			
			btnHit = new JButton("Hit"); // Hit button
			btnHit.setBounds(290, 515, 140, 35);
			btnHit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// cos po naciśnieciu
				}
			});
			frame.getContentPane().add(btnHit);
			btnHit.requestFocus();

			btnStand = new JButton("Stand"); // Stand button
			btnStand.setBounds(470, 515, 140, 35);
			btnStand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// cos po nacisnieciu
				}
			});
			frame.getContentPane().add(btnStand);
			btnStand.requestFocus();
			frame.repaint();
		}
		
		
	
	public static void main(String[] args){

		
		initGuiObjects();
		frame.setVisible(true);
		
	}
}
