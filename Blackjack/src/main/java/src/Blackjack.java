package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Blackjack {
	
	
	
	private static JFrame frame = new MainFrame();
	
	
	
	private static JButton btnNewGame;
	
	
	
	
	public static void initGuiObjects() {
		btnNewGame = new JButton("New Game"); // przycisk nowa gra
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // co się dzieje po wcisnieciu nowa gra
				//newGame(); 
			}
		});
		
		btnNewGame.setBounds(20, 610, 99, 50);
		frame.getContentPane().add(btnNewGame);
	}
	
	
		
	
	public static void main(String[] args){

		
		initGuiObjects();
		frame.setVisible(true);
		
	}
}
