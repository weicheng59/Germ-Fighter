package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import model.GermFighter;

public class GameFrame extends JFrame{
	
	public static void main(String[] args){
		new GameFrame();
	}
	
	private JFrame frame;
	private JTabbedPane severalPanels;
	private TextViewGame theGame;
	private TextView textView;
	private GameGraphicView graphicView;
	
	private JMenuBar menu;// << options menu bar
	private JMenu openMenu, aboutMenu;// gives options and game info
	private JMenuItem saveItem, closeItem, closeItem2, gameItem, instructionsItem, aboutItem, unitItem, exitItem;// << for both menus
	
	private JPanel inputCommandPanel;
	private JTextArea commanderGuider;
	
	private String instructions = "1.) Select your team, germs or wbc (white blood cells). \n"
			+ "2.) Choose your units for you team. \n"
			+ "3.) An automatic roll will determine who goes first. \n"
			+ "4.) To select a unit, enter the number it is under.  Type 0 to end turn. \n"
			+ "5.) When selected, type 1 to allow movement, 2 to attack, or 3 to use an item.\n"
			+ "**Beware, you are limited to six action points per unit: moving costs one per space, using an item uses two, and attacking costs two or ends!"
			+ "6.) Guide your units across to defeat your opponent! Have fun!";
	
	private String gameInfo = "Welcome to Germ-Fighter! Microscopic cells battle each other \n"
			+ "to see whether the body stays healty or succumbs to disease!\n"
			+ "Will the round White Blood Cells (WBC) fend off invading germs or\n"
			+ "will the edged shaped Germs overcome the WBCs? Find out...\n"
			+ "In Germ-Fighter!";
	
	private String about = "Game Creators:  Brandon Wong, Weicheng Yu, Jacob Rothenburg\n"
							+ "CSC 335 Final Project\n"
							+ "Instructor:  Rick Mercer\n"
							+ "Project Manager:  Ben Whitely\n"
							+ "Iteration 1 completed 11/23/14\n"
							+ "Iteration 2 completed _________";
	
	private String unitInfo = "Basic WBC and Germ: \n Attacks vertically and horizontally.  Can carry two items. \n"
			+ "Starting stats: 10 health, 4 attack, 1 space max attack range, 6 space max moving range.";
	
	public GameFrame(){
		theGame = new TextViewGame();
		layoutGameGUI();
		setUpModelAndObservers();
		theGame.gameStart();
	}

	private void layoutGameGUI(){
		frame = new JFrame("Germ-Fighter!");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		menu = new JMenuBar();
		openMenu = new JMenu("Options");
		aboutMenu = new JMenu("About Germ-Fighter");
		menu.add(openMenu);
		menu.add(aboutMenu);
		
		// save game option [[Option Menu]]
		saveItem = new JMenuItem("Save Game", KeyEvent.VK_1);
		saveItem.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 /*
				  * Enter a save game code
				  * to save progress
				  * 
				  */
				JOptionPane.showMessageDialog(saveItem, "Work In Progress");

			 }
		});
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		saveItem.getAccessibleContext();
		
		// close the menu
        closeItem = new JMenuItem("Close", KeyEvent.VK_T);// Closes the drop down list
        closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        closeItem.getAccessibleContext();
        
		// close the menu
        closeItem2 = new JMenuItem("Close", KeyEvent.VK_T);// Closes the drop down list
        closeItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        closeItem2.getAccessibleContext();
        
        // exit the program
        exitItem = new JMenuItem("Exit", KeyEvent.VK_T );// Exits the program immediately
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        exitItem.getAccessibleContext();
        
        // game information (synopsis)
        gameItem = new JMenuItem("Game Story", KeyEvent.ALT_MASK);
        gameItem.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(gameItem, gameInfo);
			 }
		});
        gameItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        gameItem.getAccessibleContext();
        
        // about the game
        aboutItem = new JMenuItem("About the game", KeyEvent.ALT_MASK);
        aboutItem.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(aboutItem, about);
			 }
		});
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        aboutItem.getAccessibleContext();
        
        // gives game instructions
        instructionsItem = new JMenuItem("Instructions", KeyEvent.VK_T);
        instructionsItem.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(instructionsItem, instructions);
			 }
		});
        instructionsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        instructionsItem.getAccessibleContext();
        
        // gives unit information
        unitItem = new JMenuItem("Unit Infomation", KeyEvent.VK_T);
        unitItem.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 /*
				  * Gives unit information
				  * 
				  */
				 JOptionPane.showMessageDialog(unitItem, unitInfo);
			 }
		});
        unitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        unitItem.getAccessibleContext();
		
		openMenu.add(saveItem);
		openMenu.add(closeItem);
		openMenu.add(exitItem);
		aboutMenu.add(gameItem);
		aboutMenu.add(aboutItem);
		aboutMenu.add(instructionsItem);
		aboutMenu.add(unitItem);
		aboutMenu.add(closeItem2);
			
		textView = new TextView(theGame);
		graphicView = new GameGraphicView(theGame);
		
		severalPanels = new JTabbedPane();
		severalPanels.setSize(500,525);
		severalPanels.setLocation(0, 0);
		severalPanels.add(graphicView, "GUI View");
		severalPanels.add(textView, "Text View");
		
		inputCommandPanel = new JPanel();
		inputCommandPanel.setLayout(new GridLayout(1,1));

		// make the prompt font color White to contrast^^^
		
		JPanel unitsAndItems = new JPanel();
		unitsAndItems.add(new JLabel("Put Unit and Item information below here (Later)"));
		
		commanderGuider = new JTextArea("Type in game commands back in the console in order to play! Buttons here later!");
		commanderGuider.setEditable(false);
		inputCommandPanel.add(commanderGuider);
		
		JPanel arranger1 = new JPanel();
		arranger1.setLayout(new BorderLayout());
		arranger1.add(severalPanels, BorderLayout.CENTER);
		arranger1.add(unitsAndItems, BorderLayout.EAST);
		arranger1.add(inputCommandPanel, BorderLayout.SOUTH);
		
		frame.add(menu, BorderLayout.NORTH);
		frame.add(arranger1, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void setUpModelAndObservers() {
		theGame.addObserver((Observer) textView);
		theGame.addObserver((Observer) graphicView);
	//	theGame.addObserver((Observer) prompt);
	}
}
