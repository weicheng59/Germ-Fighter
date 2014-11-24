package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class GameController extends JPanel
{
	private JPanel movementPanel;
	private JPanel actionPanel;
	
	private JButton up;
	private JButton left;
	private JButton right;
	private JButton down;
	
	private JButton useItem;
	private JButton endTurn;
	private JButton special;
	
	public GameController()
	{
		setLayout(new GridLayout(2,1));
		
		movementPanel = new JPanel();
		movementPanel.setLayout(new GridLayout(2,3));
		up = new JButton("Up");
		left = new JButton("Left");
		right = new JButton("Right");
		down = new JButton("Down");
		movementPanel.add(new JPanel());
		movementPanel.add(up);
		movementPanel.add(new JPanel());
		movementPanel.add(left);
		movementPanel.add(down);
		movementPanel.add(right);
		
		actionPanel = new JPanel();
		actionPanel.setLayout(new GridLayout(1,3));
		useItem = new JButton("Use Item");
		endTurn = new JButton("End Turn");
		special = new JButton("Use Special");
		actionPanel.add(useItem);
		actionPanel.add(endTurn);
		actionPanel.add(special);
		
		add(actionPanel);
		add(movementPanel);
	}
}