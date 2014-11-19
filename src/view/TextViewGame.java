package view;

import model.GermFighter;
import model.MoveDirection;

public class TextViewGame {
	final static int MAP_SIZE = 5;
	private static GermFighter game;
	
	public static void main(String[] args) {
		game = new GermFighter(MAP_SIZE);
		game.printMap(MAP_SIZE);
		game.printPrompt();
		game.move(game.getGerm(), MoveDirection.Right);
		game.move(game.getGerm(), MoveDirection.Right);
		game.move(game.getGerm(), MoveDirection.Down);
		game.move(game.getGerm(), MoveDirection.Down);
		game.move(game.getGerm(), MoveDirection.Down);
		//game.move(game.getWbc(), MoveDirection.Down);

		System.out.println(game.getGerm().getItem().getItemName());
		game.printMap(MAP_SIZE);
	}
}
