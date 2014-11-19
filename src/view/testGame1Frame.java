package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import model.GermFighter;

public class testGame1Frame extends JFrame{
	
	public static void main(String[] args){
		new testGame1Frame();
	}
	
	private JFrame frame;
	private JTabbedPane severalPanels;
	private GermFighter theGame;
	private testTextView testTextView;
	
//	private JComboBox options;//<<<< drop down list that has options
	private JMenuBar menu;// << options menu bar
	private JMenu openMenu, aboutMenu;// gives options and game info
	private JMenuItem saveItem, closeItem, closeItem2, instructionsItem, unitItem, exitItem;// << for both menus
	
	private JButton promptGoesHere, controlsGoHere;
/*	private JPanel textView;
	private JPanel graphicView;
	private JPanel prompt;*/
	
	public testGame1Frame(){
		theGame = new GermFighter(5);
		layoutGameGUI();
		setUpModelAndObservers();
	}

	private void layoutGameGUI(){
		frame = new JFrame("Germ-Fighter!");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		// drop down list that has options
	/*	options = new JComboBox();
		options.addItem("Save game");
		options.addItem("Close window");
		options.addItem("Exit game");*/
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
        
        // gives game instructions
        instructionsItem = new JMenuItem("Instructions", KeyEvent.VK_T);
        instructionsItem.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 /*
				  *Gives game control instructions
				  * 
				  */
			 }
		});
        instructionsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        instructionsItem.getAccessibleContext();
        
        // gives unit information
        unitItem = new JMenuItem("Unit Infomation", KeyEvent.VK_T);
        unitItem.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 /*
				  * Gives unit information
				  * 
				  */
			 }
		});
        unitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        unitItem.getAccessibleContext();
		
		openMenu.add(saveItem);
		openMenu.add(closeItem);
		openMenu.add(exitItem);
		aboutMenu.add(instructionsItem);
		aboutMenu.add(unitItem);
		aboutMenu.add(closeItem2);
		
		//TODO: For the GUI view
		JPanel mapPanel = new JPanel();
		mapPanel.setSize(500, 550);
		mapPanel.setLocation(200, 0);
		mapPanel.setLayout(null);
		//**************************
		
		testTextView = new testTextView(theGame);
		
		severalPanels = new JTabbedPane();
		severalPanels.setSize(500,525);
		severalPanels.setLocation(0, 0);
		severalPanels.add(testTextView, "Text View");
		severalPanels.add(mapPanel, "GUI View");
		
		// just a reminder for prompt to tell what is going on (replaced according to action)
		promptGoesHere = new JButton("Our prompt (updating) will go in here!");
		// just a reminder that controls go down here
		controlsGoHere = new JButton("Controls go here!");
		
		JPanel arranger1 = new JPanel();
		arranger1.setLayout(new BorderLayout());
		arranger1.add(severalPanels, BorderLayout.CENTER);	
		arranger1.add(promptGoesHere, BorderLayout.SOUTH);
		arranger1.add(controlsGoHere, BorderLayout.EAST);
		
		frame.add(menu, BorderLayout.NORTH);
		frame.add(arranger1, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	private void setUpModelAndObservers() {
	/*	theGame.addObserver((Observer) textView);
		theGame.addObserver((Observer) graphicView);
		theGame.addObserver((Observer) prompt);*/
	}
}
