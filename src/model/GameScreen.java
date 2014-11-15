import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameScreen 
{
	private JFrame frame;
	private JPanel mainPanel;
	private GameController controller;
	
	public GameScreen()
	{
		frame = new JFrame("Germ Fighter");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		//mainPanel.setSize(100, 100);
		frame.add(mainPanel,BorderLayout.CENTER);
		
		controller = new GameController();
		frame.add(controller,BorderLayout.SOUTH);
		
		
		frame.setVisible(true);
	}
	public static void main(String[]args)
	{
		new GameScreen();
	}
	
}
