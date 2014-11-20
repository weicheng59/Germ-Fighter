package view;
import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class GameScreen extends JFrame
{
	private JFrame frame;
	private JPanel graphicView;
	private GameControllerPanel controller;
	private JTabbedPane viewTabs;
	private GermGame game;
	
	public GameScreen()
	{
		game = new GermGame(10, 1, 5, 9, 5);
		graphicView = new GraphicalView(game);
		game.addObserver((Observer) graphicView);
		
		frame = new JFrame("Germ Fighter");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		//mainPanel.setSize(100, 100);
		this.add(graphicView,BorderLayout.CENTER);
		
		controller = new GameControllerPanel();
		frame.add(controller,BorderLayout.SOUTH);
		
		
		
		
		frame.setVisible(true);
	}
	public static void main(String[]args)
	{
		new GameScreen();
	}
	
}
