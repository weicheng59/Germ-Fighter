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
	private static boolean isP1turn; // store whoes turn
	
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
		game.SpawnCell(p1.getCrew().get(0));
		game.SpawnCell(p2.getCrew().get(0));
		game.SpawnItem(new HealthPack());
		
		// Decide who goes first
		// the player go first will have its goFirst boolean set to true
		roll(p1, p2);
		
		// Set newTurn so the goFirst player can move his/her units
		if(p1.goFirst())
			isP1turn = true;
		 else 
			isP1turn = false;
		
		// Show the map
		game.printMap(MAP_SIZE);
		
		while (!p1.isLost() && !p2.isLost()) {
			if (isP1turn) {
				p1.newTurn();
				while(p1.turnEnd() == false) {
					game.setPrompt("Player 1 please choose crew member to control. (input number)"
							+ "\nOr input 0 to end turn.");
					game.printPrompt();
					p1.printCrew();
					
					int crewIndex = scan.nextInt();
					while(crewIndex > 1 || crewIndex < 0) {
						game.printInvalidInput();
						crewIndex = scan.nextInt();
					}
					switch (crewIndex) {
					case 0:
						p1.endTurn();
						isP1turn = false;
						break;
					case 1:
						controlCell(p1, 0);
						break;
					// Dont worry about other cells for iteration1
						
					}
				}
			} else {
				p2.newTurn();
				while(p2.turnEnd() == false) {
					game.setPrompt("Player 2 please choose crew member to control. (input number)"
							+ "\nOr input 0 to end turn.");
					game.printPrompt();
					p2.printCrew();
					
					int crewIndex = scan.nextInt();
					while(crewIndex > 1 || crewIndex < 0) {
						game.printInvalidInput();
						crewIndex = scan.nextInt();
					}
					switch (crewIndex) {
					case 0:
						p2.endTurn();
						isP1turn = true;
						break;
					case 1:
						controlCell(p2, 0);
						break;
						
					// Dont worry about other cells for iteration1
						
					}
				} 
			}
		}
		
		// Show game over information and who wins
		if (p1.isLost())
			game.setPrompt("Player 2 wins!\nGame Over!");
		else
			game.setPrompt("Player 1 wins!\nGame Over!");
		game.printPrompt();
	}
	
	private static void controlCell(Player player, int i) {
		game.setPrompt("Please choose an action to perform. (input number)"
				+ "\nOr input 0 to return to the crew member choosing menu."
				+ "\n1. Move\n2. Attack\n3. Use item (not avaible in this beta)");
		game.printPrompt();
		int actionIndex = scan.nextInt();
		while (actionIndex != 0) {
			switch (actionIndex) {
			case 1:
				move(player, i);
				break;
			case 2:
				attack(player, i);
				actionIndex = 0;
				break;
			}
			game.setPrompt("Please choose an action to perform. (input number)"
					+ "\nOr input 0 to return to the crew member choosing menu."
					+ "\n1. Move\n2. Attack\n3. Use item (not avaible in this beta)");
			game.printPrompt();
			actionIndex = scan.nextInt();
		}
	}
	
	private static void attack(Player player, int i) {
		game.setPrompt("Choose a direction to attack. (input wasd)" 
					+"\nOr input f to finish attack and return to the previous menu.");
		game.printPrompt();
		game.printMap(MAP_SIZE);
		Cell aCell = player.getCrew().get(i);
		int x = aCell.getLocationX(), y = aCell.getLocationY(), prompt = 0;
		String attackDirection = scan.next();
			if (attackDirection.equals("w")) {
				prompt = aCell.attack(game.getRoom(y-1, x).getCell());
				if (prompt == 3) {
					if (player.getPlayerNum() == 1)
						p2.removeCell(game.getRoom(y-1, x).getCell());
					else
						p1.removeCell(game.getRoom(y-1, x).getCell());
				}
			}
			else if (attackDirection.equals("a")) {
				prompt = aCell.attack(game.getRoom(y, x-1).getCell());
				if (prompt == 3) {
					if (player.getPlayerNum() == 1)
						p2.removeCell(game.getRoom(y, x-1).getCell());
					else
						p1.removeCell(game.getRoom(y, x-1).getCell());
				}
			}
			else if (attackDirection.equals("s")) {
				prompt = aCell.attack(game.getRoom(y+1, x).getCell());
				if (prompt == 3) {
					if (player.getPlayerNum() == 1)
						p2.removeCell(game.getRoom(y+1, x).getCell());
					else
						p1.removeCell(game.getRoom(y+1, x).getCell());
				}
			}
			else if (attackDirection.equals("d")) {
				prompt = aCell.attack(game.getRoom(y, x+1).getCell());
				if (prompt == 3) {
					if (player.getPlayerNum() == 1)
						p2.removeCell(game.getRoom(y+1, x).getCell());
					else
						p1.removeCell(game.getRoom(y+1, x).getCell());
				}
			}
			else if (attackDirection.equals("f")) {
				game.setPrompt("Finish attacking.");
				game.printPrompt();
			}
	}
	
	private static void move(Player player, int i) {
		Cell aCell = player.getCrew().get(i);
		game.setPrompt("Now you have acess to move " + aCell.getCellName() 
				+ " til the cell run out of action points. (input wasd)" 
				+ "\nOr input f to finish move and return to the previous menu.");
		game.printPrompt();
		String moveDirection = scan.nextLine();
		while(!moveDirection.equals("f")) {
			if (moveDirection.equals("w"))
				game.move(aCell, MoveDirection.Up);
			else if (moveDirection.equals("a"))
				game.move(aCell, MoveDirection.Left);
			else if (moveDirection.equals("s"))
				game.move(aCell, MoveDirection.Down);
			else if (moveDirection.equals("d"))
				game.move(aCell, MoveDirection.Right);
			game.printMap(MAP_SIZE);
			moveDirection = scan.nextLine();
		}
		game.setPrompt("Finish moving.");
		game.printPrompt();
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
			game.setPrompt("Player 1 goes first!\n");
			p1.setGoFirst(true);
		}
		else if (roll1 < roll2) {
			game.setPrompt("Player 2 goes first!\n");
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
