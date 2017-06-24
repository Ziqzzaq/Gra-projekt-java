package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Blackjack {
	
	
	
	private static JFrame frame = new MainFrame();
	
	
	
	private static JButton btnNewGame;	//	przycisk nowa gra
	private static JButton btnEndGame;	//	przycisk koniec gry
	private static JTextField tfBalance;	//	pole tekstowe do zapisania kasy ktora mamy na poczatku
	private static JLabel lblInitialBalance;  // tekst do pczatkowej kasy
	
	private static JLabel lblHowInitial; // napisy ile ma
	
	
	private static JLabel lblEnterBet; // napis
	private static JTextField tfBetAmount; // pole do wpisywania ile obstawisz
	private static JButton btnDeal;  // przycisk do obstawiania
	
	
	
	public static void initGuiObjects() { // ustawienie  głównych przyciskow po lewej stronie
		btnNewGame = new JButton("New Game"); // przycisk nowa gra
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // co się dzieje po wcisnieciu nowa gra
				showBetGui();
			}
		});
		
		btnNewGame.setBounds(20, 610, 99, 50);
		frame.getContentPane().add(btnNewGame);
		
		btnEndGame = new JButton("End Game"); // przycisk konca gry i resetuje program.
		btnEndGame.setEnabled(false);  // na razie go wylacze
		btnEndGame.setBounds(121, 610, 99, 50);
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
		tfBalance.setBounds(150, 580, 89, 28);
		frame.getContentPane().add(tfBalance);
		tfBalance.setColumns(10);
		
		lblInitialBalance = new JLabel("Ile chcesz kasy?:"); // napiss przy belce kasy
		lblInitialBalance.setFont(new Font("Arial", Font.BOLD, 13));
		lblInitialBalance.setForeground(Color.WHITE);
		lblInitialBalance.setBounds(10, 585, 250, 16);
		frame.getContentPane().add(lblInitialBalance);
		
		
	}
	
	public static void showBetGui() {  // funkcja do przycisków obstawiania  po prawej stronie
		
		btnEndGame.setEnabled(true);  // gdy new game to wączymy end game
		
		//juz dziala brakowalo na koncu funkcji frame.repaint();
		
		lblEnterBet = new JLabel("Kasa:"); // napis przy belce do obstawiania
		lblEnterBet.setFont(new Font("Arial", Font.BOLD, 14));
		lblEnterBet.setForeground(Color.WHITE);
		lblEnterBet.setBounds(700, 585, 250, 16);
		frame.getContentPane().add(lblEnterBet);
		
		
		

		lblHowInitial = new JLabel("W Kasie masz"); // napis
		lblHowInitial.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowInitial.setFont(new Font("Arial", Font.BOLD, 16));
		lblHowInitial.setForeground(Color.WHITE);
		lblHowInitial.setBounds(315, 578, 272, 22);
		frame.getContentPane().add(lblHowInitial);
		
		
		
		
		
		tfBetAmount = new JTextField(); // ile osbstawisz 
		tfBetAmount.setText("10");
		tfBetAmount.setBounds(790, 580, 89, 28);
		frame.getContentPane().add(tfBetAmount);
		
		
		btnDeal = new JButton("Deal"); // Deal button :D
		btnDeal.setBounds(679, 610, 200, 50);
		btnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cos sie stanie :D
			}
		});
		frame.getContentPane().add(btnDeal);
		btnDeal.requestFocus();
		
		
		frame.repaint();
	}
		
	
	public static void main(String[] args){

		
		initGuiObjects();
		frame.setVisible(true);
		
	}
}
