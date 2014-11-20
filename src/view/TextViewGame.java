package view;

import java.util.Scanner;

import model.*;
import model.Cell.Team;

/**
 * This class is the actual textView game class
 * @author Weicheng Yu
 *
 */

public class TextViewGame {
	final static int MAP_SIZE = 5;
	final static int CREW_SIZE = 1;
	final static int ROLL_BOUND = 100;
	private static GermFighter game;
	private static Player p1, p2;
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Setup Map and Welcome info
		game = new GermFighter(MAP_SIZE);
		game.printPrompt();
		
		// Player 1 choose team
		game.setPrompt("Player 1 please choose team: Germ or Virus");
		game.printPrompt();
		String input = scan.next().toLowerCase();
		while (!input.contains("germ") && !input.contains("virus")) {
			game.printInvalidInput();
			input = scan.next().toLowerCase();
		}
		
		if(input.equals("germ")) {
			p1 = new Player(Team.GERM, 1);
			p2 = new Player(Team.VIRUS, 2);
		}
		else if(input.equals("virus")) {
			p1 = new Player(Team.VIRUS, 1);
			p2 = new Player(Team.GERM, 2);
		}
		
		// Players choose crew
		chooseCrew(p1);
		chooseCrew(p2);
		game.setPrompt("Team setup done!\nThe game starts!");
		game.printPrompt();
		
		// Spawn cells on maps
		// For iteration 1 we use a preset spawning location
		
		
		
		// Decide who goes first
		// the player go first will have its goFirst boolean set to true
		roll(p1, p2);
		
		// Set newTurn so the goFirst player can move his/her units
		if(p1.goFirst())
			p1.newTurn();
		else
			p2.newTurn();
	}
	
	private static void roll(Player p1, Player p2) {
		game.setPrompt("Both player will roll a number out of " + ROLL_BOUND 
				+ " to decide which player goes first.");
		game.printPrompt();

		int roll1 = p1.Roll(ROLL_BOUND);
		int roll2 = p2.Roll(ROLL_BOUND);
		
		game.setPrompt("Player 1 rolled: " + roll1 );
		game.printPrompt();

		game.setPrompt("Player 2 rolled: " + roll2 );
		game.printPrompt();
		
		while (roll1 == roll2) {
			game.setPrompt("Deuce! Roll again");
			game.printPrompt();
			roll1 = p1.Roll(ROLL_BOUND);
			roll2 = p2.Roll(ROLL_BOUND);
			game.setPrompt("Player 1 rolled: " + roll1 );
			game.printPrompt();
			game.setPrompt("Player 2 rolled: " + roll2 );
			game.printPrompt();
		}
		
		if (roll1 > roll2) {
			game.setPrompt("Player 1 goes first!");
			p1.setGoFirst(true);
		}
		else if (roll1 < roll2) {
			game.setPrompt("Player 2 goes first!");
			p2.setGoFirst(true);
		}
		game.printPrompt();
	}
	
	private static void chooseCrew(Player aPlayer) {
		for (int i = 0; i < CREW_SIZE; i++) {
			game.setPrompt("Player " + aPlayer.getPlayerNum() + " please choose your crew: "
					+ "\nYou could choose upto " + CREW_SIZE 
					+ " crew member from the list. (input number)\n"
					+ "1, Basic\n2, Ranged\n3, Tank\n4, Medic\n5, Splash" 
					+ "\n*For this beta version only Basic is avaiable*");
			game.printPrompt();
		
			int cellType = scan.nextInt();
			while(cellType > 1 || cellType <= 0) {
				game.printInvalidInput();
				cellType = scan.nextInt();
			}
			switch (cellType) {
				case 1: 
					if(aPlayer.getTeam() == Team.GERM)
						aPlayer.addCell(new GermBasic(Team.GERM));
					else
						aPlayer.addCell(new GermBasic(Team.VIRUS));
					break;
					
				// Dont worry about these in Iter 1	
//				case 2:
//					aPlayer.addCell(new GermRanged());
//					break;
//				case 3:
//					aPlayer.addCell(new GermTank());
//					break;
//				case 4:
//					aPlayer.addCell(new GermMedic());
//					break;
//				case 5:
//					aPlayer.addCell(new GermSplashAttacker());
//					break;
				default:
					break;
			}
		} // End of for loop
	}
}
