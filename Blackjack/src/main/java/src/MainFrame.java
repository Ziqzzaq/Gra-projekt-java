package src;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	//tworzenie okna 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainFrame() {
		setTitle("Blackjack");
		setSize(900, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		ImagePanel bgImagePanel = new ImagePanel("background.png");
		bgImagePanel.setBounds(0, 0, this.getWidth(), this.getHeight());
		setContentPane(bgImagePanel);
	}

}
