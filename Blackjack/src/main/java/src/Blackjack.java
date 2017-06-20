package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Blackjack {
	
	
	
	private static JFrame frame = new MainFrame();
	
	
	
	private static JButton btnNewGame;  // przycisk nowa gra
	private static JButton btnEndGame;  // przycisk koniec gry
	
	
	
	public static void initGuiObjects() {
		btnNewGame = new JButton("New Game"); // przycisk nowa gra
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // co się dzieje po wcisnieciu nowa gra
				//newGame(); 
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
		
		
	}
	
	
		
	
	public static void main(String[] args){

		
		initGuiObjects();
		frame.setVisible(true);
		
	}
}
